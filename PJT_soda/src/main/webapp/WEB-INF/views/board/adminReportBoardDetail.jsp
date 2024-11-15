<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"
	rel="stylesheet">

</head>
<body>
	<%@ include file="/WEB-INF/views/common/sidebar.jsp"%>
	<%@ include file="/WEB-INF/views/common/boardHeader.jsp"%>

	<div class="main-content">
		<div class="content-area">
			<table>
				<tr>
					<th>게시글 번호</th>
					<td>${reportedBoard.boardNo}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${userId}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${reportedBoard.title}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td class="content-cell">${reportedBoard.content}</td>
				</tr>
				<tr>
					<th>작성일자</th>
					<td>${reportedBoard.regDate}</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${reportedBoard.viewCnt}</td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td>${reportedBoard.category}</td>
				</tr>
				<tr>
					<th>좋아요 수</th>
					<td>${likesCount}</td>
				</tr>
			</table>

			<div class="btn-area">
				<button type="button" class="btn btn-report">신고 처리하기</button>
				<button type="button" class="btn btn-delete">삭제하기</button>
			</div>
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
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.03);
	padding: 2rem;
	position: relative;
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
	background: #f8f9fa;
	width: 200px;
	font-weight: normal;
	color: #495057;
}

td {
	color: #2c3e50;
}

.content-cell {
	min-height: 150px;
	white-space: pre-wrap;
	line-height: 1.6;
}

.btn-area {
	display: flex;
	justify-content: flex-end;
	gap: 1rem;
	padding-top: 1rem;
	margin-top: 2rem;
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

.btn-report {
	background: #1678f3;
	color: white;
}

.btn-report:hover {
	background: #ff7474;
	transform: translateY(-1px);
	box-shadow: 0 2px 4px rgba(76, 175, 80, 0.2);
}

.btn-delete {
	background: #ff7474;
	color: white;
}

.btn-delete:hover {
	background: #ff5c5c;
	transform: translateY(-1px);
	box-shadow: 0 2px 4px rgba(255, 116, 116, 0.2);
}
</style>

<script>
	document.querySelector('.btn-report').onclick = function() {
		if (confirm('이 게시글을 신고 처리하시겠습니까?')) {
			alert('신고 처리되었습니다.');
			window.location.href = "${pageContext.request.contextPath}/board/processReport?no=${reportedBoard.boardNo}";
		}
	}
	document.querySelector('.btn-delete').onclick = function() {
		if (confirm('정말 삭제하시겠습니까?')) {
			alert('게시글이 삭제되었습니다.');
			window.location.href = "${pageContext.request.contextPath}/board/adminBoardDelete?no=${board.boardNo}";
		}
	}
</script>
</html>