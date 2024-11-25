<template>
    <div class="comment-wrapper">
        <div class="comment-input-section">
            <h6 class="section-title">
                댓글 작성
            </h6>
            <div class="input-group border-0">
                <input type="text" class="form-control custom-input" placeholder="댓글을 입력하세요" v-model="comment"
                    @keyup.enter="submitComment">
                <button class="btn custom-button" type="button" @click="submitComment" :disabled="!comment.trim()">
                    등록
                </button>
            </div>
        </div>

        <!-- 댓글 목록 영역 -->
        <div class="comments-list">
            <div v-for="item in comments" :key="item.commentNo" class="comment-item">
                <div class="d-flex justify-content-between align-items-center">
                    <div class="d-flex align-items-center gap-2">
                        <div class="comment-avatar">
                            {{ item.userId ? item.userId.charAt(0).toUpperCase() : '?' }}
                        </div>
                        <div>
                            <div class="comment-writer">작성자: {{ item.userId }} (댓글번호: {{ item.commentNo }})</div>
                            <!-- 날짜 표시 방식 formatData 함수 사용 -->
                            <small class="text-muted">{{ formatDate(item.regDate) }}</small>
                        </div>
                    </div>
                    <!-- 댓글 사용자만 수정/삭제 가능하도록 조건부 렌더링 추가 -->
                    <div class="dropdown" v-if="isCommentOwner(item)">
                        <button class="btn btn-link btn-sm text-muted border-0 p-0" type="button"
                            data-bs-toggle="dropdown">
                            ⋮
                        </button>
                        <ul class="dropdown-menu shadow-sm border-0">
                            <li><a class="dropdown-item" href="#" @click.prevent="deleteComment(item.commentNo)">삭제</a>
                            </li>
                            <li><a class="dropdown-item" href="#" @click.prevent="reportComment(item.commentNo)">신고</a>
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
// 필요한 모듈들을 import
import { ref, onMounted } from 'vue'
import { useUserStore } from '@/stores/user'
import axios from 'axios'

// Pinia store 초기화
const userStore = useUserStore()

// axios 기본 URL 설정
axios.defaults.baseURL = 'http://localhost:8080'

// props 정의 - 부모 컴포넌트에서 게시글 번호를 받아옴
const props = defineProps({
    boardNo: {
        type: Number,
        required: true
    }
})

// 반응형 변수 선언
const comment = ref('')
const comments = ref([])

//초기 댓글 목록을 가져오는 함수 - 최초 1회만 실행
const fetchInitialComments = async () => {
    try {
        const token = localStorage.getItem('access-token'); // 토큰 가져오기
        const response = await axios.get(`/etco/comments/${props.boardNo}`, {
            headers: {
                'Authorization': token
            }
        });
        console.log('서버에서 받은 댓글 데이터:', response.data);
        
        if (Array.isArray(response.data)) {
            comments.value = response.data;
        } else {
            console.error('서버 응답이 배열이 아님:', response.data);
            comments.value = [];
        }
    } catch (error) {
        console.error('댓글 목록 조회 실패:', error);
        if (error.response) {
            console.error('에러 상세:', error.response.data);
            console.error('상태 코드:', error.response.status);
        }
        comments.value = []; // 에러 시 빈 배열로 초기화
        // 사용자에게 에러 메시지를 표시하지 않음 (옵션)
    }
}

// 댓글 작성 함수
const submitComment = async () => {
    if (!comment.value.trim()) {
        alert('댓글을 입력해주세요.');
        return;
    }

    const token = localStorage.getItem('access-token');
    const userId = localStorage.getItem('userId');
    
    if (!token || !userId) {
        alert('로그인이 필요한 서비스입니다.');
        return;
    }

    const commentData = {
        boardNo: props.boardNo,
        pCommentNo: 0,
        userId: userId,
        comment: comment.value
    };

    try {
        const response = await axios.post('/etco/comments', commentData, {
            headers: {
                'Authorization': token
            }
        });
        console.log('댓글 작성 응답:', response.data);

        if (response.data) {
            // 새로운 댓글을 목록에 추가
            comments.value.unshift(response.data);
            comment.value = '';
            alert('댓글이 등록되었습니다.');
        }
    } catch (error) {
        console.error('댓글 작성 실패:', error);
        if (error.response) {
            console.error('에러 상세:', error.response.data);
            console.error('상태 코드:', error.response.status);
        }
        alert('댓글 작성에 실패했습니다.');
    }
}

// 댓글 작성자 확인 함수
const isCommentOwner = (item) => {
    const currentUserId = localStorage.getItem('userId')
    return item.userId === currentUserId
}

//댓글 삭제 함수
const deleteComment = async (commentNo) => {
    if (!confirm('댓글을 삭제하시겠습니까?')) return;

    const token = localStorage.getItem('access-token');
    
    try {
        await axios.delete(`/etco/comments/${commentNo}`, {
            headers: {
                'Authorization': token
            }
        });

        comments.value = comments.value.filter(comment => comment.commentNo !== commentNo);
        alert('댓글이 삭제되었습니다.');
    } catch (error) {
        console.error('댓글 삭제 실패:', error);
        alert('댓글 삭제에 실패했습니다.');
    }
}

// 댓글 수정 함수
const updateComment = async (commentNo, commentText) => {
    const token = localStorage.getItem('access-token');
    
    try {
        const response = await axios.put(`/etco/comments/${commentNo}`, {
            commentNo: commentNo,
            boardNo: props.boardNo,
            pCommentNo: 0,
            userId: localStorage.getItem('userId'),
            comment: commentText
        }, {
            headers: {
                'Authorization': token
            }
        });

        const index = comments.value.findIndex(item => item.commentNo === commentNo);
        if (index !== -1) {
            comments.value[index] = response.data;
        }
        alert('댓글이 수정되었습니다.');
    } catch (error) {
        console.error('댓글 수정 실패:', error);
        alert('댓글 수정에 실패했습니다.');
    }
}
// 댓글 신고 함수 (미구현)
const reportComment = (commentNo) => {
    alert('댓글이 신고되었습니다.')
}


// 날짜 포맷팅 함수
const formatDate = (dateString) => {
    if (!dateString) return '';  // null 체크 추가
    const date = new Date(dateString)
    return date.toLocaleDateString('ko-KR', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit'
    })
}

// 컴포넌트 마운트 시 실행
onMounted(() => {
    // 로그인 상태 확인
    const token = localStorage.getItem('access-token');
    const userId = localStorage.getItem('userId');
    console.log('로그인 상태 확인:', {
        token: token ? '토큰 있음' : '토큰 없음',
        userId: userId
    });

    if (userStore.loginUser === null) {
        userStore.initializeUser();
    }
    
    // 초기 댓글 목록 로딩
    fetchInitialComments();
});
</script>

<style scoped>
.comment-wrapper {
    font-family: 'Noto Sans KR', sans-serif;
    margin-top: 20px;
}

.comment-input-section {
    background-color: #f8f9fa;
    margin-bottom: 20px;
}

.section-title {
    color: #495057;
    margin-bottom: 10px;
}

.custom-input {
    border-radius: 4px 0 0 4px;
}

.custom-input:focus {
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.custom-button {
    border-radius: 0 4px 4px 0;
    background-color: #007bff;
    color: white;
}

.custom-button:hover:not(:disabled) {
    background-color: #abd6fe !important;
}

.custom-button:disabled {
    background-color: #ccc;
}

.comments-list {
    display: flex;
    flex-direction: column;
    gap: 1rem;
}

.comment-item {
    padding: 15px;
    border-bottom: 1px solid #eee;
}

.comment-item:hover {
    transform: translateX(4px);
}

.comment-avatar {
    width: 32px;
    height: 32px;
    border-radius: 50%;
    background-color: #e9ecef;
    display: flex;
    align-items: center;
    justify-content: center;
    font-weight: bold;
}

.comment-writer {
    font-weight: 600;
}

.comment-content {
    margin-top: 8px;
    margin-left: 42px;
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