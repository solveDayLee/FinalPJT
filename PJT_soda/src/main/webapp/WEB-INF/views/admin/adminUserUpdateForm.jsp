<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 상세</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">

</head>
<body>
     <!-- 사이드바 include -->
    <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>
    
    <!-- 헤더 include -->
    <%@ include file="/WEB-INF/views/common/userHeader.jsp" %>
    
    <div class="main-content">
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
                    <tr><th>가입일</th><td><input value="${user.userRegDate}" name="userRegDate" readonly></td></tr>
                </table>
                
                <div class="btn-area">
                    <button class="btn btn-edit">수정하기</button>
                    <button type="button" class="btn btn-delete">삭제하기</button>
                </div>
            </div>
        </form>
    </div>
</body>

<style>
.main-content {
    margin-left: 93px;
    margin-top: 75px;
    padding: 2rem;
    background: #f8f9fa;
    min-height: calc(100vh - 75px);
}

.content-area {
    background: #ffffff;
    border-radius: 12px;
    box-shadow: 0 2px 4px rgba(0,0,0,0.03);
    padding: 2rem;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 2rem;
    background: #fdfdfd;
    border-radius: 8px;
    overflow: hidden;
}

th, td {
    padding: 1rem;
    text-align: left;
    border-bottom: 1px solid #f5f5f5;
}

th {
    background-color: #f8f9fa;
    width: 200px;
    font-weight: normal;
    color: #495057;
}

td {
    color: #2c3e50;
}

input {
    border: none;
    background: transparent;
    font-size: 16px;
    width: 100%;
    padding: 0;
    font-family: inherit;
    color: #2c3e50;
}

input:focus {
    outline: none;
    background: #f8f9fa;
    border-radius: 4px;
    padding: 0.5rem;
}

input[readonly] {
    color: #6c757d;
    cursor: not-allowed;
}

.btn-area {
    display: flex;
    justify-content: flex-end;
    gap: 1rem;
    padding-top: 1rem;
}

.btn {
    padding: 0.5rem 1.5rem;
    border: none;
    border-radius: 50px;
    font-size: 14px;
    font-weight: 500;
    cursor: pointer;
    transition: all 0.2s;
    min-width: 118px;
    height: 35px;
    display: flex;
    align-items: center;
    justify-content: center;
}

.btn-edit {
    background: #bddaff;
    color: #1678f3;
}

.btn-edit:hover {
    background: #a5ceff;
    transform: translateY(-1px);
    box-shadow: 0 2px 4px rgba(22,120,243,0.2);
}

.btn-delete {
    background: #ff7474;
    color: white;
}

.btn-delete:hover {
    background: #ff5c5c;
    transform: translateY(-1px);
    box-shadow: 0 2px 4px rgba(255,116,116,0.2);
}
</style>

<script>
document.querySelector('.btn-delete').onclick = function() {
    if(confirm('${user.userId}를 정말 삭제하시겠습니까?')) {
        alert("${user.userId}가 삭제됩니다.");
        window.location.href = "${pageContext.request.contextPath}/admin/adminUserDelete?no=${user.userNo}";
    }
}
</script>
</html>