<template>
    <div class="comment-wrapper">
        <div class="comment-input-section">
            <h6 class="section-title">
                댓글 작성
            </h6>
            <div class="input-group border-0">
                <input 
                    type="text" 
                    class="form-control custom-input" 
                    placeholder="댓글을 입력하세요" 
                    v-model="comment"
                    @keyup.enter="submitComment"
                >
                <button 
                    class="btn custom-button" 
                    type="button" 
                    @click="submitComment"
                    :disabled="!comment.trim()"
                >
                    등록
                </button>
            </div>
        </div>

        <!-- 댓글 목록 영역 -->
        <div class="comments-list">
            <div v-for="(item, index) in comments" :key="index" class="comment-item">
                <div class="d-flex justify-content-between align-items-center">
                    <div class="d-flex align-items-center gap-2">
                        <div class="comment-avatar">
                            {{ item.writer.charAt(0) }}
                        </div>
                        <div>
                            <div class="comment-writer">{{ item.writer }}</div>
                            <small class="text-muted">{{ item.date }}</small>
                        </div>
                    </div>
                    <div class="dropdown">
                        <button class="btn btn-link btn-sm text-muted border-0 p-0" type="button" data-bs-toggle="dropdown">
                            ⋮
                        </button>
                        <ul class="dropdown-menu shadow-sm border-0">
                            <li><a class="dropdown-item" href="#" @click.prevent="deleteComment(index)">삭제</a></li>
                            <li><a class="dropdown-item" href="#" @click.prevent="reportComment(index)">신고</a></li>
                        </ul>
                    </div>
                </div>
                <div class="comment-content">
                    {{ item.content }}
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue'

const comment = ref('')

// 샘플 댓글 데이터
const comments = ref([
    {
        writer: '홍길동',
        content: '좋은 글 감사합니다!',
        date: '2024.11.19 14:30'
    },
    {
        writer: '김철수',
        content: '매우 유익한 내용이네요.',
        date: '2024.11.19 15:45'
    }
])

const submitComment = () => {
    if(!comment.value.trim()) {
        alert('댓글을 입력해주세요.')
        return 
    }
    
    // 새 댓글 추가
    comments.value.unshift({
        writer: '사용자',
        content: comment.value,
        date: new Date().toLocaleDateString('ko-KR', {
            year: 'numeric',
            month: '2-digit',
            day: '2-digit',
            hour: '2-digit',
            minute: '2-digit'
        })
    })
    
    comment.value = ''
}

const deleteComment = (index) => {
    if(confirm('댓글을 삭제하시겠습니까?')) {
        comments.value.splice(index, 1)
    }
}

const reportComment = (index) => {
    alert('댓글이 신고되었습니다.')
}
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