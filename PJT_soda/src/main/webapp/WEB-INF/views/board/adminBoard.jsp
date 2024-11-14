<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Board</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        .board-list,
        .board-list * {
            box-sizing: border-box;
        }

        .board-list {
            background: #ffffff;
            min-height: 100vh;
            position: relative;
            padding-left: 93px;
            padding-top: 95px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

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

        .board-table-container {
            width: 100%;
            height: 100%;
            padding: 1rem;
            overflow-y: auto;
        }

        .board-table {
            width: 100%;
            margin: 0 auto;
            border-collapse: collapse;
            background: white;
        }

        .board-table th {
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

        .board-table td {
            padding: 1rem 1.5rem;
            text-align: center;
            border-bottom: 1px solid #dee2e6;
            font-family: sans-serif;
            font-size: 14px;
        }

        .board-table tbody tr {
            cursor: pointer;
            transition: background-color 0.2s;
        }

        .board-table tbody tr:hover {
            background-color: #f8f9fa;
        }
        
        @media (max-width: 1200px) {
            .rectangle-34 {
                width: 95%;
            }
        }

        @media (max-width: 768px) {
            .board-list {
                padding-left: 73px;
            }
            
            .board-table th,
            .board-table td {
                padding: 0.75rem 1rem;
                font-size: 14px;
            }
        }
    </style>
</head>

<body>
    <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>
    <%@ include file="/WEB-INF/views/common/boardHeader.jsp" %>
    
    <div class="board-list">
        <div class="rectangle-34">
            <div class="board-table-container">
                <table class="board-table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>카테고리</th>
                            <th>작성일</th>
                            <th>조회수</th>
                            <th>좋아요</th>
                        </tr>
                    </thead>
                    <tbody>
                       <c:forEach items="${list}" var="board" varStatus="state">
                            <tr onclick="location.href='${pageContext.request.contextPath}/board/adminBoardDetail?no=${board.boardNo}'">
                                <td>${board.boardNo}</td>
                                <td>${board.title}</td>
                                <td>${board.category}</td>
                                <td>${board.regDate}</td>
                                <td>${board.viewCnt}</td>
                                <td>${likes[state.index]}</td>
                                <!-- <td><i class="bi bi-three-dots"></i></td> -->
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const tableRows = document.querySelectorAll('.board-table tbody tr');
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