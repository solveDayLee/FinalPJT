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
        <div class="content-area">
            <table>
                <tr><th>아이디</th><td>${user.userId}</td></tr>
                <tr><th>비밀번호</th><td>${user.password}</td></tr>
                <tr><th>이름</th><td>${user.name}</td></tr>
                <tr><th>이메일</th><td>${user.email}</td></tr>
                <tr><th>전화번호</th><td>${user.phoneNumber}</td></tr>
                <tr><th>생년월일</th><td>${user.birthDate}</td></tr>
                <tr><th>성별</th><td>${user.gender}</td></tr>
                <tr><th>주소</th><td>${user.address}</td></tr>
                <tr><th>상세주소</th><td>${user.detailAddress}</td></tr>
                <tr><th>우편번호</th><td>${user.zonecode}</td></tr>
                <tr><th>가입일</th><td>${user.userRegDate}</td></tr>
            </table>

            <form action="/admin/adminUserUpdateForm" method="get">
                <input type="hidden" name="no" value="${user.userNo}">
                <div class="btn-area">
                    <button class="btn btn-edit">수정하기</button>
                    <button type="button" class="btn btn-delete">삭제하기</button>
                </div>
            </form>
        </div>
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
}

th, td {
    padding: 1rem;
    border-bottom: 1px solid #e9ecef;
}

th {
    background: #f8f9fa;
    width: 200px;
    font-weight: 500;
    color: #495057;
}

td {
    color: #2c3e50;
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
    border-radius: 8px;
    font-size: 14px;
    font-weight: 500;
    cursor: pointer;
    transition: all 0.2s;
}

.btn-edit {
    background: #1678f3;
    color: white;
}

.btn-edit:hover {
    background: #1261c4;
    transform: translateY(-1px);
    box-shadow: 0 2px 4px rgba(22,120,243,0.2);
}

.btn-delete {
    background: #ff74a6;
    color: white;
}

.btn-delete:hover {
    background: #ff5c94;
    transform: translateY(-1px);
    box-shadow: 0 2px 4px rgba(255,116,166,0.2);
}
</style>

<script>
document.querySelector('.btn-delete').onclick = function() {
    if(confirm('정말 삭제하시겠습니까?')) {
        alert('${user.userId}가 삭제되었습니다.');
        window.location.href = "${pageContext.request.contextPath}/admin/adminUserDelete?no=${user.userNo}";
    }
}
</script>
</html>