<template>
    <div class="board-container" v-if="board">
      <div class="board-detail">
        <div class="category-wrapper">
          <h2 class="category">{{ board.category }}</h2>
        </div>
  
        <div class="content-wrapper">
          <div class="title-section">
            <div class="title">{{ board.title }}</div>
            <div class="meta-info">
              <span class="writer">{{ board.writer }}</span>
              <span class="date">{{ formatDate(board.regDate) }}</span>
              <span class="view-count">조회 {{ board.viewCnt }}</span>
              <button class="report-button" @click="handleReport">
                🚨 신고
              </button>
            </div>
          </div>
  
          <div class="main-content">
            <div class="text-content">{{ board.content }}</div>
            <div class="like-section">
              <button 
                class="like-button"
                :class="{ 'liked': isLiked }"
                @click="handleLike"
              >
                ❤️ {{ board.likes }}
              </button>
            </div>
          </div>
  
          <div class="button-section">
            <div></div>
            <button class="list-button" @click="goToList">목록</button>
          </div>
        </div>
  
        <div class="comment-section">
          <Comment />
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { useRouter } from 'vue-router'
  import { ref } from 'vue'
  import Comment from './Comment.vue'
  
  const router = useRouter()
  const isLiked = ref(false)
  
  const goToList = () => {
    router.push('/board')
  }
  
  const handleLike = async () => {
    await toggleLike(board.value.id)
    isLiked.value = !isLiked.value
  }
  
  const handleReport = () => {
    if (confirm('이 게시글을 신고하시겠습니까?')) {
      alert('신고가 접수되었습니다.')
    }
  }
  
  const formatDate = (date) => {
    return new Date(date).toLocaleDateString('ko-KR', {
      year: 'numeric',
      month: '2-digit',
      day: '2-digit',
      hour: '2-digit',
      minute: '2-digit'
    })
  }
  
  const board = ref({
    id: 1,
    category: '자유게시판',
    title: '첫 번째 게시글입니다',
    writer: '홍길동',
    regDate: '2024-11-19T10:30:00',
    viewCnt: 42,
    content: '안녕하세요! 이것은 게시판의 첫 번째 게시글입니다. 긴 내용의 텍스트가 들어갈 수 있는 본문 영역입니다. 게시글에 대한 자세한 내용을 작성할 수 있습니다.',
    likes: 15
  })
  </script>
  
  <style scoped>
  .board-container {
    max-width: 1024px;
    margin: 0 auto;
    padding: 2rem;
    background-color: #FBF8EF;
  }
  
  .board-detail {
    background-color: white;
    border-radius: 16px;
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.06);
    padding: 2.5rem;
  }
  
  .category-wrapper {
    margin-bottom: 2rem;
  }
  
  .category {
    display: inline-block;
    background-color: #9EC5FE; /* 더 진한 하늘색 */
    padding: 0.6rem 1.2rem;
    border-radius: 20px;
    font-size: 0.95rem;
    font-weight: 600;
    color: #1a365d; /* 더 진한 텍스트 색상 */
    box-shadow: 0 2px 8px rgba(158, 197, 254, 0.3);
  }
  
  .title-section {
    border-bottom: 2px solid #F3F0E6; /* 베이지색 계열의 구분선 */
    padding-bottom: 1.5rem;
    margin-bottom: 2rem;
  }
  
  .title {
    font-size: 1.7rem;
    font-weight: bold;
    margin-bottom: 1rem;
    color: #2d3748;
  }
  
  .meta-info {
    display: flex;
    gap: 1.2rem;
    color: #4a5568;
    font-size: 0.95rem;
    align-items: center;
  }
  
  .main-content {
    min-height: 200px;
    margin-bottom: 2.5rem;
    background-color: #FDFBF7; /* 매우 연한 베이지 */
    padding: 2rem;
    border-radius: 12px;
  }
  
  .text-content {
    line-height: 1.8;
    color: #2d3748;
    margin-bottom: 2.5rem;
  }
  
  .like-section {
    display: flex;
    justify-content: center;
    margin: 2rem 0;
  }
  
  .like-button {
    background-color: white;
    padding: 0.7rem 2rem;
    border-radius: 25px;
    cursor: pointer;
    transition: all 0.3s ease;
    border: none;
    box-shadow: 0 2px 12px rgba(0, 0, 0, 0.06);
    font-size: 1.1rem;
  }
  
  .like-button:hover {
    background-color: #FFE8E8; /* 연한 분홍색 */
    transform: translateY(-2px);
  }
  
  .like-button.liked {
    background-color: #FFD1D1; /* 진한 분홍색 */
    color: #e53e3e;
  }
  
  .button-section {
    border-top: 2px solid #F3F0E6; /* 베이지색 계열의 구분선 */
    padding-top: 1.5rem;
    display: flex;
    justify-content: flex-end;
    margin-top: 2rem;
  }
  
  .list-button {
    background-color: #9EC5FE; /* 더 진한 하늘색 */
    color: white;
    padding: 0.7rem 2rem;
    border-radius: 12px;
    cursor: pointer;
    transition: all 0.3s ease;
    border: none;
    font-weight: 500;
    box-shadow: 0 2px 8px rgba(158, 197, 254, 0.3);
  }
  
  .list-button:hover {
    background-color: #7DB0FE; /* 더더 진한 하늘색 */
    transform: translateY(-2px);
  }
  
  .comment-section {
    margin-top: 3rem;
  }
  
  /* 신고 버튼 스타일 */
  .report-button {
    background-color: white;
    color: #FF6B6B;
    padding: 0.4rem 1rem;
    border-radius: 8px;
    font-size: 0.9rem;
    cursor: pointer;
    transition: all 0.3s ease;
    margin-left: auto;
    border: none;
    box-shadow: 0 2px 8px rgba(255, 107, 107, 0.1);
  }
  
  .report-button:hover {
    background-color: #FF6B6B;
    color: white;
    transform: translateY(-2px);
  }
  
  .writer {
    font-weight: 600;
    color: #2d3748;
  }
  
  .view-count {
    background-color: #F3F0E6;
    padding: 0.3rem 0.8rem;
    border-radius: 20px;
    font-size: 0.85rem;
  }
  </style>