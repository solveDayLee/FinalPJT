<!-- Banner.vue -->
<template>
  <div class="banner">
      <div class="rectangle-1"></div>
      <div class="banner-content">
          <div class="one-more-friend">Discover Hidden Gems</div>
          <div class="thousands-more-fun">Where Passion Meets Community</div>
          <div class="bodytext">
              Beyond mainstream sports lies a world of extraordinary athleticism and passionate communities. Join us to
              explore, share, and celebrate 
          </div>
          <div class="button-group">
              <div class="button-l2">
                  <div class="click-here2">View Intro</div>
              </div>
              <div class="button-l">
                  <div class="click-here">Explore Now</div>
              </div>
          </div>
      </div>
  </div>
</template>

<style scoped>
.banner,
.banner * {
 box-sizing: border-box;
}

.banner {
 background: linear-gradient(102.87deg,
         #4A90E2 0%,
         #67A6E4 50%,
         #81B9E5 100%);
 border-radius: 20px;
 height: 450px;
 min-height: 400px;
 position: relative;
 overflow: hidden;
 width: 100%;
 max-width: 2000px; /* 배너 최대 너비 증가 */
 margin: 70px auto;
 box-shadow: 0 10px 30px rgba(74, 144, 226, 0.15);
 padding: 60px 80px; /* 내부 여백 증가 */
}

.banner-content {
 position: relative;
 z-index: 1;
 max-width: 800px; /* 컨텐츠 영역 제한 */
 margin-left: auto; /* 오른쪽 정렬 */
}

.rectangle-1 {
 background: rgba(255, 255, 255, 0.15);
 backdrop-filter: blur(5px);
 border-radius: 99px;
 width: 70%; /* 배경 요소 너비 증가 */
 height: 900px; /* 배경 요소 높이 증가 */
 position: absolute;
 left: 50%;
 top: -164px;
 transform-origin: 0 0;
 transform: rotate(19.781deg) scale(-1, 1);
 z-index: 0;
}

.one-more-friend {
 color: #FFFFFF;
 font-family: sans-serif;
 font-size: 48px; /* 글자 크기 증가 */
 line-height: 1.4;
 font-weight: bold;
 margin-bottom: 20px; /* 여백 추가 */
}

.thousands-more-fun {
 color: rgba(255, 255, 255, 0.9);
 font-family: sans-serif;
 font-size: 40px; /* 글자 크기 증가 */
 line-height: 1.4;
 font-weight: bold;
 margin-bottom: 30px; /* 여백 추가 */
}

.bodytext {
 color: rgba(255, 255, 255, 0.85);
 font-family: sans-serif;
 font-size: 16px; /* 글자 크기 증가 */
 line-height: 1.6;
 font-weight: 500;
 margin-bottom: 40px; /* 여백 추가 */
 max-width: 600px; /* 텍스트 너비 제한 */
}

.button-group {
 display: flex;
 gap: 20px; /* 버튼 사이 간격 */
}

.button-l {
 background: #FFFFFF;
 border-radius: 57px;
 padding: 16px 32px; /* 패딩 증가 */
 display: flex;
 align-items: center;
 justify-content: center;
 box-shadow: 0 4px 15px rgba(255, 255, 255, 0.2);
 cursor: pointer;
 transition: all 0.3s ease;
}

.button-l:hover {
 transform: translateY(-2px);
 box-shadow: 0 6px 20px rgba(255, 255, 255, 0.3);
}

.click-here {
 color: #4A90E2;
 font-family: sans-serif;
 font-size: 18px; /* 글자 크기 증가 */
 font-weight: 500;
}

.button-l2 {
 border-radius: 57px;
 border: 1.5px solid rgba(255, 255, 255, 0.6);
 padding: 16px 32px; /* 패딩 증가 */
 display: flex;
 align-items: center;
 justify-content: center;
 cursor: pointer;
 transition: all 0.3s ease;
}

.button-l2:hover {
 background: rgba(255, 255, 255, 0.15);
 transform: translateY(-2px);
}

.click-here2 {
 color: #FFFFFF;
 font-family: sans-serif;
 font-size: 18px; /* 글자 크기 증가 */
 font-weight: 500;
}

@media (max-width: 1024px) {
 .banner {
   padding: 40px 30px;
 }
 
 .banner-content {
   margin-left: 0;
   max-width: 100%;
 }
 
 .one-more-friend {
   font-size: 36px;
 }
 
 .thousands-more-fun {
   font-size: 32px;
 }
 
 .bodytext {
   font-size: 14px;
 }
}

@media (max-width: 768px) {
 .button-group {
   flex-direction: column;
 }
 
 .button-l, .button-l2 {
   width: 100%;
 }
}
</style>