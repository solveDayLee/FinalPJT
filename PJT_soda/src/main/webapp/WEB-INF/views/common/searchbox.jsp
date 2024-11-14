<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<div>
 		<select id="searchCategory" onchange="changePlaceholder()">
 			<option value="name">이름 검색</option>
 			<option value="user_id">아이디 검색</option>
 			<option value="email">이메일 검색</option>
 		</select>
 		<input type="text" placeholder="사용자 아이디로 검색하기" id="searchInput">
 		<button type="button" id="searchButton">검색</button>
 		
 		
 	</div>
 	<script src="/resurces/js/searchbox.js"></script>
<script>
	const select = document.getElementById('searchCategory');
	const input = document.getElementById('searchInput');
	/* const button = document.getElementById('searchButton'); */

	function changePlaceholder() {
		swith(select.value) {
			case 'name':
				input.placeholder="사용자 이름으로 검색";
				//
				break;
			case 'user_id':
				input.placeholder="사용자 아이디로 검색";
				break;
			case 'email':
				input.placeholder="사용자 이메일로 검색";
				break;
		}
	}
	
	document.getElementById('searchButton').addEventListener('click', () => {
		const keyword = input.value.trim();
		if(keyword) {
			const URL = `\${pageContext.request.contextPath}admin/searchAdminBoard?keyword=${keyword}&searchType=${select.value}`;
			location.href = URL;
		}
		
		
	})
	
	
	
	


</script>
 	
 	
</body>
</html>