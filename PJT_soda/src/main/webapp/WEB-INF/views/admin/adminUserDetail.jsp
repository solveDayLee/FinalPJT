<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.customer-detail,
.customer-detail * {
  box-sizing: border-box;
}
.customer-detail {
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
  left: 149px;
  top: 161px;
  transform-origin: 0 0;
  transform: rotate(0deg) scale(1, -1);
}
.rectangle-18 {
  border-radius: 0px;
  width: 1133px;
  height: 583px;
  position: absolute;
  left: 149px;
  top: 195px;
  overflow: visible;
}
.rectangle-34 {
  background: #fdfdfd;
  border-radius: 19px;
  width: 1111px;
  height: 54px;
  position: absolute;
  left: 160px;
  top: 206px;
}
.rectangle-42 {
  background: #fdfdfd;
  border-radius: 19px;
  width: 1111px;
  height: 54px;
  position: absolute;
  left: 160px;
  top: 272px;
}
.rectangle-43 {
  background: #fdfdfd;
  border-radius: 19px;
  width: 1111px;
  height: 54px;
  position: absolute;
  left: 160px;
  top: 338px;
}
.rectangle-44 {
  background: #fdfdfd;
  border-radius: 19px;
  width: 1111px;
  height: 54px;
  position: absolute;
  left: 160px;
  top: 404px;
}
.rectangle-45 {
  background: #fdfdfd;
  border-radius: 19px;
  width: 1111px;
  height: 54px;
  position: absolute;
  left: 160px;
  top: 470px;
}
.rectangle-41 {
  border-radius: 0px;
  width: 1111px;
  height: 151px;
  position: absolute;
  left: 160px;
  top: 536px;
  overflow: visible;
}
.user-board-detail {
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
.div {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 188px;
  top: 224px;
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
  left: 283px;
  top: 224px;
  width: 95px;
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
  left: 190px;
  top: 290px;
  width: 102px;
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
  left: 276px;
  top: 290px;
  width: 102px;
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
  left: 176px;
  top: 356px;
  width: 100px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.div6 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 292px;
  top: 355px;
  width: 100px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.div7 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 195px;
  top: 421px;
  width: 91px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.div8 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 286px;
  top: 421px;
  width: 91px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.div9 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 194px;
  top: 487px;
  width: 94px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.div10 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 280px;
  top: 487px;
  width: 94px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.div11 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 203px;
  top: 560px;
  width: 80px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.div12 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 291px;
  top: 560px;
  width: 80px;
  height: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.group-128 {
  position: absolute;
  inset: 0;
}
.div13 {
  color: #ffffff;
  text-align: left;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 25px;
  font-weight: 400;
  position: absolute;
  left: 1069.91px;
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
  left: 1026px;
  top: 129px;
}
.div14 {
  color: #ffffff;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 25px;
  font-weight: 400;
  position: absolute;
  left: 1064px;
  top: 136px;
  width: 167.55px;
  height: 30.94px;
}
.group-129 {
  position: absolute;
  inset: 0;
}
.rectangle-402 {
  background: #bddaff;
  border-radius: 50px;
  width: 118px;
  height: 35px;
  position: absolute;
  left: 979px;
  top: 752px;
  transform-origin: 0 0;
  transform: rotate(0deg) scale(1, -1);
}
.div15 {
  color: #000000;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 18px;
  font-weight: 400;
  position: absolute;
  left: 993px;
  top: 721px;
  width: 90px;
  height: 31px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.group-131 {
  position: absolute;
  inset: 0;
}
.rectangle-403 {
  background: #ff74a6;
  border-radius: 50px;
  width: 118px;
  height: 35px;
  position: absolute;
  left: 839px;
  top: 752px;
  transform-origin: 0 0;
  transform: rotate(0deg) scale(1, -1);
}
.div16 {
  color: #ffffff;
  text-align: center;
  font-family: "RoundedMplus1C-Regular", sans-serif;
  font-size: 18px;
  font-weight: 400;
  position: absolute;
  left: 853px;
  top: 721px;
  width: 90px;
  height: 31px;
  display: flex;
  align-items: center;
  justify-content: center;
}
._2024-10-29-21-13 {
  color: #000000;
  text-align: left;
  font-family: "Inter-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  left: 1059px;
  top: 89px;
  width: 212px;
  height: 26px;
}


</style>


<body>
<div class="customer-detail">
  <div class="rectangle-1"></div>
  <img class="list-of-parts" src="list-of-parts0.png" />
  <div class="rectangle-4"></div>
  <img class="customer" src="customer0.png" />
  <div class="rectangle-2"></div>
  <div class="rectangle-3"></div>
  <div class="rectangle-39"></div>
  <img class="rectangle-18" src="rectangle-180.svg" />
  <div class="rectangle-34"></div>
  <div class="rectangle-42"></div>
  <div class="rectangle-43"></div>
  <div class="rectangle-44"></div>
  <div class="rectangle-45"></div>
  <img class="rectangle-41" src="rectangle-410.svg" />
  <div class="user-board-detail">User Board Detail</div>
  <img class="export" src="export0.png" />
  <img class="ellipse-1" src="ellipse-10.png" />
  <img class="dashboard-layout" src="dashboard-layout0.png" />
  <img class="online-store" src="online-store0.png" />
  <div class="div">아이디:</div>
  <div class="div2">&lcub;아이디&rcub;</div>
  <div class="div3">이름:</div>
  <div class="div4">&lcub;이름&rcub;</div>
  <div class="div5">비밀번호:</div>
  <div class="div6">&lcub;비밀번호&rcub;</div>
  <div class="div7">성별:</div>
  <div class="div8">&lcub;성별&rcub;</div>
  <div class="div9">생일:</div>
  <div class="div10">&lcub;생일&rcub;</div>
  <div class="div11">주소:</div>
  <div class="div12">&lcub;주소&rcub;</div>
  <div class="div13">신고된 게시글</div>
  <div class="group-127">
    <div class="rectangle-40"></div>
    <div class="div14">신고된 유저</div>
  </div>
  <div class="rectangle-402"></div>
  <div class="div15">수정하기</div>
  <div class="rectangle-403"></div>
  <div class="div16">유저 신고</div>
  <div class="_2024-10-29-21-13">2024-10-29 21:13 기준</div>
</div>

	
</body>
</html>