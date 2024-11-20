<!-- BoardView.vue -->
<template>
    <div class="page-container">
      <Banner />
      <div class="content-container">
        <div class="content-wrapper">
          <Sidebar class="sidebar-container"/>
          <div class="board-content">
            <DetailBoard />
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import Banner from '@/components/Layouts/Banner.vue';
  import Sidebar from '@/components/Layouts/Sidebar.vue';
  import DetailBoard from '@/components/DetailBoard.vue';
  </script>
  
  <style>
  .page-container {
    width: 100%;
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  
  .content-container {
    width: 100%;
    max-width: 2000px; /* 배너와 동일하게 수정 */
    /* padding: 0 40px; 좌우 패딩 증가 */
    padding-bottom: 40px;
    margin: 0 auto;
  }
  
  .content-wrapper {
    display: flex;
    gap: 60px; /* 사이드바와 본문 사이 간격 증가 */
    margin-top: -30px;
  }
  
  .sidebar-container {
    width: 400px !important; /* 사이드바 너비 증가 */
    flex-shrink: 0; /* 사이드바 크기 고정 */
  }
  
  .board-content {
    flex: 1;
    min-width: 0; /* flexbox 오버플로우 방지 */
  }
  
  /* 반응형 디자인 */
  @media (max-width: 1600px) {
    .content-container {
      padding: 0 30px;
    }
    
    .content-wrapper {
      gap: 40px;
    }
    
    .sidebar-container {
      width: 350px !important;
    }
  }
  
  @media (max-width: 1200px) {
    .content-wrapper {
      gap: 30px;
    }
    
    .sidebar-container {
      width: 300px !important;
    }
  }
  
  @media (max-width: 1024px) {
    .content-wrapper {
      flex-direction: column;
    }
  
    .sidebar-container {
      width: 100% !important;
    }
  }
  </style>