<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.user-board,
.user-board * {
  box-sizing: border-box;
}
.user-board {
  background: #ffffff;
  height: 811px;
  position: relative;
  overflow: hidden;
}
.rectangle-1 {
  background: #f9f9f9;
  width: 93px;
  height: 810px;
  position: absolute;
  left: 0px;
  top: 0px;
}
.list-of-parts {
  width: 37px;
  height: 50px;
  position: absolute;
  left: 27px;
  top: 528px;
  object-fit: cover;
}
.selected {
  position: absolute;
  inset: 0;
}
.rectangle-4 {
  background: #1678f3;
  border-radius: 22px;
  width: 53px;
  height: 53px;
  position: absolute;
  left: 18px;
  top: 311px;
  box-shadow: 0px 6px 4px 0px rgba(0, 0, 0, 0.1);
}
.customer {
  width: 35px;
  height: 35px;
  position: absolute;
  left: 27px;
  top: 320px;
  object-fit: cover;
}
.rectangle-2 {
  background: #f3f3f3;
  width: 93px;
  height: 75px;
  position: absolute;
  left: 0px;
  top: 0px;
}
.rectangle-3 {
  background: #fcfcfc;
  width: 1240px;
  height: 75px;
  position: absolute;
  left: 96px;
  top: 0px;
}
.rectangle-39 {
  background: #f3f3f3;
  border-radius: 9px;
  border-style: solid;
  border-color: #353535;
  border-width: 0.5px;
  width: 347px;
  height: 37px;
  position: absolute;
  left: 153px;
  top: 129px;
  transform-origin: 0 0;
  transform: rotate(0deg) scale(1, -1);
}

.rectangle-34 {
  background: #fdfdfd;
  border-radius: 19px;
  width: 1111px;
  height: 513px;
  position: absolute;
  left: 159px;
  top: 250px;
}
.div {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 242px;
  top: 212px;
  width: 95px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.div2 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 378px;
  top: 212px;
  width: 81px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.div3 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 473px;
  top: 212px;
  width: 167px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.div4 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 731px;
  top: 212px;
  width: 137px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.div5 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 1072px;
  top: 216px;
  width: 109px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.user-board2 {
  color: #000000;
  text-align: left;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 35px;
  font-weight: 400;
  position: absolute;
  left: 120px;
  top: 11px;
}
.export {
  width: 35px;
  height: 35px;
  position: absolute;
  left: 27px;
  top: 728px;
  object-fit: cover;
}
.ellipse-1 {
  border-radius: 50%;
  width: 53px;
  height: 59px;
  position: absolute;
  left: 1898px;
  top: 31px;
  object-fit: cover;
}
.dashboard-layout {
  width: 35px;
  height: 35px;
  position: absolute;
  left: 27px;
  top: 439px;
  object-fit: cover;
}
.online-store {
  width: 53px;
  height: 57px;
  position: absolute;
  left: 19px;
  top: 203px;
  object-fit: cover;
}
.group-131 {
  position: absolute;
  inset: 0;
}
.div6 {
  color: #ffffff;
  text-align: left;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 25px;
  font-weight: 400;
  position: absolute;
  left: 1068.91px;
  top: 139.03px;
  width: 167.55px;
  height: 30.94px;
}
.group-127 {
  width: 244.98px;
  height: 51px;
  position: static;
}
.rectangle-40 {
  background: #ff74a6;
  border-radius: 13px;
  width: 244.98px;
  height: 51px;
  position: absolute;
  left: 1025px;
  top: 129px;
}
.div7 {
  color: #ffffff;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 25px;
  font-weight: 400;
  position: absolute;
  left: 1063px;
  top: 136px;
  width: 167.55px;
  height: 30.94px;
}
._2024-10-29-21-13 {
  color: #000000;
  text-align: left;
  font-family: "Inter-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 1041px;
  top: 89px;
  width: 212px;
  height: 26px;
}
.div8 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 920px;
  top: 212px;
  width: 71px;
  height: 19px;
  display: flex;
  align-items: center;
  justify-content: center;
}

/* 새로 추가된 테이블 스타일 */
/* 수정된 테이블 컨테이너 스타일 */
.user-table-container {
  width: 100%;
  height: 100%;
  padding: 0; /* 패딩 제거 */
  overflow-y: auto;
}

/* 수정된 테이블 스타일 */
.user-table {
  width: 100%; /* 너비 100%로 설정 */
  margin: 0; /* 마진 제거 */
  border-collapse: collapse;
  background: white;
}

/* 테이블 헤더 스타일 수정 */
.user-table th {
  background: #f8f9fa;
  padding: 15px;
  text-align: center;
  font-family: sans-serif;
  font-size: 16px;
  color: #333;
  border-bottom: 2px solid #dee2e6;
  position: sticky; /* 헤더 고정 */
  top: 0; /* 헤더 고정 */
  z-index: 1; /* 헤더가 내용 위에 보이도록 */
}

/* 테이블 셀 스타일 수정 */
.user-table td {
  padding: 15px;
  text-align: center;
  border-bottom: 1px solid #dee2e6;
  font-family: sans-serif;
  font-size: 14px;
}

/* rectangle-34 스타일 수정 */
.rectangle-34 {
  background: #fdfdfd;
  border-radius: 19px;
  width: 1111px;
  height: 513px;
  position: absolute;
  left: 159px;
  top: 250px;
  padding: 0; /* 패딩 제거 */
  overflow: hidden; /* 내용이 넘치지 않도록 */
}
</style>


<body>
<div class="user-board">
  <div class="rectangle-1"></div>
  <img class="list-of-parts" src="list-of-parts0.png" />
  <div class="rectangle-4"></div>
  <img class="customer" src="customer0.png" />
  <div class="rectangle-2"></div>
  <div class="rectangle-3"></div>
  <div class="rectangle-39"></div>
  
  
  <img class="rectangle-18" src="rectangle-180.svg" />
  <div class="rectangle-34"></div>
  <div class="div">아이디</div>
  <div class="div2">이름</div>
  <div class="div3">비밀번호</div>
  <div class="div4">성별</div>
  <div class="div5">....</div>
  
  
  <div class="user-board2">User Board</div>
  <img class="export" src="export0.png" />
  <img class="ellipse-1" src="ellipse-10.png" />
  <img class="dashboard-layout" src="dashboard-layout0.png" />
  <img class="online-store" src="online-store0.png" />
  <div class="div6">신고된 게시글</div>
  <div class="group-127">
    <div class="rectangle-40"></div>
    <div class="div7">신고된 유저</div>
  </div>
  <div class="_2024-10-29-21-13">2024-10-29 21:13 기준</div>
  <div class="div8">생일</div>
</div>

	
</body>
</html>