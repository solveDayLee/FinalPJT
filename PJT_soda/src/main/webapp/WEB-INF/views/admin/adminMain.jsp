<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.home-page,
.home-page * {
  box-sizing: border-box;
}
.home-page {
  background: #ffffff;
  height: 811px;
  position: relative;
  overflow: hidden;
}
.image-1 {
  background: linear-gradient(
    69.25deg,
    rgba(209, 107, 165, 0.3) 0%,
    rgba(134, 168, 231, 0.3) 51.73613429069519%,
    rgba(95, 251, 241, 0.3) 100%
  );
  width: 1272px;
  height: 811px;
  position: absolute;
  left: 64px;
  top: 1px;
  filter: blur(15px);
  object-fit: cover;
}
.rectangle-1 {
  background: #f9f9f9;
  width: 93px;
  height: 810px;
  position: absolute;
  left: 0px;
  top: 0px;
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
  width: 1243px;
  height: 75px;
  position: absolute;
  left: 93px;
  top: 0px;
}
.export {
  width: 35px;
  height: 35px;
  position: absolute;
  left: 29px;
  top: 746px;
  object-fit: cover;
}
.ellipse-1 {
  border-radius: 50%;
  width: 59px;
  height: 59px;
  position: absolute;
  left: 1898px;
  top: 31px;
  object-fit: cover;
}
.group-13 {
  position: absolute;
  inset: 0;
}
.welcome-to-our-application-click-button-below-to-start-the-program {
  color: #ffffff;
  text-align: left;
  position: absolute;
  right: 6.66%;
  left: 14%;
  width: 79.34%;
  bottom: 20.22%;
  top: 19.61%;
  height: 60.17%;
}
.welcome-to-our-application-click-button-below-to-start-the-program-span {
  color: #ffffff;
  font-family: "RobotoMono-Bold", sans-serif;
  font-size: 70px;
  font-weight: 700;
}
.welcome-to-our-application-click-button-below-to-start-the-program-span2 {
  color: #ffffff;
  font-family: "RobotoMono-Bold", sans-serif;
  font-size: 20px;
  font-weight: 700;
}
.welcome-to-our-application-click-button-below-to-start-the-program-span3 {
  color: #ffffff;
  font-family: "RobotoMono-Bold", sans-serif;
  font-size: 35px;
  font-weight: 700;
}
.group-11 {
  width: 268px;
  height: 72.8px;
  position: static;
}
.rectangle-20 {
  background: #1678f3;
  border-radius: 56.5px;
  width: 268px;
  height: 72.8px;
  position: absolute;
  left: 187px;
  top: 619px;
}
.rectangle-21 {
  background: linear-gradient(
    265.94deg,
    rgba(249, 132, 244, 1) 0%,
    rgba(22, 120, 243, 0) 100%
  );
  border-radius: 56.5px;
  width: 268px;
  height: 72.8px;
  position: absolute;
  left: 187px;
  top: 619px;
}
.get-s-started {
  width: 219px;
  height: 38px;
  position: absolute;
  left: 212px;
  top: 636px;
}
.get-s-started2 {
  color: #ffffff;
  text-align: left;
  font-family: "RobotoMono-Regular", sans-serif;
  font-size: 28px;
  font-weight: 400;
  position: absolute;
  right: 0%;
  left: 0%;
  width: 100%;
  bottom: 0%;
  top: 0%;
  height: 100%;
}
.list-of-parts {
  width: 37px;
  height: 50px;
  position: absolute;
  left: 29px;
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
  left: 20px;
  top: 311px;
  box-shadow: 0px 6px 4px 0px rgba(0, 0, 0, 0.1);
}
.customer {
  width: 35px;
  height: 35px;
  position: absolute;
  left: 29px;
  top: 320px;
  object-fit: cover;
}
.dashboard-layout {
  width: 35px;
  height: 35px;
  position: absolute;
  left: 29px;
  top: 439px;
  object-fit: cover;
}
.online-store {
  width: 53px;
  height: 57px;
  position: absolute;
  left: 21px;
  top: 203px;
  object-fit: cover;
}

</style>


<body>
	<div class="home-page">
  <img class="image-1" src="image-10.png" />
  <div class="rectangle-1"></div>
  <div class="rectangle-2"></div>
  <div class="rectangle-3"></div>
  <img class="export" src="export0.png" />
  <img class="ellipse-1" src="ellipse-10.png" />
  <div
    class="welcome-to-our-application-click-button-below-to-start-the-program"
  >
    <span>
      <span
        class="welcome-to-our-application-click-button-below-to-start-the-program-span"
      >
        Welcome To Our Application
        <br />
      </span>
      <span
        class="welcome-to-our-application-click-button-below-to-start-the-program-span2"
      >
        <br />
        <br />
        <br />
      </span>
      <span
        class="welcome-to-our-application-click-button-below-to-start-the-program-span3"
      >
        Click Button Below to Start the Program
      </span>
    </span>
  </div>
  <div class="group-11">
    <div class="rectangle-20"></div>
    <div class="rectangle-21"></div>
    <div class="get-s-started">
      <a href="${pageContext.request.contextPath}/admin/adminUserBoard"><div class="get-s-started2">Get Started</div></a>
    </div>
  </div>
  <img class="list-of-parts" src="list-of-parts0.png" />
  <div class="rectangle-4"></div>
  <img class="customer" src="customer0.png" />
  <img class="dashboard-layout" src="dashboard-layout0.png" />
  <img class="online-store" src="online-store0.png" />
</div>

	
</body>
</html>