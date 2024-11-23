<template>
  <div class="sidebar">
    <div class="sidebar-logo">
      <i class="bi bi-person-walking"></i>
      <router-link to="/board"><span>Sports Community</span></router-link>
    </div>

    <div class="sidebar-section">
      <div class="section-title">
        <i class="bi bi-compass"></i>
        <span>커뮤니티</span>
      </div>
      
      <div class="menu-item">
        <a @click="toggleNotice" :class="{ active: isNoticeOpen }">
          <i class="bi bi-megaphone"></i>
          <span>공지사항</span>
          <i class="bi" :class="isNoticeOpen ? 'bi-chevron-down' : 'bi-chevron-right'"></i>
        </a>
        <transition name="slide">
          <ul v-if="isNoticeOpen" class="sub-menu">
            <li>
              <router-link to="/board/category/NOTICE">
                <i class="bi bi-arrow-right"></i> 일반공지
              </router-link>
            </li>
            <li>
              <router-link to="/board/category/EVENT">
                <i class="bi bi-arrow-right"></i> 이벤트
              </router-link>
            </li>
          </ul>
        </transition>
      </div>
 
      <router-link to="/board/category/COMMUNITY" class="menu-link">
        <i class="bi bi-chat-dots"></i>
        <span>자유게시판</span>
      </router-link>
      
      <router-link to="/board/category/EDITOR" class="menu-link">
        <i class="bi bi-pencil-square"></i>
        <span>에디터 칼럼</span>
      </router-link>
    </div>
 
    <div class="sidebar-section">
      <div class="section-title">
        <i class="bi bi-trophy"></i>
        <span>종목별 게시판</span>
      </div>
      
      <div class="select-wrapper">
        <select v-model="selectedSport" class="sport-select">
          <option v-for="sport in sports" :key="sport.code" :value="sport.code">
            {{ sport.name }}
          </option>
        </select>
      </div>
 
      <transition-group name="fade" tag="ul" class="sport-menu">
        <li v-for="menu in sportMenus" :key="menu.code">
          <router-link 
            :to="`/board/category/${selectedSport}/${menu.code}`" 
            class="sport-menu-item"
          >
            <i :class="['bi', menu.icon]"></i>
            <span>{{ menu.name }}</span>
          </router-link>
        </li>
      </transition-group>
    </div>
 
    <div class="sidebar-section">
      <router-link to="/support" class="menu-link support-link">
        <i class="bi bi-headset"></i>
        <span>관리자 요청/문의</span>
      </router-link>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router';
import { ref } from 'vue'
import { storeToRefs } from 'pinia';
import { useBoardStore } from '@/stores/board';

const store = useBoardStore()
// const { selectedCategory } = storeToRefs(store);

const sports = [
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

// 화면이 바로 안 넘어가는 문제를 해결하기 위한 코드: 
const router = useRouter();
const selectedSport = ref(sports[0].code);

const isNoticeOpen = ref(false)
const toggleNotice = () => {
  isNoticeOpen.value = !isNoticeOpen.value
}

// router.beforeEach((to, from, next) =>{
//   if (to.params.sportCode) {
//     selectedSport.value = to.params.sportCode
//   }
//   next()
// })

</script>

<style scoped>
/* 이전 스타일 유지 */
.sidebar {
  background: linear-gradient(135deg, #ffffff 0%, #f8f9fa 100%);
  padding: 2rem;
  border-radius: 16px;
  box-shadow: 0 8px 30px rgba(0, 0, 0, 0.08);
  width: 300px;
  height: 100vh;
  overflow-y: auto;
}

.sidebar-logo {
  display: flex;
  align-items: center;
  gap: 1rem;
  font-size: 1.5rem;
  font-weight: 700;
  color: #2e64a0;
  margin-bottom: 2rem;
  padding-bottom: 1rem;
  border-bottom: 2px solid #e5e7eb;
}

/* Bootstrap 아이콘 크기 조정 */
.bi {
  font-size: 1.25rem;
  display: inline-block;
  line-height: 1;
  vertical-align: middle;
}

.sidebar-logo .bi {
  font-size: 2rem;
}

.transition-icon {
  font-size: 1rem;
  margin-left: auto;
}

/* 나머지 스타일은 이전과 동일 */
.section-title {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  font-size: 0.875rem;
  font-weight: 600;
  color: #6b7280;
  text-transform: uppercase;
  letter-spacing: 0.05em;
  margin-bottom: 1rem;
}

.menu-link, .sport-menu-item {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  padding: 0.75rem 1rem;
  color: #374151;
  text-decoration: none;
  border-radius: 8px;
  transition: all 0.2s ease;
  cursor: pointer;
}

.menu-link:hover, .sport-menu-item:hover {
  background-color: #f3f4f6;
  color: #2563eb;
  transform: translateX(4px);
}

.menu-item > a {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  padding: 0.75rem 1rem;
  color: #374151;
  cursor: pointer;
  border-radius: 8px;
  transition: all 0.2s ease;
}

.select-wrapper {
  position: relative;
  margin-bottom: 1rem;
}

.sport-select {
  width: 100%;
  padding: 0.75rem 1rem;
  border-radius: 8px;
  border: 1px solid #e5e7eb;
  background-color: white;
  color: #374151;
  font-size: 0.875rem;
  cursor: pointer;
  appearance: none;
  transition: all 0.2s ease;
}

.support-link {
  margin-top: auto;
  color: #2563eb;
  background-color: #eff6ff;
}

.support-link:hover {
  background-color: #dbeafe;
}

/* 애니메이션 */
.slide-enter-active,
.slide-leave-active {
  transition: all 0.3s ease;
}

.slide-enter-from,
.slide-leave-to {
  opacity: 0;
  transform: translateY(-10px);
}

.fade-enter-active,
.fade-leave-active {
  transition: all 0.2s ease;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
  transform: translateX(-10px);
}

/* 서브메뉴 스타일 */
.sub-menu {
  list-style: none;
  padding: 0.5rem 0 0.5rem 2.5rem;
}

.sub-menu li a {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  padding: 0.5rem;
  color: #6b7280;
  font-size: 0.875rem;
  transition: all 0.2s ease;
}

.sub-menu li a:hover {
  color: #2563eb;
  transform: translateX(4px);
  cursor: pointer;
}

.sidebar-section {
  margin-bottom: 2rem;
  padding-bottom: 2rem;
  border-bottom: 1px solid #e5e7eb;
}

.sidebar-section:last-child {
  border-bottom: none;
  margin-bottom: 0;
  padding-bottom: 0;
}

/* 활성화 상태 스타일 */
.active {
  color: #2563eb;
  background-color: #eff6ff;
}
</style>