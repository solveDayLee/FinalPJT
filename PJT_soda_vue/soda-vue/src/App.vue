<template>
  <div>
    <h2>App vue</h2>
    <Sidebar/>

  </div>

  <footer>
    <div class="footerBox">
      <div class="searchAndBanner">
        <div class="search">
          <p>게시글 검색</p>
          <div class="searchInput">
            <input placeholder="검색어를 입력하셔요"><button class="searchBtn">검색</button>
          </div>
        </div>
        <div class="banner">
          <nav class="bannerNav">
            <p>Home</p>
            <p>Category</p>
            <p>About</p>
            <p>Contact</p>
          </nav>
          <div class="social">
            <p>F</p>
            <p>T</p>
            <p>I</p>
            <p>Y</p>
          </div>
        </div>
      </div>
      <div class="bottom">
        <p>2024 다영 소운 제작함</p>
        <img :src="logo" alt="logo" class="logo"> 
        <p>법률</p>
      </div>
    </div>
  </footer>
</template> 

<script setup> 
  import logo from "@/assets/logo/etce_logo.gif";
  import Sidebar from "./components/sidebar.vue";
</script>
 
<style scoped>
.footerBox {
   background-color: #ADBA5E;
   border-radius: 20px 20px 0 0;
   padding: 30px 20px;
   color: white;
}

.search {
  background-color: #869A69;
  padding: 15px 20px;
  border-radius: 10px;
  display: flex;
  align-items: center;
  gap: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.searchInput {
  display: flex;
  flex: 1;
  gap: 10px;
}

.searchInput input {
  flex: 1;
  padding: 8px 15px;
  border: none;
  border-radius: 5px;
  outline: none;
  font-size: 14px;
}

.searchBtn {
  background-color: #6B7B52;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 8px 20px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.searchBtn:hover {
  background-color: #5A6A41;
}

.searchAndBanner {
  display: flex;
  flex-direction: column;
  gap: 30px;
}

.banner {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 10px;
}

.bannerNav {
  display: flex;
  gap: 30px;
}

.bannerNav p {
  cursor: pointer;
  transition: color 0.3s;
}

.bannerNav p:hover {
  color: #E8ECD6;
}

.social {
  display: flex;
  gap: 20px;
}

.social p {
  width: 30px;
  height: 30px;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #869A69;
  border-radius: 50%;
  cursor: pointer;
  transition: all 0.3s;
}

.social p:hover {
  background-color: #6B7B52;
  transform: translateY(-2px);
}

.bottom {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 400px;
  margin-top: 30px;
  padding-top: 20px;
  border-top: 1px solid rgba(255, 255, 255, 0.2);
}

.logo {
  width: 35px;
  height: 30px;
  margin: 10px;
  transition: transform 0.3s;
  background-color: #5A6A41;
  border-radius: 10 px;
}

.logo:hover {
  transform: scale(1.1);
}

/* 추가적인 텍스트 스타일링 */
p {
  margin: 0;
  font-size: 14px;
}

.search p {
  font-weight: 600;
}
</style>/