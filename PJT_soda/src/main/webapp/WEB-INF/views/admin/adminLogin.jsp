<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<style>
.login-form, .login-form * {
	box-sizing: border-box;
}

.login-form {
	background: #ffffff;
	height: 811px;
	position: relative;
	overflow: hidden;
}

.canvas {
	background: #1678f3;
	border-radius: 79px 0px 0px 79px;
	width: 451px;
	height: 811px;
	position: absolute;
	left: 885px;
	top: 0px;
}

.login {
	position: absolute;
	inset: 0;
}

.rectangle-9 {
	background: #ffffff;
	width: 782.09px;
	height: 811.47px;
	position: absolute;
	left: 102.91px;
	top: 0px;
}

.rectangle-16 {
	background: #1678f3;
	width: 9.75px;
	height: 811.47px;
	position: absolute;
	left: 0px;
	top: 0px;
}

.userId {
	color: #7d7d7d;
	text-align: left;
	font-family: "RoundedMplus1C-Regular", sans-serif;
	font-size: 18px;
	font-weight: 400;
	position: absolute;
	left: 180.9px;
	top: 325.19px;
	width: 88.82px;
	height: 27.02px;
}

.password {
	color: #7d7d7d;
	text-align: left;
	font-family: "RoundedMplus1C-Regular", sans-serif;
	font-size: 18px;
	font-weight: 400;
	position: absolute;
	left: 180.9px;
	top: 435.25px;
	width: 86.66px;
	height: 27.02px;
}

.rectangle-10 {
	background: #ffffff;
	border-radius: 13px;
	border-style: solid;
	border-color: #dddddd;
	border-width: 1.2px;
	width: 639.11px;
	height: 47.03px;
	position: absolute;
	left: 174.4px;
	top: 462.27px;
}

.hide {
	width: 21.66px;
	height: 20.01px;
	position: absolute;
	left: 772.34px;
	top: 476.28px;
	object-fit: cover;
}

.login-button {
	width: 227.48px;
	height: 47.03px;
	position: absolute; /* static에서 absolute로 변경 */
	left: 380px; /* 중앙 정렬을 위해 추가 */
	top: 540px; /* input 창 아래로 위치 조정 */
}

.rectangle-12 {
	background: #1678f3;
	border-radius: 23.5px;
	border-style: solid;
	border-color: #1678f3;
	border-width: 1.5px;
	width: 227.48px;
	height: 47.03px;
	position: absolute;
	left: 0px;
	top: 0px;
}

.login2 {
	color: #ffffff;
	text-align: center; /* left에서 center로 변경 */
	font-family: "RoundedMplus1C-Regular", sans-serif;
	font-size: 21px;
	font-weight: 400;
	position: absolute;
	left: 50%; /* 중앙 정렬을 위해 수정 */
	top: 50%; /* 중앙 정렬을 위해 수정 */
	transform: translate(-50%, -50%); /* 중앙 정렬을 위해 추가 */
	width: 58.49px;
	height: 31.02px;
}

.rectangle-11 {
	background: #ffffff;
	border-radius: 13px;
	border-style: solid;
	border-color: #dddddd;
	border-width: 1.2px;
	width: 639.11px;
	height: 47.03px;
	position: absolute;
	left: 174.4px;
	top: 352.2px;
}

.get-s-started {
	color: #7d7d7d;
	text-align: left;
	font-family: "RoundedMplus1C-Regular", sans-serif;
	font-size: 40px;
	font-weight: 400;
	position: absolute;
	left: 174px;
	bottom: 668.26px;
	width: 275.14px;
	height: 59.03px;
}

.don-t-have-account {
	color: #7d7d7d;
	text-align: left;
	font-family: "RoundedMplus1C-Regular", sans-serif;
	font-size: 25px;
	font-weight: 400;
	position: absolute;
	left: 174px;
	top: 193.33px;
	width: 267.56px;
	height: 37.02px;
}

.sign-up {
	color: #1678f3;
	text-align: left;
	font-family: "RoundedMplus1C-Medium", sans-serif;
	font-size: 25px;
	font-weight: 500;
	position: absolute;
	left: 484px;
	top: 193.33px;
	width: 97.49px;
	height: 37.02px;
}

.lock {
	width: 27.08px;
	height: 25.01px;
	position: absolute;
	left: 184.15px;
	top: 474.28px;
	object-fit: cover;
}

.insert-password {
	color: #7d7d7d;
	text-align: left;
	font-family: "RoundedMplus1C-Regular", sans-serif;
	font-size: 18px;
	font-weight: 400;
	opacity: 0.5;
	position: absolute;
	left: 225.31px;
	top: 472.27px;
	width: 500px; /* 입력 필드 넓이 증가 */
	height: 27.02px;
	outline: none; /* 이 줄 추가 */
	border: none; /* 이 줄 추가 */
}

.insert-userId {
	color: #7d7d7d;
	text-align: left;
	font-family: "RoundedMplus1C-Regular", sans-serif;
	font-size: 18px;
	font-weight: 400;
	opacity: 0.5;
	position: absolute;
	left: 224.23px;
	top: 362.21px;
	width: 500px; /* 입력 필드 넓이 증가 */
	height: 27.02px;
	outline: none; /* 이 줄 추가 */
	border: none; /* 이 줄 추가 */
}

.user {
	width: 25px;
	height: 25px;
	position: absolute;
	left: 186px;
	top: 363px;
	object-fit: cover;
}
</style>


<body>
	<!-- 절대 경로 사용 -->
	<form action="/admin/adminLogin" method="POST">
		<div class="login-form">
			<div class="canvas"></div>
			<div class="rectangle-9"></div>
			<div class="rectangle-16"></div>
			<div class="userId">userId</div>
			<div class="password">Password</div>
			<div class="rectangle-10"></div>
			<i class="bi bi-eye-slash"
				style="position: absolute; left: 772.34px; top: 476.28px; font-size: 20px; color: #7d7d7d; cursor: pointer;"></i>
			
			<button type="submit" class="login-button"
				style="border: none; background: none; cursor: pointer; padding: 0;">
				
				<div class="rectangle-12" ></div>
				<div class="login2">Login</div>
			</button>
			<div class="rectangle-11"></div>
			<div class="get-s-started">Get’s Started</div>

			<i class="bi bi-lock"
				style="position: absolute; left: 184.15px; top: 474.28px; font-size: 25px; color: #7d7d7d;"></i>
			<input class="insert-userId" placeholder="Insert UserId"
				name="userId" /> <input type="password" class="insert-password"
				placeholder="Insert Password" name="password" /> <i
				class="bi bi-person"
				style="position: absolute; left: 186px; top: 363px; font-size: 25px; color: #7d7d7d;"></i>
		</div>
	</form>

	<script>
		document.querySelector('.bi-eye-slash').addEventListener(
				'click',
				function() {
					const passwordInput = document
							.querySelector('.insert-password');
					if (passwordInput.type === 'password') {
						passwordInput.type = 'text';
						this.classList.replace('bi-eye-slash', 'bi-eye');
					} else {
						passwordInput.type = 'password';
						this.classList.replace('bi-eye', 'bi-eye-slash');
					}
				});
	</script>


</body>
</html>