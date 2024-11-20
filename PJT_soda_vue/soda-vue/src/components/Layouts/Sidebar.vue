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
    background-color: #FBF8EF;
    padding: 40px; /* 패딩 증가 */
    border-radius: 12px;
    box-shadow: 0 6px 10px rgba(0, 0, 0, 0.1);
    font-family: 'Arial', sans-serif;
    width: 100%; /* 부모 컨테이너에 맞춤 */
  }
  
  .sidebar-section {
    margin-bottom: 35px; /* 섹션 간격 증가 */
  }
  
  h3 {
    font-size: 24px; /* 제목 크기 증가 */
    font-weight: bold;
    margin-bottom: 20px;
    color: #007bff;
    display: flex;
    align-items: center;
  }
  
  .icon {
    margin-right: 15px;
    color: #007bff;
    font-size: 20px; /* 아이콘 크기 증가 */
  }
  
  ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
  }
  
  li {
    margin-bottom: 15px;
  }
  
  a {
    color: #333;
    text-decoration: none;
    font-size: 20px; /* 링크 텍스트 크기 증가 */
    display: flex;
    align-items: center;
    transition: color 0.3s, transform 0.2s;
    padding: 8px 0; /* 클릭 영역 증가 */
  }
  
  a:hover {
    color: #007bff;
    transform: translateX(10px);
  }
  
  hr {
    border: none;
    border-top: 2px solid #e9ecef;
    margin: 30px 0; /* 구분선 여백 증가 */
  }
  
  /* 반응형 디자인 */
  @media (max-width: 1600px) {
    .sidebar {
      padding: 35px;
    }
    
    h3 {
      font-size: 22px;
    }
    
    a {
      font-size: 18px;
    }
  }
  
  @media (max-width: 1200px) {
    .sidebar {
      padding: 30px;
    }
    
    h3 {
      font-size: 20px;
    }
    
    a {
      font-size: 16px;
    }
  }
  
  @media (max-width: 1024px) {
    .sidebar {
      padding: 25px;
    }
  }
  </style>