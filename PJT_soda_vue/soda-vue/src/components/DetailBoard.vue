<template>
  <div class="board-container" v-if="store.board">
    <div class="board-detail">
      <div class="category-wrapper">
        <h2 class="category">{{ store.board.category }}</h2>
        <h2 class="category">{{ store.board.category }}</h2>
      </div>

      <div class="detail-content">
        <div class="title-section">
          <div class="title">{{ store.board.title }}</div>
          <div class="title">{{ store.board.title }}</div>
          <div class="meta-info">
            <span class="writer">{{ store.board.writer }}</span>
            <span class="date">{{ formatDate(store.board.regDate) }}</span>
            <span class="view-count">조회 {{ store.board.viewCnt }}</span>
            <span class="writer">{{ store.board.writer }}</span>
            <span class="date">{{ formatDate(store.board.regDate) }}</span>
            <span class="view-count">조회 {{ store.board.viewCnt }}</span>
            <button class="report-button" @click="handleReport">
              🚨 신고
            </button>
          </div>
        </div>

        <div class="main-content">
          <div class="text-content">{{ store.board.content }}</div>
          <div class="text-content">{{ store.board.content }}</div>
          <div class="like-section">
            <button class="like-button" :class="{ 'liked': isLiked }" @click="handleLike">
              ❤️ {{ store.board.likes }}
            </button>
          </div>
        </div>

        <div class="button-section">
          <div class="action-buttons">
            <router-link :to="`/detailboard/update/${route.params.no}`" class="edit-link">
              <span>✏️ 수정</span>
            </router-link>
            <router-link to="" class="delete-link" @click.prevent="deleteBoard">
              <span>🗑️ 삭제</span>
            </router-link>
          </div>
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
import Comment from './Comment.vue'
import { useRoute, useRouter } from 'vue-router'
import { ref, onMounted } from 'vue'
import { useBoardStore } from '@/stores/board';
import axios from 'axios';

const isLiked = ref(false)
const store = useBoardStore()
const route = useRoute()
const router = useRouter()

onMounted(() => {
  store.getBoard(route.params.no)
})

const deleteBoard = async () => {
  console.log("삭제게시글 번호" , route.params.no)
  if (confirm('정말 삭제하시겠습니까?')) {
    try {
      //삭제로직
      console.log("route.params 전체:", route.params) // params 객체 전체 확인
      const response = await axios.delete(`http://localhost:8080/etco/board/${route.params.no}`)
      console.log("DELETE 요청 후 응답:", response)
      console.log("삭제완료")
      alert('삭제되었습니다.')
      router.push({name:'Board'})
    } catch (error) {
      alert('삭제 중 오류가 발생했습니다.')
    }
  }
}
//수정로직
const updateBoard = function () {
  router.push({name: 'boardUpdate'})
}

const goToList = function () {
  router.push({name: 'Board'})
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
</script>

<style scoped>
.board-container {
  width: 100%;
  padding: 2rem;
  background-color: #FBF8EF;
  border-radius: 16px;
}

.board-detail {
  background-color: white;
  border-radius: 16px;
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.06);
  padding: 2.5rem 3rem;
}

.category-wrapper {
  margin-bottom: 2rem;
}

.category {
  display: inline-block;
  background-color: #9EC5FE;
  padding: 0.6rem 1.2rem;
  border-radius: 20px;
  font-size: 0.95rem;
  font-weight: 600;
  color: #1a365d;
  box-shadow: 0 2px 8px rgba(158, 197, 254, 0.3);
}

.title-section {
  border-bottom: 2px solid #F3F0E6;
  padding-bottom: 1.5rem;
  margin-bottom: 2rem;
}

.title {
  font-size: 1.8rem;
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
  min-height: 300px;
  margin-bottom: 2.5rem;
  background-color: #FDFBF7;
  padding: 2.5rem;
  border-radius: 12px;
}

.text-content {
  line-height: 1.8;
  color: #2d3748;
  margin-bottom: 2.5rem;
  font-size: 1.1rem;
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
  background-color: #FFE8E8;
  transform: translateY(-2px);
}

.like-button.liked {
  background-color: #FFD1D1;
  color: #e53e3e;
}

.button-section {
  border-top: 2px solid #F3F0E6;
  padding-top: 1.5rem;
  display: flex;
  justify-content: space-between;
  margin-top: 2rem;
}

.action-buttons {
  display: flex;
  gap: 1rem;
  align-items: center;
}

.edit-link,
.delete-link {
  padding: 0.7rem 1.5rem;
  border-radius: 12px;
  cursor: pointer;
  transition: all 0.3s ease;
  text-decoration: none;
  font-weight: 500;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.edit-link {
  background-color: #9EC5FE;
  color: white;
}

.edit-link:hover {
  background-color: #7DB0FE;
  transform: translateY(-2px);
}

.delete-link {
  background-color: #FF8787;
  color: white;
}

.delete-link:hover {
  background-color: #FF6B6B;
  transform: translateY(-2px);
}

.edit-link span,
.delete-link span {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  font-size: 0.95rem;
}

.list-button {
  background-color: #9EC5FE;
  color: white;
  padding: 0.7rem 2rem;
  border-radius: 12px;
  cursor: pointer;
  transition: all 0.3s ease;
  border: none;
  font-weight: 500;
  box-shadow: 0 2px 8px rgba(158, 197, 254, 0.3);
  text-decoration: none;
  display: inline-flex;
  align-items: center;
}

.list-button:hover {
  background-color: #7DB0FE;
  transform: translateY(-2px);
}

.comment-section {
  margin-top: 3rem;
}

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

@media (max-width: 1600px) {
  .board-detail {
    padding: 2rem 2.5rem;
  }

  .title {
    font-size: 1.6rem;
  }

  .main-content {
    padding: 2rem;
    min-height: 250px;
  }
}

@media (max-width: 1200px) {
  .board-detail {
    padding: 1.8rem 2rem;
  }

  .title {
    font-size: 1.4rem;
  }
}

@media (max-width: 768px) {
  .board-container {
    padding: 1rem;
  }

  .board-detail {
    padding: 1.5rem;
  }

  .meta-info {
    flex-wrap: wrap;
    gap: 0.8rem;
  }

  .report-button {
    margin-left: 0;
    width: 100%;
    margin-top: 0.5rem;
  }

  .button-section {
    flex-direction: column;
    align-items: stretch;
    gap: 1rem;
  }

  .action-buttons {
    width: auto;
  }

  .edit-link,
  .delete-link {
    padding: 0.7rem 1.2rem;
    text-decoration: none;
  }

  .list-button {
    width: 100%;
  }
}
</style>