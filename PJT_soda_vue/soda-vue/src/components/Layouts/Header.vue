<template>
  <header>
    <div class="header-container">

      <div class="logo-wrapper">
        <div class="logo-background">
          <RouterLink to="/"><img :src="logo" alt="logo" class="logo-container"></RouterLink>
        </div>
      </div>

      <nav class="nav-menu">
        <div class="nav-item">Home</div>
        <RouterLink :to="{name: 'Board'}"><div class="nav-item">Category</div></RouterLink>
        <RouterLink to="/detailboard"><div class="nav-item">About</div></RouterLink>
        <div class="nav-item">Contact</div>
      </nav>

      <div class="user-actions">
        <div class="search-container">
          <input type="text" placeholder="검색어를 입력하세요" class="search-input">
          <button type="submit" class="search-btn">
            <i class="bi bi-search"></i>
          </button>
        </div>

        <div class="auth-links">
          <RouterLink to="/login">
          <a href="#" class="auth-link">
            <i class="bi bi-person-circle"></i>
            로그인
          </a>
          </RouterLink>
          <RouterLink :to="{name: 'Join'}">
            <a href="#" class="auth-link">
              <i class="bi bi-person-plus"></i>
              회원가입
            </a>
          </RouterLink>
        </div>
      </div>
    </div>
  </header>
</template>

<script setup>

import logo from '@/assets/etco-logo.gif'
import { RouterLink } from 'vue-router';



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
}

.auth-links {
    display: flex;
    gap: 1.5rem;
}

.auth-link {
    display: flex;
    align-items: center;
    gap: 0.4rem;
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
</style>
