<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 상세</title>
<style>
/* 기존 스타일 유지 */
.customer-detail {
  background: #ffffff;
  height: 811px;
  position: relative;
  overflow: hidden;
}
.sidebar {
  background: #f9f9f9;
  width: 93px;
  height: 810px;
  position: absolute;
  left: 0;
  top: 0;
}
.sidebar-header {
  background: #f3f3f3;
  width: 93px;
  height: 75px;
}
.top-header {
  background: #fcfcfc;
  width: 1240px;
  height: 75px;
  position: absolute;
  left: 96px;
  top: 0;
}
.menu-icon {
  background: #1678f3;
  border-radius: 22px;
  width: 53px;
  height: 53px;
  position: absolute;
  left: 18px;
  top: 311px;
  box-shadow: 0px 6px 4px 0px rgba(0, 0, 0, 0.1);
}
.page-title {
  color: #000000;
  font-family: sans-serif;
  font-size: 35px;
  position: absolute;
  left: 120px;
  top: 11px;
}
.content-area {
  position: absolute;
  left: 160px;
  top: 100px;
  width: 1111px;
}
table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
  background: #fdfdfd;
  border-radius: 8px;
  overflow: hidden;
}
th, td {
  padding: 15px;
  text-align: left;
  border-bottom: 1px solid #f5f5f5;
}
th {
  background-color: #f8f9fa;
  width: 200px;
  font-weight: normal;
}

/* 버튼 영역 수정 */
.top-buttons {
  position: absolute;
  right: 160px;
  top: 20px;
  display: flex;
  gap: 20px;
}
.btn-area {
  position: absolute;
  right: 160px;
  bottom: 40px;
  display: flex;
  gap: 20px;
}
.btn {
  border-radius: 13px;
  height: 51px;
  border: none;
  font-size: 16px;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0 30px;
  font-family: sans-serif;
}
.btn-pink {
  background: #ff74a6;
  color: white;
  min-width: 245px;
}
.btn-edit {
  background: #bddaff;
  min-width: 118px;
  border-radius: 50px;
  height: 35px;
}
.btn-delete {
  background: #ff7474;
  color: white;
  min-width: 118px;
  border-radius: 50px;
  height: 35px;
}
.btn-report {
  background: #ff74a6;
  color: white;
  min-width: 118px;
  border-radius: 50px;
  height: 35px;
}
.icon {
  width: 35px;
  height: 35px;
  position: absolute;
}
.icon-customer {
  left: 27px;
  top: 320px;
}
.icon-dashboard {
  left: 27px;
  top: 439px;
}
.icon-store {
  left: 19px;
  top: 203px;
}
.icon-parts {
  left: 27px;
  top: 528px;
}
.icon-export {
  left: 27px;
  top: 728px;
}
.date-info {
  position: absolute;
  right: 160px;
  top: 89px;
  font-size: 20px;
  color: #000000;
}
/* style 태그 내에 추가할 CSS */
input {
  border: none;
  background: transparent;
  font-size: 16px;
  width: 100%;
  padding: 0;
  font-family: inherit;
}

</style>
</head>
<body>
<div class="customer-detail">
  <div class="sidebar">
    <div class="sidebar-header"></div>
    <a href="${pageContext.request.contextPath}/admin/adminUserBoard"><div class="menu-icon"></div></a>
    <img class="icon icon-customer" src="customer0.png" />
    <img class="icon icon-dashboard" src="dashboard-layout0.png" />
    <img class="icon icon-store" src="online-store0.png" />
    <img class="icon icon-parts" src="list-of-parts0.png" />
    <img class="icon icon-export" src="export0.png" />
  </div>
  
  <div class="top-header"></div>
  <div class="top-buttons">
    <button type="button" class="btn btn-pink">신고된 유저</button>
  </div>
  
  <h1 class="page-title">사용자 상세 정보</h1>
  <div class="date-info"></div>

  <form action="/admin/adminUserUpdate" method="post">
   <input type="hidden" name="userNo" value="${user.userNo}">
  <div class="content-area">
    <table>
      <tr><th>아이디</th><td><input value="${user.userId}" name="userId" readonly></td></tr>
      <tr><th>비밀번호</th><td><input value="${user.password}" name="password"></td></tr>
      <tr><th>이름</th><td><input value="${user.name}" name="name"></td></tr>
      <tr><th>이메일</th><td><input value="${user.email}" name="email"></td></tr>
      <tr><th>전화번호</th><td><input value="${user.phoneNumber}" name="phoneNumber"></td></tr>
      <tr><th>생년월일</th><td><input value="${user.birthDate}" name="birthDate"></td></tr>
      <tr><th>성별</th><td><input value="${user.gender}" name="gender"></td></tr>
      <tr><th>주소</th><td><input value="${user.address}" name="address"></td></tr>
      <tr><th>상세주소</th><td><input value="${user.detailAddress}" name="detailAddress"></td></tr>
      <tr><th>우편번호</th><td><input value="${user.zonecode}" name="zoneCode"></td></tr>
      <tr><th>가입일</th><td><input value="${user.userRegDate}" name="userRegDate"></td></tr>
    </table>
  </div>
  <div class="btn-area">
    <button class="btn btn-edit">수정하기</button>
    <button type="button" class="btn btn-delete">삭제하기</button>
    <!-- <button type="button" class="btn btn-report">사용자 신고</button> -->
  </div>
  </form>
</div>

<script>
document.querySelector('.btn-edit').onclick = function() {
    console.log('수정하기 클릭');
}

document.querySelector('.btn-delete').onclick = function() {
	alert("${user.userId} 가 삭제됩니다. ")
	window.location.href = "${pageContext.request.contextPath}/admin/adminUserDelete?no=${user.userNo}";
}

document.querySelector('.btn-report').onclick = function() {
    console.log('사용자 신고 클릭');
}
function updateDateTime() {
    // 1. new Date(): 현재 날짜와 시간을 가져오는 객체 생성
    const now = new Date();

    // 2. options 객체: 날짜와 시간 형식을 지정
    const options = {
        year: 'numeric',     // 연도를 숫자로 표시 (예: 2024)
        month: '2-digit',    // 월을 2자리 숫자로 표시 (예: 01, 02, ..., 12)
        day: '2-digit',      // 일을 2자리 숫자로 표시 (예: 01, 02, ..., 31)
        hour: '2-digit',     // 시간을 2자리 숫자로 표시 (예: 00, 01, ..., 23)
        minute: '2-digit',   // 분을 2자리 숫자로 표시 (예: 00, 01, ..., 59)
        hour12: false        // 24시간 형식 사용 (true면 12시간 형식)
    };

    // 3. 날짜/시간을 화면에 표시
    document.querySelector("date-info").textContent =
        now.toLocaleString('ko-KR', options).replace(',', '') + ' 기준';
}

// 4. 함수 즉시 실행
updateDateTime();

// 5. 1분(60000밀리초)마다 함수 실행
setInterval(updateDateTime, 60000);

</script>
</body>
</html>