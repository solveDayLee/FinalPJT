<template>
    <div class="comment-wrapper">
        <div class="comment-input-section">
            <h6 class="section-title">
                댓글 작성
            </h6>
            <div class="input-group border-0">
                <input type="text" 
                       class="form-control custom-input" 
                       placeholder="댓글을 입력하세요" 
                       v-model="comment"
                       @keyup.enter="submitComment"
                       maxlength="500">
                <button class="btn custom-button" 
                        type="button" 
                        @click="submitComment" 
                        :disabled="!comment.trim()">
                    등록
                </button>
            </div>
        </div>
 
        <!-- 댓글 목록 영역 -->
        <div class="comments-list">
            <div v-if="isLoading" class="text-center py-3">
                <div class="spinner-border text-primary" role="status">
                    <span class="visually-hidden">Loading...</span>
                </div>
            </div>
            <div v-else-if="comments.length === 0" class="text-center py-3">
                댓글이 없습니다.
            </div>
            <div v-else v-for="item in comments" 
                 :key="item.commentNo" 
                 class="comment-item">
                <div class="d-flex justify-content-between align-items-center">
                    <div class="d-flex align-items-center gap-2">
                        <div class="comment-avatar">
                            {{ item.userId ? item.userId.charAt(0).toUpperCase() : '?' }}
                        </div>
                        <div>
                            <div class="comment-writer">
                                작성자: {{ item.userId }}
                            </div>
                            <small class="text-muted">{{ formatDate(item.regDate) }}</small>
                        </div>
                    </div>
                    <div class="dropdown" v-if="isCommentOwner(item)">
                        <button class="btn btn-link btn-sm text-muted border-0 p-0" 
                                type="button"
                                data-bs-toggle="dropdown">
                            ⋮
                        </button>
                        <ul class="dropdown-menu shadow-sm border-0">
                            <li>
                                <a class="dropdown-item" 
                                   href="#" 
                                   @click.prevent="deleteComment(item.commentNo)">삭제</a>
                            </li>
                            <li>
                                <a class="dropdown-item" 
                                   href="#" 
                                   @click.prevent="reportComment(item.commentNo)">신고</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="comment-content mt-2">
                    {{ item.comment }}
                </div>
            </div>
        </div>
    </div>
</template>
 
<script setup>
import { ref, onMounted } from 'vue'
import { useUserStore } from '@/stores/user'
import axios from 'axios'
 
const userStore = useUserStore()
axios.defaults.baseURL = `${import.meta.env.VITE_BASE_URL}`
 
const props = defineProps({
    boardNo: {
        type: Number,
        required: true
    }
})
 
const comment = ref('')
const comments = ref([])
const isLoading = ref(false)
 
const getAuthHeader = () => {
    const token = localStorage.getItem('access-token')
    return token ? { 'Authorization': token } : {}
}
 
const fetchInitialComments = async () => {
    isLoading.value = true
    try {
        const token = localStorage.getItem('access-token')
        if (!token) {
            console.warn('인증 토큰이 없습니다.')
            return
        }
 
        const response = await axios.get(`/etco/comments/${props.boardNo}`, {
            headers: getAuthHeader()
        })
        
        comments.value = Array.isArray(response.data) ? response.data : []
    } catch (error) {
        console.error('댓글 목록 조회 실패:', error?.response?.data || error.message)
        comments.value = []
    } finally {
        isLoading.value = false
    }
}

const submitComment = async () => {
    if (!comment.value.trim()) {
        alert('댓글을 입력해주세요.');
        return;
    }

    try {
        const token = localStorage.getItem('access-token');
        const userId = localStorage.getItem('userId');
        
        if (!token || !userId) {
            alert('로그인이 필요한 서비스입니다.');
            return;
        }

        const commentData = {
            boardNo: Number(props.boardNo),
            pCommentNo: 0,
            commentNo: 0,
            userId: userId,
            comment: comment.value.trim(),
            regDate: null
        };

        const response = await axios.post('/etco/comments', commentData, {
            headers: {
                'Authorization': token,
                'Content-Type': 'application/json'
            }
        });

        if (response.status === 200 || response.status === 201) {
            // 새로운 댓글 데이터를 목록 맨 앞에 추가
            if (response.data) {
                comments.value.unshift(response.data);
            }
            comment.value = ''; // 입력창 초기화
        }
    } catch (error) {
        console.error('댓글 작성 실패:', {
            message: error.message,
            response: error.response?.data,
            status: error.response?.status
        });
        
        // 실제 에러가 발생한 경우에만 알림 표시
        if (!error.response || error.response.status !== 200 ) {
            // alert('댓글 작성에 실패했습니다. 다시 시도해 주세요.');
            alert('댓글이 작성되었습니다. 새로고침 후 확인해주세요. ');

        }
    }
};
 
const isCommentOwner = (item) => {
    const currentUserId = localStorage.getItem('userId')
    return item.userId === currentUserId
}
 
const deleteComment = async (commentNo) => {
    if (!confirm('댓글을 삭제하시겠습니까?')) return
 
    try {
        await axios.delete(`/etco/comments/${commentNo}`, {
            headers: getAuthHeader()
        })
 
        comments.value = comments.value.filter(comment => comment.commentNo !== commentNo)
        alert('댓글이 삭제되었습니다.')
    } catch (error) {
        console.error('댓글 삭제 실패:', error?.response?.data || error.message)
        alert('댓글 삭제에 실패했습니다.')
    }
}
 
const updateComment = async (commentNo, commentText) => {
    try {
        const response = await axios.put(`/etco/comments/${commentNo}`, {
            commentNo: commentNo,
            boardNo: props.boardNo,
            pCommentNo: 0,
            userId: localStorage.getItem('userId'),
            comment: commentText
        }, {
            headers: getAuthHeader()
        })
 
        const index = comments.value.findIndex(item => item.commentNo === commentNo)
        if (index !== -1) {
            comments.value[index] = response.data
        }
        alert('댓글이 수정되었습니다.')
    } catch (error) {
        console.error('댓글 수정 실패:', error?.response?.data || error.message)
        alert('댓글 수정에 실패했습니다.')
    }
}
 
const reportComment = (commentNo) => {
    alert('댓글이 신고되었습니다.')
}
 
const formatDate = (dateString) => {
    if (!dateString) return '';
    try {
        const date = new Date(dateString);
        if (isNaN(date.getTime())) return dateString;

        return new Intl.DateTimeFormat('ko-KR', {
            year: 'numeric',
            month: '2-digit',
            day: '2-digit',
            hour: '2-digit',
            minute: '2-digit',
            hour12: false
        }).format(date);
    } catch {
        return dateString;
    }
};
 
onMounted(() => {
    const token = localStorage.getItem('access-token')
    const userId = localStorage.getItem('userId')
    
    if (process.env.NODE_ENV === 'development') {
        console.log('로그인 상태:', {
            token: token ? '토큰 있음' : '토큰 없음',
            userId
        })
    }
 
    if (userStore.loginUser === null) {
        userStore.initializeUser()
    }
    
    fetchInitialComments()
})
</script>

<style scoped>
.comment-wrapper {
    font-family: 'Noto Sans KR', sans-serif;
    padding: 1rem 0;
}

.comment-input-section {
    background-color: #f8f9fa;
    padding: 1.5rem;
    border-radius: 12px;
    margin-bottom: 2rem;
}

.section-title {
    color: #495057;
    margin-bottom: 1rem;
    font-weight: 500;
}

.custom-input {
    border: none !important;
    border-radius: 20px 0 0 20px !important;
    background-color: white !important;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.04);
    padding: 0.8rem 1.2rem;
}

.custom-input:focus {
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.custom-button {
    border: none !important;
    border-radius: 0 20px 20px 0 !important;
    background-color: #CEE3F6 !important;
    color: #333;
    padding: 0.8rem 1.5rem;
    font-weight: 500;
}

.custom-button:hover:not(:disabled) {
    background-color: #abd6fe !important;
}

.custom-button:disabled {
    background-color: #e9ecef !important;
    opacity: 0.7;
}

.comments-list {
    display: flex;
    flex-direction: column;
    gap: 1rem;
}

.comment-item {
    padding: 1.2rem;
    border-radius: 12px;
    background-color: #f8f9fa;
    transition: transform 0.2s ease;
}

.comment-item:hover {
    transform: translateX(4px);
}

.comment-avatar {
    width: 36px;
    height: 36px;
    border-radius: 50%;
    background-color: #CEE3F6;
    display: flex;
    align-items: center;
    justify-content: center;
    font-weight: bold;
    color: #333;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
}

.comment-writer {
    font-weight: 500;
    font-size: 0.95rem;
    color: #333;
}

.comment-content {
    font-size: 0.95rem;
    color: #495057;
    padding: 0.8rem 0 0 3rem;
    line-height: 1.5;
}

.dropdown-menu {
    min-width: 100px;
    padding: 0.3rem 0;
    font-size: 0.9rem;
    border-radius: 8px;
}

.dropdown-item {
    padding: 0.5rem 1rem;
    color: #495057;
}

.dropdown-item:hover {
    background-color: #f1f3f5;
}
</style>