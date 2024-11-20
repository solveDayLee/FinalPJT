<template>
    <div class="page-container">
      <Banner />
      <div class="content-container">
        <div class="content-wrapper">
          <Sidebar class="sidebar-container"/>
          <div class="board-content">
            <WriteArea />
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import Banner from '@/components/Layouts/Banner.vue';
  import Sidebar from '@/components/Layouts/Sidebar.vue';
  import WriteArea from '@/components/WriteArea.vue';
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
    max-width: 2000px;
    padding-bottom: 40px;
    margin: 0 auto;
  }
  
  .content-wrapper {
    display: flex;
    gap: 60px;
    margin-top: -30px;
  }
  
  .sidebar-container {
    width: 400px !important;
    flex-shrink: 0;
  }
  
  .board-content {
    flex: 1;
    min-width: 0;
    width: 100%;
  }
  
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