<template>
  <header>
    <div class="header-container">
      <div class="logo-wrapper">
        <div class="logo-background">
          <img :src="logo" alt="엣코 로고" class="logo-container">
        </div>
      </div>
 
      <nav class="nav-menu">
        <div class="nav-item">Home</div>
        <div class="nav-item">Category</div>
        <div class="nav-item">About</div>
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
          <a href="#" class="auth-link">
            <i class="bi bi-person-circle"></i>
            로그인
          </a>
          <a href="#" class="auth-link">
            <i class="bi bi-person-plus"></i>
            회원가입
          </a>
        </div>
      </div>
    </div>
  </header>
 </template>
 
 <script setup>
 import logo from '@/assets/로고/엣코 로고.gif'
 </script>
 
 <style scoped>
 header {
  padding: 1rem 2rem;
  background-color: rgb(178, 242, 165);
  box-shadow: 0 2px 8px rgba(158, 157, 157, 0.1);
 }
 
 .header-container {
  display: flex;
  align-items: center;
  max-width: 1200px;
  margin: 0 auto;
  height: 60px;
  position: relative;  /* 자식 요소의 절대 위치 기준점 */
}
 
 /* 로고 스타일 */
 .logo-wrapper {
  flex-shrink: 0;     /* 로고 크기 고정 */
  margin-left: 0;     /* 왼쪽 마진 제거 */
}
 
 .logo-background {
  background-color: #1a1a1a;  /* 로고 배경만 어둡게 */
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
  padding: 0.5rem 1rem;
  cursor: pointer;
  border-radius: 4px;
  font-weight: 500;
  transition: all 0.3s ease;
 }
 
 .nav-item:hover {
  background-color: rgba(255, 255, 255, 0.4);
  transform: translateY(-2px);
 }
 
 /* 검색창 스타일 */
 .search-container {
  display: flex;
  align-items: center;
  background-color: white;
  border-radius: 20px;
  padding: 0.3rem;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.05);
  transition: all 0.3s ease;
 }
 
 .search-input {
  border: none;
  padding: 0.5rem 1rem;
  width: 200px;
  border-radius: 20px;
  font-size: 0.9rem;
  transition: all 0.3s ease;
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
  color: #666;
  transition: all 0.3s ease;
 }
 
 .search-btn:hover {
  color: #4CAF50;
  background-color: rgba(76, 175, 80, 0.1);
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
  color: #2C3E50;
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
  color: #4CAF50;
  background-color: rgba(255, 255, 255, 0.4);
  transform: translateY(-1px);
 }
 </style>

