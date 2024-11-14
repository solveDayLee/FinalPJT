<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Board</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        /* 전체 레이아웃 스타일 */
        .user-board,
        .user-board * {
            box-sizing: border-box;
        }

        .user-board {
            background: #ffffff;
            min-height: 100vh;
            position: relative;
            padding-left: 93px;
            padding-top: 95px; /* 헤더와의 간격을 위해 약간 증가 */
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        /* 테이블 컨테이너 스타일 */
        .rectangle-34 {
            background: #fdfdfd;
            border-radius: 19px;
            width: 90%;
            max-width: 1200px;
            height: 513px;
            margin: 0 auto;
            padding: 0;
            overflow: hidden;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        .user-table-container {
            width: 100%;
            height: 100%;
            padding: 1rem;
            overflow-y: auto;
        }

        /* 테이블 스타일 */
        .user-table {
            width: 100%;
            margin: 0 auto;
            border-collapse: collapse;
            background: white;
        }

        .user-table th {
            background: #f8f9fa;
            padding: 1rem 1.5rem;
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
            padding: 1rem 1.5rem;
            text-align: center;
            border-bottom: 1px solid #dee2e6;
            font-family: sans-serif;
            font-size: 14px;
        }

        /* 행 호버 효과 */
        .user-table tbody tr {
            cursor: pointer;
            transition: background-color 0.2s;
        }

        .user-table tbody tr:hover {
            background-color: #f8f9fa;
        }
        
        /* 반응형 디자인을 위한 미디어 쿼리 */
        @media (max-width: 1200px) {
            .rectangle-34 {
                width: 95%;
            }
        }

        @media (max-width: 768px) {
            .user-board {
                padding-left: 73px; /* 모바일에서는 사이드바 너비 줄임 */
            }
            
            .user-table th,
            .user-table td {
                padding: 0.75rem 1rem;
                font-size: 14px;
            }
        }
    </style>
</head>

<body>
    <!-- 사이드바 include -->
    <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>
    
    <!-- 헤더 include -->
    <%@ include file="/WEB-INF/views/common/userHeader.jsp" %>
    
    <div class="user-board">
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
                            <th>관리</th>
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
                                <td><i class="bi bi-three-dots"></i></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            // 테이블 행 호버 효과
            const tableRows = document.querySelectorAll('.user-table tbody tr');
            tableRows.forEach(row => {
                row.addEventListener('mouseenter', () => {
                    row.style.backgroundColor = '#f8f9fa';
                });
                row.addEventListener('mouseleave', () => {
                    row.style.backgroundColor = '';
                });
            });
        });
    </script>
</body>
</html>