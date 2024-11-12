
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

.date-info {
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
</style>
</head>
<body>
	<div class="customer-detail">
		<div class="sidebar">
			<div class="sidebar-header"></div>
			<div class="menu-icon"></div>
			<img class="icon icon-customer" src="customer0.png" /> <img
				class="icon icon-dashboard" src="dashboard-layout0.png" /> <img
				class="icon icon-store" src="online-store0.png" /> <img
				class="icon icon-parts" src="list-of-parts0.png" /> <img
				class="icon icon-export" src="export0.png" />
		</div>

		<div class="top-header"></div>
		<div class="top-buttons">
			<button type="button" class="btn btn-pink">신고된 유저</button>
		</div>

		<h1 class="page-title">사용자 상세 정보</h1>
		<div class="date-info">실시간 날짜 기준</div>

        <form action="/admin/adminUserUpdate" method="post">
            <input type="hidden" name="userNo" value="${user.userNo}" >
            <div class="content-area">
                <table>
                    <tr>
                        <th>아이디</th>
                        <td><input name="userId" value="${user.userId}" readonly></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input name="password" value="${user.password}"></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input name="name" value="${user.name}"></td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td><input name="email" value="${user.email}"></td>
                    </tr>
                    <tr>
                        <th>전화번호</th>
                        <td><input name="phoneNumber" value="${user.phoneNumber}"></td>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <td><input name="birthDate" value="${user.birthDate}"></td>
                    </tr>
                    <tr>
                        <th>성별</th>
                        <td><input name="gender" value="${user.gender}"></td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td><input name="address" value="${user.address}"></td>
                    </tr>
                    <tr>
                        <th>상세주소</th>
                        <td><input name="detailAddress" value="${user.detailAddress}"></td>
                    </tr>
                    <tr>
                        <th>우편번호</th>
                        <td><input name="zonecode" value="${user.zonecode}"></td>
                    </tr>
                    <tr>
                        <th>가입일</th>
                        <td><input name="userRegDate" value="${user.userRegDate}" readonly></td>
                    </tr>
                </table>
            </div>
            <div class="btn-area">
                <button type="submit" class="btn btn-edit">수정하기</button>
                <button type="button" class="btn btn-delete">삭제하기</button>
                <!-- <button type="button" class="btn btn-report">사용자 신고</button> -->
            </div>
        </form>
	</div>

	<script>
		function updateDateTime() {
			const now = new Date();
			const options = {
				year : 'numeric',
				month : '2-digit',
				day : '2-digit',
				hour : '2-digit',
				minute : '2-digit',
				hour12 : false
			};
			// 클래스 선택자를 'date-info'로 변경
			document.querySelector('.date-info').textContent = now
					.toLocaleString('ko-KR', options).replace(',', '')
					+ ' 기준';
		}

		// 페이지 로드 시 초기 실행
		updateDateTime();

		// 1분마다 업데이트
		setInterval(updateDateTime, 60000);

		//////////////////////////////////////////////////////////////////

		document.querySelector('.btn-delete').onclick = function() {
			if (confirm('정말 삭제하시겠습니까?')) {
				//정보를 받아줘야하니까 datail주소를 그대로 준다.
				location.href = '/admin/adminUserDelete?no=${user.userNo}';
			}
			console.log('삭제하기 클릭');
		}
	</script>
</body>
</html>