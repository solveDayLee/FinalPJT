<template>
   <div class="banner">
       <div class="rectangle-1"></div>
       <div class="one-more-friend">Discover Hidden Gems</div>
       <div class="thousands-more-fun">Where Passion Meets Community</div>
       <div
           class="bodytext">
           Beyond mainstream sports lies a world of extraordinary athleticism and passionate communities. Join us to
           explore, share, and celebrate the amazing world of niche sports. With 200+ different sports communities,
           there's always something new to discover!
       </div>
       <div class="button-l">
           <div class="click-here">Explore Now</div>
       </div>
       <div class="button-l2">
           <div class="click-here2">View Intro</div>
       </div>
   </div>
</template>

<script setup>
</script>

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
  height: auto;
  min-height: 400px;
  position: relative;
  overflow: hidden;
  max-width: 1200px;
  margin: 70px auto;
  box-shadow: 0 10px 30px rgba(74, 144, 226, 0.15);
}

.rectangle-1 {
  background: rgba(255, 255, 255, 0.15);
  backdrop-filter: blur(5px);
  border-radius: 99px;
  width: 60%;
  height: 799.52px;
  position: absolute;
  left: 567.23px;
  top: -164px;
  transform-origin: 0 0;
  transform: rotate(19.781deg) scale(-1, 1);
}

.one-more-friend {
  color: #FFFFFF;
  text-align: center;
  font-family: sans-serif;  /* 기본 폰트로 변경 */
  font-size: 40px;
  line-height: 68px;
  font-weight: bold;  /* 700 대신 bold 사용 */
  position: absolute;
  left: 492px;
  top: 64px;
  margin-right: 5px;
}

.thousands-more-fun {
  color: rgba(255, 255, 255, 0.9);
  text-align: center;
  font-family: sans-serif;  /* 기본 폰트로 변경 */
  font-size: 36px;
  line-height: 54px;
  font-weight: bold;
  position: absolute;
  left: 541px;
  top: 134px;
  margin-right: 5px;
}

.bodytext {
  color: rgba(255, 255, 255, 0.85);
  text-align: right;
  font-family: sans-serif;  /* 기본 폰트로 변경 */
  font-size: 12px;
  line-height: 18px;
  font-weight: 500;
  position: absolute;
  left: 501px;
  top: 196px;
  width: 394px;
  margin-right: 5px;
}

.button-l {
  background: #FFFFFF;
  border-radius: 57px;
  padding: 14px 28px 10px 28px;
  display: flex;
  flex-direction: row;
  gap: 10px;
  align-items: center;
  justify-content: center;
  width: 163px;
  position: absolute;
  left: 745px;
  top: 274px;
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
  text-align: left;
  font-family: sans-serif;  /* 기본 폰트로 변경 */
  font-size: 16px;
  line-height: 24px;
  font-weight: 500;
  position: relative;
  display: flex;
  align-items: flex-end;
  justify-content: flex-start;
}

.button-l2 {
  border-radius: 57px;
  border-style: solid;
  border-color: rgba(255, 255, 255, 0.6);
  border-width: 1.5px;
  padding: 14px 28px 10px 28px;
  display: flex;
  flex-direction: row;
  gap: 8px;
  align-items: center;
  justify-content: center;
  position: absolute;
  left: 564px;
  top: 274px;
  cursor: pointer;
  transition: all 0.3s ease;
}

.button-l2:hover {
  background: rgba(255, 255, 255, 0.15);
  transform: translateY(-2px);
}

.click-here2 {
  color: #FFFFFF;
  text-align: left;
  font-family: sans-serif;  /* 기본 폰트로 변경 */
  font-size: 16px;
  line-height: 24px;
  font-weight: 500;
  position: relative;
  display: flex;
  align-items: flex-end;
  justify-content: flex-start;
}

.media-play-circle {
  flex-shrink: 0;
  width: 24px;
  height: 24px;
  position: relative;
  overflow: visible;
}
</style>
