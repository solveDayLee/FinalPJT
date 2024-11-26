<template>
  <header>
    <div class="header-container">

      <div class="logo-wrapper">
        <div class="logo-background">
          <RouterLink to="/"><img :src="logo" alt="logo" class="logo-container"></RouterLink>
        </div>
      </div>

      <nav class="nav-menu">
        <RouterLink :to="{ name: 'Home' }">
          <div class="nav-item">Home</div>
        </RouterLink>
        <RouterLink :to="{ name: 'Board' }">
          <div class="nav-item">Category</div>
        </RouterLink>
        <div class="nav-item">About</div>
        <RouterLink :to="{ name: 'Contact' }"><div class="nav-item">Contact</div></RouterLink>
      </nav>

      <div class="user-actions">
        <div class="search-container">
          <input type="text" placeholder="검색어를 입력하세요" class="search-input">
          <button type="submit" class="search-btn">
            <i class="bi bi-search"></i>
          </button>
        </div>

        <div class="auth-links">
          <!-- 로그인된 경우 표시될 UI -->
          <div v-if="isLoggedIn" class="user-info">

            <!-- ?는 옵셔널 체이닝(Optional Chaining) 연산자입니다. 이는 loginUser가 null이나 undefined일 때 에러를 방지하기 위해 사용됩니다. -->
            <span class="welcome-message">{{ loginUser?.userId }}님 반가워요!</span>
            <a @click="handleLogout" class="auth-link logout-btn">
              <i class="bi bi-box-arrow-right"></i>
              로그아웃</a>
          </div>

          <div v-else class="auth-links">
  <RouterLink to="/login" class="auth-link">
    <i class="bi bi-person-circle"></i>
    로그인
  </RouterLink>
  <RouterLink :to="{ name: 'Join' }" class="auth-link">
    <i class="bi bi-person-plus"></i>
    회원가입
  </RouterLink>
</div>
        </div>
      </div>
    </div>
  </header>
</template>

<script setup>

import logo from '@/assets/etco-logo.gif'
import { RouterLink } from 'vue-router';
import { useUserStore } from '@/stores/user';
import { computed } from 'vue';

//store 인스턴스 생성
const userStore = useUserStore()

//로그인 상태와 유저 정보를 가져오는 computed 속성
const loginUser = computed(()=> userStore.loginUser)
// 1. userStore의 loginUser 값을 실시간으로 감시하고 있다가
// 2. 그 값이 변경될 때마다 자동으로 화면을 업데이트 해줍니다


const isLoggedIn = computed(()=> !!userStore.loginUser)
// 이 코드는 loginUser 값의 존재 여부를 boolean(true/false)로 변환합니다
// !!는 값을 boolean으로 변환하는 연산자입니다

//로그아웃 핸들러
const handleLogout = () => {
  userStore.userLogout()
}


</script>

<style scoped>
header {
  padding: 1rem 2rem;
  background: linear-gradient(to right,
      #4A90E2 0%,
      #67A6E4 50%,
      #81B9E5 100%);
  box-shadow: 0 2px 8px rgba(74, 144, 226, 0.15);
  min-width: 1024px;
}

.header-container {
  display: flex;
  align-items: center;
  max-width: 1200px;
  margin: 0 auto;
  height: 60px;
  position: relative;

}

/* 로고 스타일 */
.logo-wrapper {
  flex-shrink: 0;
  margin-left: 0;
}

.logo-background {
  background-color: rgba(255, 255, 255, 0.15);
  backdrop-filter: blur(5px);
  padding: 0.5rem;
  border-radius: 4px;
}

.logo-container {
  width: 60px;
  height: 60px;
  object-fit: contain;
  transition: transform 0.3s ease;
  background-color: rgb(220, 237, 255);
  border-radius: 30%;
}

.logo-container:hover {
  transform: scale(1.05);
}

/* 네비게이션 메뉴 스타일 */
.nav-menu {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 4rem;
  margin-left: 4rem;
}

.nav-item {
  color: #FFFFFF;
  padding: 0.5rem 1rem;
  cursor: pointer;
  border-radius: 4px;
  font-weight: 500;
  transition: all 0.3s ease;
}

.nav-item:hover {
  background-color: rgba(255, 255, 255, 0.15);
  transform: translateY(-2px);
}

/* 검색창 스타일 */
.search-container {
  display: flex;
  align-items: center;
  background-color: rgba(255, 255, 255, 0.9);
  border-radius: 20px;
  padding: 0.3rem;
  box-shadow: 0 2px 5px rgba(74, 144, 226, 0.1);
  transition: all 0.3s ease;
}

.search-input {
  border: none;
  padding: 0.5rem 1rem;
  width: 200px;
  border-radius: 20px;
  font-size: 0.9rem;
  transition: all 0.3s ease;
  background: transparent;
}

.search-input:focus {
  outline: none;
  width: 220px;
}

.search-btn {
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  border-radius: 50%;
  border: none;
  background-color: transparent;
  padding: 0.5rem;
  color: #4A90E2;
  transition: all 0.3s ease;
}

.search-btn:hover {
  color: #67A6E4;
  background-color: rgba(74, 144, 226, 0.1);
}

/* 사용자 액션 영역 스타일 */
.user-actions {
  display: flex;
  align-items: center;
  gap: 1.5rem;
  margin-left: auto;
  flex-wrap: nowrap;
}

.auth-links {
  display: flex;
  flex-direction: row; /* 가로 배치를 위해 추가 */
  gap: 1.5rem;
  align-items: center; /* 세로 중앙 정렬을 위해 추가 */
}

.auth-link {
  display: flex;
  flex-direction: row; /* 버튼을 가로로 배치 */
  align-items: center;
  gap: 1.5rem;
  color: #FFFFFF;
  text-decoration: none;
  font-weight: 500;
  font-size: 0.9rem;
  transition: all 0.3s ease;
  padding: 0.4rem 0.8rem;
  border-radius: 4px;
}

.auth-link i {
  font-size: 1.2rem;
}

.auth-link:hover {
  background-color: rgba(255, 255, 255, 0.15);
  transform: translateY(-1px);
}

/* [추가] 로그인 상태 UI를 위한 새로운 스타일 */
.user-info {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.welcome-message {
  font-weight: 500;
}

.logout-btn {
  cursor: pointer;
}
a {
  text-decoration: none; /* 밑줄 제거 */
  color: inherit; /* 기본 글자 색상 상속 */
}
</style>
