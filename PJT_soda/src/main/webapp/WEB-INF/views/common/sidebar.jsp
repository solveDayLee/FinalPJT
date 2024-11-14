<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- sidebar.jsp -->
<div class="sidebar">
    <div class="logo-section">
        <h3 class="text-center py-4">Admin</h3>
    </div>
    
    <ul class="nav flex-column menu-section">
        <li class="nav-item">
            <a class="nav-link ${pageContext.request.servletPath == '/admin/home.jsp' ? 'active' : ''}" 
               href="${pageContext.request.contextPath}/admin/main">
                <i class="bi bi-house-door-fill"></i>
                <span>홈</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${pageContext.request.servletPath == '/admin/users.jsp' ? 'active' : ''}" 
               href="${pageContext.request.contextPath}/admin/adminUserBoard">
                <i class="bi bi-people-fill"></i>
                <span>사용자</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${pageContext.request.servletPath == '/admin/board.jsp' ? 'active' : ''}" 
               href="${pageContext.request.contextPath}/board/adminBoard">
                <i class="bi bi-clipboard2-data-fill"></i>
                <span>게시판</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${pageContext.request.servletPath == '/admin/notices.jsp' ? 'active' : ''}" 
               href="${pageContext.request.contextPath}/admin/notices">
                <i class="bi bi-megaphone-fill"></i>
                <span>공지사항</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${pageContext.request.servletPath == '/admin/reports.jsp' ? 'active' : ''}" 
               href="${pageContext.request.contextPath}/admin/reports">
                <i class="bi bi-exclamation-triangle-fill"></i>
                <span>신고관리</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link ${pageContext.request.servletPath == '/admin/statistics.jsp' ? 'active' : ''}" 
               href="${pageContext.request.contextPath}/admin/statistics">
                <i class="bi bi-bar-chart-fill"></i>
                <span>통계</span>
            </a>
        </li>
    </ul>
    
    <!-- 로그아웃 버튼 -->
    <div class="logout-section">
        <a class="nav-link logout-btn" href="${pageContext.request.contextPath}/admin/logout">
            <i class="bi bi-box-arrow-right"></i>
            <span>로그아웃</span>
        </a>
    </div>
</div>

<style>
.sidebar {
    width: 93px;
    height: 100vh;
    background: #f9f9f9;
    position: fixed;
    left: 0;
    top: 0;
    z-index: 100;
    transition: all 0.3s;
    display: flex;
    flex-direction: column;
}

.sidebar:hover {
    width: 200px;
}

.menu-section {
    margin-top: 2rem;  /* 상단 여백 추가 */
    flex-grow: 1;      /* 남은 공간 채우기 */
}

.sidebar .nav-link {
    padding: 1.2rem 1rem;  /* 패딩 증가 */
    color: #333;
    text-align: center;
    transition: all 0.3s;
    margin: 0.3rem 0;     /* 아이템 간 간격 추가 */
}

.sidebar:hover .nav-link {
    text-align: left;
}

.sidebar .nav-link span {
    display: none;
    margin-left: 10px;
    font-size: 0.9rem;    /* 텍스트 크기 조정 */
}

.sidebar:hover .nav-link span {
    display: inline;
}

.sidebar .nav-link.active {
    background: #1678f3;
    color: white;
    border-radius: 10px;
    margin: 0.3rem 0.5rem;
}

.sidebar .nav-link:hover {
    background: #e9ecef;
    border-radius: 10px;
    margin: 0.3rem 0.5rem;
}

.sidebar .nav-link.active:hover {
    background: #1678f3;
}

.bi {
    font-size: 1.5rem;
}

/* 로그아웃 섹션 스타일 */
.logout-section {
    margin-top: auto;    /* 하단으로 밀기 */
    padding: 1rem 0;
    border-top: 1px solid #dee2e6;
}

.logout-btn {
    color: #dc3545 !important;  /* 빨간색으로 강조 */
}

.logout-btn:hover {
    background: rgba(220, 53, 69, 0.1) !important;  /* 빨간색 배경으로 hover 효과 */
}

/* 로고 섹션 스타일 수정 */
.logo-section {
    padding: 1rem 0;
    border-bottom: 1px solid #dee2e6;
}

.logo-section h3 {
    margin: 0;
    font-size: 1.2rem;
    color: #1678f3;
}
</style>