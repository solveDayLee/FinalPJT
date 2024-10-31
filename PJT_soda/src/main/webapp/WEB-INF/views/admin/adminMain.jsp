<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.div,
.div * {
  box-sizing: border-box;
}
.div {
  background: #efefef;
  height: 1024px;
  position: relative;
  overflow: hidden;
}
.rectangle-3 {
  width: 217px;
  height: 1024px;
  position: absolute;
  left: 0px;
  top: 0px;
}
.rectangle-32 {
  background: #d9d9d9;
  width: 100%;
  height: 100%;
  position: absolute;
  right: 0%;
  left: 0%;
  bottom: 0%;
  top: 0%;
}
.logo {
  color: #000000;
  text-align: left;
  font-family: "InriaSans-Regular", sans-serif;
  font-size: 40px;
  font-weight: 400;
  position: absolute;
  right: 35.94%;
  left: 12.44%;
  width: 51.61%;
  bottom: 92.68%;
  top: 2.73%;
  height: 4.59%;
}
.board-button {
  background: linear-gradient(to left, rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.2)),
    linear-gradient(to left, #ffffff, #ffffff);
  padding: 10px;
  display: flex;
  flex-direction: row;
  gap: 10px;
  align-items: center;
  justify-content: flex-start;
  width: 100%;
  height: 7.03%;
  position: absolute;
  right: 0%;
  left: 0%;
  bottom: 63.18%;
  top: 29.79%;
}
.interface-essential-location {
  flex-shrink: 0;
  width: 46px;
  height: 46px;
  position: relative;
  overflow: visible;
}
.main {
  color: #000000;
  text-align: left;
  font-family: "InriaSans-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: relative;
}
.interface-essential-location2 {
  flex-shrink: 0;
  width: 46px;
  height: 46px;
  position: relative;
  overflow: visible;
}
.board-button2 {
  background: linear-gradient(to left, rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.2)),
    linear-gradient(to left, #ffffff, #ffffff);
  padding: 10px;
  display: flex;
  flex-direction: row;
  gap: 10px;
  align-items: center;
  justify-content: flex-start;
  width: 100%;
  height: 7.03%;
  position: absolute;
  right: 0%;
  left: 0%;
  bottom: 56.15%;
  top: 36.82%;
}
.interface-essential-location3 {
  flex-shrink: 0;
  width: 46px;
  height: 46px;
  position: relative;
  overflow: visible;
}
.rectangle-9 {
  background: #ffffff;
  width: 563.59%;
  height: 7.32%;
  position: absolute;
  right: -563.59%;
  left: 100%;
  bottom: 92.68%;
  top: 0%;
}
.user-button {
  background: linear-gradient(to left, rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.2)),
    linear-gradient(to left, #ffffff, #ffffff);
  padding: 10px;
  display: flex;
  flex-direction: row;
  gap: 10px;
  align-items: center;
  justify-content: flex-start;
  width: 15.07%;
  height: 7.03%;
  position: absolute;
  right: 84.93%;
  left: 0%;
  bottom: 77.25%;
  top: 15.72%;
}
.interface-essential-location4 {
  flex-shrink: 0;
  width: 46px;
  height: 46px;
  position: relative;
  overflow: visible;
}
.user-button2 {
  background: linear-gradient(to left, rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.2)),
    linear-gradient(to left, #ffffff, #ffffff);
  padding: 10px;
  display: flex;
  flex-direction: row;
  gap: 10px;
  align-items: center;
  justify-content: flex-start;
  width: 15.07%;
  height: 7.03%;
  position: absolute;
  right: 84.93%;
  left: 0%;
  bottom: 70.21%;
  top: 22.75%;
}
.interface-essential-location5 {
  flex-shrink: 0;
  width: 46px;
  height: 46px;
  position: relative;
  overflow: visible;
}
.user-button3 {
  background: linear-gradient(to left, rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.2)),
    linear-gradient(to left, #ffffff, #ffffff);
  border-radius: 15px;
  padding: 10px;
  display: flex;
  flex-direction: row;
  gap: 10px;
  align-items: center;
  justify-content: flex-start;
  width: 14.44%;
  height: 5.18%;
  position: absolute;
  right: 2.36%;
  left: 83.19%;
  bottom: 93.75%;
  top: 1.07%;
}
.interface-essential-location6 {
  flex-shrink: 0;
  width: 46px;
  height: 46px;
  position: relative;
  overflow: visible;
}
.user-button4 {
  background: linear-gradient(to left, rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.2)),
    linear-gradient(to left, #ffffff, #ffffff);
  padding: 10px;
  display: flex;
  flex-direction: row;
  gap: 10px;
  align-items: center;
  justify-content: flex-start;
  width: 15.07%;
  height: 7.03%;
  position: absolute;
  right: 84.93%;
  left: 0%;
  bottom: 0%;
  top: 92.97%;
}
.interface-essential-location7 {
  flex-shrink: 0;
  width: 46px;
  height: 46px;
  position: relative;
  overflow: visible;
}
.rectangle-11 {
  background: #d9d9d9;
  width: 482px;
  height: 571px;
  position: absolute;
  left: 603px;
  top: 227px;
}
.ellipse-1 {
  background: #ffffff;
  border-radius: 50%;
  width: 278px;
  height: 278px;
  position: absolute;
  left: 705px;
  top: 318px;
}
.interface-essential-location8 {
  width: 211px;
  height: 211px;
  position: absolute;
  left: 738px;
  top: 364px;
  overflow: visible;
}
.admin {
  color: #000000;
  text-align: center;
  font-family: "InriaSans-Regular", sans-serif;
  font-size: 40px;
  font-weight: 400;
  position: absolute;
  left: 738px;
  top: 640px;
  width: 218px;
  height: 68px;
}
.group-2 {
  width: 1440px;
  height: 44px;
  position: absolute;
  left: 0px;
  top: 75px;
}
.group-1 {
  position: absolute;
  inset: 0;
}
.rectangle-35 {
  width: 100%;
  height: 100%;
  position: absolute;
  right: 0%;
  left: 0%;
  bottom: 0%;
  top: 0%;
}
.rectangle-352 {
  background: #d9d9d9;
  width: 100%;
  height: 100%;
  position: absolute;
  right: 0%;
  left: 0%;
  bottom: 0%;
  top: 0%;
}
._2024-10-29-21-13 {
  color: #000000;
  text-align: left;
  font-family: "Inter-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  right: 1.04%;
  left: 84.24%;
  width: 14.72%;
  bottom: 18.18%;
  top: 22.73%;
  height: 59.09%;
}
.group-4 {
  width: 227px;
  height: 28px;
  position: absolute;
  left: 971px;
  top: 28px;
}
.eye-open {
  width: 14.98%;
  height: 100%;
  position: absolute;
  right: 85.02%;
  left: 0%;
  bottom: 0%;
  top: 0%;
  overflow: visible;
}
.div2 {
  color: #000000;
  text-align: left;
  font-family: "Inter-Regular", sans-serif;
  font-size: 20px;
  font-weight: 400;
  position: absolute;
  right: 0%;
  left: 14.98%;
  width: 85.02%;
  bottom: 50%;
  top: 3.57%;
  height: 46.43%;
}


</style>


<body>
	<div class="div">
  <div class="rectangle-3">
    <div class="rectangle-32"></div>
    <div class="logo">LOGO</div>
    <div class="board-button">
      <img
        class="interface-essential-location"
        src="interface-essential-location0.svg"
      />
      <div class="main">board</div>
    </div>
    <div class="board-button">
      <img
        class="interface-essential-location2"
        src="interface-essential-location1.svg"
      />
      <div class="main">board</div>
    </div>
    <div class="board-button2">
      <img
        class="interface-essential-location3"
        src="interface-essential-location2.svg"
      />
      <div class="main">notice</div>
    </div>
    <div class="rectangle-9"></div>
  </div>
  <div class="user-button">
    <img
      class="interface-essential-location4"
      src="interface-essential-location3.svg"
    />
    <div class="main">main</div>
  </div>
  <div class="user-button2">
    <img
      class="interface-essential-location5"
      src="interface-essential-location4.svg"
    />
    <div class="main">user</div>
  </div>
  <div class="user-button3">
    <img
      class="interface-essential-location6"
      src="interface-essential-location5.svg"
    />
    <div class="main">logout</div>
  </div>
  <div class="user-button4">
    <img
      class="interface-essential-location7"
      src="interface-essential-location6.svg"
    />
    <div class="main">info</div>
  </div>
  <div class="rectangle-11"></div>
  <div class="ellipse-1"></div>
  <img
    class="interface-essential-location8"
    src="interface-essential-location7.svg"
  />
  <div class="admin">
    관리자 :
    <br />
    admin 님
  </div>
  <div class="group-2">
    <div class="rectangle-35">
      <div class="rectangle-352"></div>
    </div>
    <div class="_2024-10-29-21-13">2024-10-29 21:13 기준</div>
  </div>
  <div class="group-4">
    <img class="eye-open" src="eye-open0.svg" />
    <div class="div2">관리자님 안녕하세요!</div>
  </div>
</div>
	
</body>
</html>