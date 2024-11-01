<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

.username {
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
	position: static;
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
	left: 380.21px;
	top: 572.33px;
}

.login2 {
	color: #ffffff;
	text-align: left;
	font-family: "RoundedMplus1C-Regular", sans-serif;
	font-size: 21px;
	font-weight: 400;
	position: absolute;
	left: 464.71px;
	top: 580.34px;
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
	width: 147.32px;
	height: 27.02px;
}

.insert-username {
	color: #7d7d7d;
	text-align: left;
	font-family: "RoundedMplus1C-Regular", sans-serif;
	font-size: 18px;
	font-weight: 400;
	opacity: 0.5;
	position: absolute;
	left: 224.23px;
	top: 362.21px;
	width: 149.49px;
	height: 27.02px;
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

	<div class="login-form">
		<div class="canvas"></div>
		<div class="rectangle-9"></div>
		<div class="rectangle-16"></div>
		<div class="username">Username</div>
		<div class="password">Password</div>
		<div class="rectangle-10"></div>
		<img class="hide" src="hide0.png" />
		<div class="login-button">
			<div class="rectangle-12"></div>
			<div class="login2">Login</div>
		</div>
		<div class="rectangle-11"></div>
		<div class="get-s-started">Get’s Started</div>
		<div class="don-t-have-account">Don’t have Account ?</div>
		<div class="sign-up">Sign Up</div>
		<img class="lock" src="lock0.png" />
		<div class="insert-password">Insert Password</div>
		<div class="insert-username">Insert Username</div>
		<img class="user" src="user0.png" />
	</div>

</body>
</html>