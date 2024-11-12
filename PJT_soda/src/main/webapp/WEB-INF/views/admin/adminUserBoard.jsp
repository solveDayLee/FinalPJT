<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Board</title>
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

.rectangle-34 {
  background: #fdfdfd;
  border-radius: 19px;
  width: 1111px;
  height: 513px;
  position: absolute;
  left: 159px;
  top: 250px;
  padding: 0;
  overflow: hidden;
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

/* 테이블 스타일 */
.user-table-container {
  width: 100%;
  height: 100%;
  padding: 0;
  overflow-y: auto;
}

.user-table {
  width: 100%;
  margin: 0;
  border-collapse: collapse;
  background: white;
}

.user-table th {
  background: #f8f9fa;
  padding: 15px;
  text-align: center;
  font-family: sans-serif;
  font-size: 16px;
  color: #333;
  border-bottom: 2px solid #dee2e6;
  position: sticky;
  top: 0;
  z-index: 1;
}

.user-table td {
  padding: 15px;
  text-align: center;
  border-bottom: 1px solid #dee2e6;
  font-family: sans-serif;
  font-size: 14px;
}

/* 검색 영역 스타일 */
.search-area {
  position: absolute;
  left: 153px;
  top: 129px;
  display: flex;
  align-items: center;
  gap: 10px;
  z-index: 2;
}

.search-area select {
  height: 37px;
  width: 120px;
  border-radius: 9px;
  border: 0.5px solid #353535;
  background: #f3f3f3;
  padding: 0 10px;
  font-family: "RoundedMplus1c-Regular", sans-serif;
  font-size: 14px;
}

.search-area input {
  width: 347px;
  height: 37px;
  border-radius: 9px;
  border: 0.5px solid #353535;
  background: #f3f3f3;
  padding: 0 10px;
  font-family: "RoundedMplus1c-Regular", sans-serif;
  font-size: 14px;
}
/* 등록 버튼 스타일 추가 */
.register-btn {
    height: 37px;
    padding: 0 20px;
    border-radius: 9px;
    border: none;
    background: #1678f3;  /* 파란색 계열로 설정 */
    color: white;
    font-family: "RoundedMplus1c-Regular", sans-serif;
    font-size: 14px;
    cursor: pointer;
    transition: background-color 0.2s;
}
</style>
</head>

<body>
<div class="user-board">
  <div class="rectangle-1"></div>
  <img class="list-of-parts" src="list-of-parts0.png" />
  <div class="rectangle-4"></div>
  <img class="customer" src="customer0.png" />
  <div class="rectangle-2"></div>
  <div class="rectangle-3"></div>
  
  <!-- 검색 영역 -->
  <div class="search-area">
    <select id="searchCategory" onchange="changePlaceholder()">
      <option value="name">이름 검색</option>
      <option value="user_id">아이디 검색</option>
      <option value="email">이메일 검색</option>
    </select>
    <input type="text" id="searchInput" placeholder="사용자 아이디로 검색하기"> 
  	 <button type="button" id="searchButton" class="register-btn">검색</button>
  </div>

  <!-- 테이블 영역 -->
  <div class="rectangle-34">
    <div class="user-table-container">
      <table class="user-table">
        <thead>
          <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>성별</th>
            <th>생일</th>
            <th>핸드폰 번호</th>
            <th>가입일자</th>
            <th>...</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${list}" var="user">
            <tr onclick="location.href='${pageContext.request.contextPath}/admin/adminUserDetail?no=${user.userNo}'">
              <td>${user.userId}</td>
              <td>${user.name}</td>
              <td>${user.gender}</td>
              <td>${user.birthDate}</td>
              <td>${user.phoneNumber}</td>
              <td>${user.userRegDate}</td>
              <td>...</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  
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
  <div class="_2024-10-29-21-13">2024-10-29 21:13 기준</div>
</div>
<script type="text/javascript">
    const select = document.getElementById('searchCategory');
    const input = document.getElementById('searchInput');
    const button = document.getElementById('searchButton');
    const contextPath = '${pageContext.request.contextPath}';
    
function changePlaceholder() {
    
    // 플레이스홀더 변경
    switch(select.value) {
        case 'name':
            input.placeholder = "사용자 이름으로 검색하기";
            break;
        case 'user_id':
            input.placeholder = "사용자 id로 검색하기";
            break;
        case 'email':
            input.placeholder = "사용자 이메일로 검색하기";
            break;
    }
}
    // 검색 버튼 클릭 이벤트
    document.getElementById('searchButton').addEventListener('click', function (){
    	const keyword = input.value.trim();
    	console.log(keyword);
        if(keyword) {
        	const URL = `\${contextPath}/admin/searchAdminUserBoard?category=\${select.value}&keyword=\${keyword}`;
            console.log("요청 URL :" , URL);
         	location.href = URL; 
        	} else {
            alert('검색어를 입력해주세요.');
        } 
    });


// 페이지 로드 시 초기 설정
document.addEventListener('DOMContentLoaded', function() {
    changePlaceholder();
});
</script>
</body>
</html>