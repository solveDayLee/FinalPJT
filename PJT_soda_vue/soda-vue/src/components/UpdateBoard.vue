<template>
  <div class="board-container" v-if="store.board">
    <div class="board-detail">
      <!-- 메인 카테고리 선택 -->
      <div class="category-wrapper">
        <select v-model="board.category" class="category" @change="handleMainCategoryChange">
          <option value="" disabled>게시판을 선택해주세요</option>
          <option v-for="sport in sports" :key="sport.code" :value="sport.code">
            {{ sport.name }}
          </option>
        </select>

        <!-- 서브 카테고리 선택 -->
        <select v-if="board.category && showSubCategory" v-model="board.detailCategory"
          class="category sub-category">
          <option value="" disabled>세부 카테고리를 선택해주세요</option>
          <option v-for="menu in sportMenus" :key="menu.code" :value="menu.code">{{ menu.name }}</option>
        </select>
      </div>

      <div class="detail-content">
        <!-- 제목입력 -->
        <div class="title-section">
          <input v-model="board.title" class="title" placeholder="수정할 제목을 입력하세요">
          <div class="meta-info">
            <span class="writer">{{ store.board.writer }}</span>
            <span class="date">{{ formatDate(store.board.regDate) }}</span>
            <span class="view-count">조회 {{ store.board.viewCnt }}</span>
          </div>
        </div>

        <div class="main-content">
          <textarea v-model="board.content" class="text-content" placeholder="수정할 내용을 입력하세요"></textarea>

        </div>

        <div class="button-section">
          <div class="action-buttons">
            <button @click="handleSubmit" class="submit-button">수정완료</button>
            <button @click="handleCancel" class="cancel-button">취소</button>
          </div>
          <RouterLink :to="({ name: 'Board' })"><button class="list-button" @click="goToList">목록</button></RouterLink>
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
import { ref, onMounted, computed } from 'vue'
import { useBoardStore } from '@/stores/board';
import axios from 'axios';

const isLiked = ref(false)
const store = useBoardStore()
const route = useRoute()
const router = useRouter()



const board = ref({
  category: '',
  detailCategory: '',
  title: '',
  content: ''
})

const sports = [
  { code: 'COMMUNITY', name: '자유게시판' },
  { code: 'WATERPOLO', name: '수구' },
  { code: 'BALLET', name: '발레' },
  { code: 'CURLING', name: '컬링' },
  { code: 'SCUBA', name: '스쿠버다이빙' },
  { code: 'SAILING', name: '세일링' },
  { code: 'ARCHERY', name: '양궁' }
]

const sportMenus = [
  { code: 'GUIDE', name: '초보자 가이드', icon: 'bi-book' },
  { code: 'INFO', name: '정보/소식', icon: 'bi-info-circle' },
  { code: 'QNA', name: 'Q&A', icon: 'bi-question-circle' },
  { code: 'TIPS', name: '꿀팁 공유', icon: 'bi-lightbulb' },
  { code: 'LESSON', name: '강습/레슨', icon: 'bi-mortarboard' },
  { code: 'MARKET', name: '중고장터', icon: 'bi-shop' },
  { code: 'CLUB', name: '동호회/모임', icon: 'bi-people' }
]

const handleMainCategoryChange = () => {
  board.value.detailCategory = ''
}

const showSubCategory = computed(() => {
  return board.value.category !== 'COMMUNITY'
});




// formatDate 함수 추가
const formatDate = (date) => {
  return new Date(date).toLocaleDateString('ko-KR', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: '2-digit',
    minute: '2-digit'
  })
}

onMounted(() => {
  console.log('Store board 데이터:', store.board) // 디버깅용 로그
  store.getBoard(route.params.no)
  board.value = {

    category: store.board.category,
    detailCategory: store.board.detailCategory,
    title: store.board.title,
    content: store.board.content
  }
})
//수정 시
const handleSubmit = async () => {
  try {
    await axios.put(`http://localhost:8080/etco/board/${route.params.no}`, board.value)
    alert('수정이 완료되었습니다.')
    router.push(`/detailboard/${route.params.no}`)

  } catch (error) {
    console.error('수정실패')
    alert('수정에 실패했습니다.')
  }
}

//취소
const handleCancel = () => {
  if (confirm('수정을 취소하시겠습니까?')) {
    router.push(`/detailboard/${route.params.no}`)
  }
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
  display: flex;
  gap: 1rem;
  margin-bottom: 2rem;
}

.category {
  width: auto;
  min-width: 200px;
  padding: 0.8rem 1.5rem;
  border-radius: 25px;
  font-size: 1rem;
  font-weight: 500;
  color: #1a365d;
  background-color: white;
  border: 2px solid #9EC5FE;
  cursor: pointer;
  transition: all 0.3s ease;
  appearance: none;
  background-image: url("data:image/svg+xml;charset=UTF-8,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3e%3cpolyline points='6 9 12 15 18 9'%3e%3c/polyline%3e%3c/svg%3e");
  background-repeat: no-repeat;
  background-position: right 1rem center;
  background-size: 1em;
  padding-right: 2.5rem;
}

.category:hover {
  border-color: #7DB0FE;
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(158, 197, 254, 0.2);
}

.sub-category {
  min-width: 180px;
}

@media (max-width: 768px) {
  .category-wrapper {
    flex-direction: column;
  }

  .category,
  .sub-category {
    width: 100%;
  }
}

.title-section {
  border-bottom: 2px solid #F3F0E6;
  padding-bottom: 1.5rem;
  margin-bottom: 2rem;
}

input.title {
  width: 100%;
  padding: 1rem 1.5rem;
  border: 2px solid #F3F0E6;
  border-radius: 12px;
  font-size: 1.6rem;
  font-weight: 600;
  color: #2d3748;
  background-color: white;
  transition: all 0.3s ease;
  margin-bottom: 1.5rem;
}

input.title:focus {
  outline: none;
  border-color: #9EC5FE;
  box-shadow: 0 4px 12px rgba(158, 197, 254, 0.1);
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
  width: 100%;
  min-height: 400px;
  padding: 1.5rem;
  border: 2px solid #F3F0E6;
  border-radius: 12px;
  font-size: 1.1rem;
  line-height: 1.8;
  color: #2d3748;
  background-color: white;
  transition: all 0.3s ease;
  resize: vertical;
}

.text-content:focus {
  outline: none;
  border-color: #9EC5FE;
  box-shadow: 0 4px 12px rgba(158, 197, 254, 0.1);
}

.like-section {
  display: flex;
  justify-content: center;
  margin: 2rem 0;
}

.button-section {
  border-top: 2px solid #F3F0E6;
  padding-top: 2rem;
  display: flex;
  justify-content: space-between;
  margin-top: 2.5rem;
}

.action-buttons {
  display: flex;
  gap: 1.5rem;
  align-items: center;
}

.submit-button,
.cancel-button {
  padding: 0.8rem 2rem;
  border-radius: 25px;
  font-size: 1rem;
  font-weight: 500;
  border: none;
  cursor: pointer;
  transition: all 0.3s ease;
  display: inline-flex;
  align-items: center;
  gap: 0.5rem;
}

.submit-button {
  background-color: #9EC5FE;
  color: white;
  box-shadow: 0 4px 12px rgba(158, 197, 254, 0.3);
}

.cancel-button {
  background-color: #FF8787;
  color: white;
  box-shadow: 0 4px 12px rgba(255, 135, 135, 0.3);
}

.submit-button:hover,
.cancel-button:hover {
  transform: translateY(-2px);
}

.submit-button:hover {
  background-color: #7DB0FE;
}

.cancel-button:hover {
  background-color: #FF6B6B;
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

::placeholder {
  color: #a0aec0;
  opacity: 0.7;
}

input:focus,
textarea:focus,
select:focus {
  outline: none;
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

  .category {
    width: 100%;
    min-width: auto;
  }

  .text-content {
    min-height: 300px;
  }

  .button-section {
    flex-direction: column;
    align-items: stretch;
    gap: 1rem;
  }

  .action-buttons {
    width: auto;
  }

  .submit-button,
  .cancel-button {
    width: 100%;
    justify-content: center;
  }

  .list-button {
    width: 100%;
  }
}
</style>