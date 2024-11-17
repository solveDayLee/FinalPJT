<template>
  <div>
    <h2>App vue</h2>
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
        <p>로고</p>
        <p>법률</p>
      </div>
    </div>
  </footer>
</template> 

<script setup> 

</script>
 
<style scoped>
.footerBox{
   background-color: #ADBA5E;
   border-radius: 20px 20px 0% 0%;
   height: 150px;
}
.search{
  background-color: #869A69;
  height: 50px;
  margin: 30px;
  border-radius: 10px;
  display: flex;
}

.searchBtn{
  background-color: #869A69;
}
.banner{
  display: flex;
  justify-content: space-between;
}
.bannerNav {
  display: flex;
  gap: 10px;
}
.social{
  display: flex;
  gap: 10px;
} 
.bottom{
  display: flex;
  justify-content: space-between;
}

</style>/