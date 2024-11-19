<template>
    <div class="sidebar">
      <div class="sidebar-section">
        <h3><a><i class="icon fas fa-globe"></i> 전체글</a></h3>
      </div>
      <hr>
      <div class="sidebar-section">
        <h3><i class="icon fas fa-comments"></i> 커뮤니티</h3>
        <ul>
          <li v-for="category in categories" :key="category">
            <a><i class="icon fas fa-chevron-right"></i> {{ category }}</a>
          </li>
        </ul>
      </div>
      <hr>
      <div class="sidebar-section">
        <h3><i class="icon fas fa-edit"></i> 에디터 게시판</h3>
        <ul>
          <li v-for="editorCategory in editorCategories" :key="editorCategory">
            <a><i class="icon fas fa-chevron-right"></i> {{ editorCategory }}</a>
          </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script setup>
  const categories = [
    "Best 인기글(실시간)",
    "Best 인기글(명예의 전당)",
    "수구 talk",
    "발레 talk"
  ];
  
  const editorCategories = [
    "에디터 Best",
    "에디터 뉴스",
    "에디터 talk",
    "에디터 talk"
  ];
  </script>
  
  <style scoped>
  .sidebar {
    background-color: #FBF8EF; /* 밝고 따뜻한 배경색 */
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0 6px 10px rgba(0, 0, 0, 0.1);
    font-family: 'Arial', sans-serif;
    width: 300px; /* 사이드바 크기 키움 */
  }
  
  .sidebar-section {
    margin-bottom: 30px;
  }
  
  h3 {
    font-size: 22px; /* 제목 크기 키움 */
    font-weight: bold;
    margin-bottom: 15px;
    color: #007bff; /* 강조색 */
    display: flex;
    align-items: center;
  }
  
  .icon {
    margin-right: 12px;
    color: #007bff;
  }
  
  ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
  }
  
  li {
    margin-bottom: 12px; /* 리스트 간격 키움 */
  }
  
  a {
    color: #333;
    text-decoration: none;
    font-size: 18px; /* 링크 크기 키움 */
    display: flex;
    align-items: center;
    transition: color 0.3s, transform 0.2s;
  }
  
  a:hover {
    color: #007bff;
    transform: translateX(8px); /* 호버 시 이동 범위 확대 */
  }
  
  hr {
    border: none;
    border-top: 2px solid #e9ecef; /* 구분선 두께 조정 */
    margin: 25px 0;
  }
  </style>
  