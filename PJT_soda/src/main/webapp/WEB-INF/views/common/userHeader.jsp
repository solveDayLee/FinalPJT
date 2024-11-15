<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- userHeader.jsp -->
<div class="admin-header">
	<div class="header-left">
		<h1 class="page-title">
			<i class="bi bi-people-fill"></i> User <span class="subtitle">관리자
				페이지</span>
		</h1>
	</div>

	<div class="header-center">
		<div class="search-area">
			<select id="searchCategory" onchange="changePlaceholder()">

				<option value="all">전체 검색</option>
				<option value="name">이름 검색</option>
				<option value="user_id">아이디 검색</option>
				<option value="email">이메일 검색</option>
			</select> <input type="text" id="searchInput" placeholder="사용자 전체 리스트 검색하기">
			<button type="button" id="searchButton" class="search-btn">
				<i class="bi bi-search"></i> 검색
			</button>
		</div>
	</div>

	<div class="header-right">
		<div class="current-time" id="currentTime">
			<i class="bi bi-clock"></i> <span></span>
		</div>
		<button class="report-btn">
			<i class="bi bi-exclamation-triangle-fill"></i> 신고된 유저
		</button>
	</div>
</div>

<style>
.admin-header {
	background: #ffffff;
	height: 75px;
	padding: 0 2rem;
	display: flex;
	align-items: center;
	justify-content: space-between;
	border-bottom: 1px solid #e9ecef;
	position: fixed;
	top: 0;
	right: 0;
	left: 93px;
	z-index: 100;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.03);
}

.header-left {
	min-width: 250px;
	display: flex;
	align-items: center;
}

.page-title {
	color: #2c3e50;
	font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
	font-size: 28px;
	font-weight: 600;
	margin: 0;
	padding: 8px 15px;
	display: flex;
	align-items: center;
	gap: 12px;
	background: linear-gradient(to right, #f8f9fa 0%, transparent 100%);
	border-radius: 12px;
}

.page-title i {
	color: #1678f3;
	font-size: 26px;
	filter: drop-shadow(0 2px 4px rgba(22, 120, 243, 0.2));
}

.page-title .subtitle {
	font-size: 14px;
	font-weight: 400;
	color: #6c757d;
	margin-left: 8px;
	padding-left: 8px;
	border-left: 2px solid #dee2e6;
}

.header-center {
	flex-grow: 1;
	display: flex;
	justify-content: center;
	padding: 0 2rem;
}

.search-area {
	display: flex;
	align-items: center;
	gap: 10px;
	max-width: 600px;
	width: 100%;
	background: #f8f9fa;
	padding: 6px;
	border-radius: 12px;
}

.search-area select {
	height: 37px;
	width: 120px;
	border-radius: 9px;
	border: 1px solid #e0e0e0;
	background: white;
	padding: 0 10px;
	font-size: 14px;
	cursor: pointer;
	transition: border-color 0.2s;
}

.search-area select:hover {
	border-color: #1678f3;
}

.search-area input {
	flex-grow: 1;
	height: 37px;
	border-radius: 9px;
	border: 1px solid #e0e0e0;
	background: white;
	padding: 0 15px;
	font-size: 14px;
	transition: border-color 0.2s;
}

.search-area input:focus {
	outline: none;
	border-color: #1678f3;
}

.search-btn {
	height: 37px;
	padding: 0 20px;
	border-radius: 9px;
	border: none;
	background: #1678f3;
	color: white;
	font-size: 14px;
	cursor: pointer;
	transition: all 0.2s;
	display: flex;
	align-items: center;
	gap: 5px;
}

.search-btn:hover {
	background: #1261c4;
	transform: translateY(-1px);
	box-shadow: 0 2px 4px rgba(22, 120, 243, 0.2);
}

.header-right {
	display: flex;
	align-items: center;
	gap: 1.5rem;
}

.current-time {
	color: #666;
	font-size: 14px;
	display: flex;
	align-items: center;
	gap: 5px;
	padding: 8px 12px;
	background: #f8f9fa;
	border-radius: 8px;
}

.report-btn {
	height: 40px;
	padding: 0 20px;
	border-radius: 10px;
	border: none;
	background: #ff74a6;
	color: white;
	font-size: 14px;
	font-weight: 500;
	cursor: pointer;
	transition: all 0.2s;
	display: flex;
	align-items: center;
	gap: 5px;
}

.report-btn:hover {
	background: #ff5c94;
	transform: translateY(-1px);
	box-shadow: 0 2px 4px rgba(255, 116, 166, 0.2);
}
</style>

<script>
	const contextPath = '${pageContext.request.contextPath}';

	function updateTime() {
		const now = new Date();
		const formattedDate = now.getFullYear() + '-'
				+ String(now.getMonth() + 1).padStart(2, '0') + '-'
				+ String(now.getDate()).padStart(2, '0') + ' '
				+ String(now.getHours()).padStart(2, '0') + ':'
				+ String(now.getMinutes()).padStart(2, '0');

		document.querySelector('#currentTime span').textContent = formattedDate
				+ ' 기준';
	}

	function changePlaceholder() {
		const select = document.getElementById('searchCategory');
		const input = document.getElementById('searchInput');

		switch (select.value) {
		case 'all':
			input.placeholder = "사용자 전체 리스트 검색하기";
			break;

		case 'name':
			input.placeholder = "사용자 이름으로 검색하기";
			break;
		case 'user_id':
			input.placeholder = "사용자 id로 검색하기";
			break;
		case 'email':
			input.placeholder = "사용자 이메일로 검색하기";
			break;
		}
	}

	//실시간
	document
			.addEventListener(
					'DOMContentLoaded',
					function() {
						updateTime();
						setInterval(updateTime, 60000);

						document
								.getElementById('searchButton')
								.addEventListener(
										'click',
										function() {
											const input = document
													.getElementById('searchInput');
											const select = document
													.getElementById('searchCategory');
											const keyword = input.value.trim();
											const category = select.value;

											if (category === 'all') {
												console
														.log(
																"전체 검색 경로:",
																contextPath
																		+ '/admin/adminUserBoard');
												location.href = contextPath
														+ '/admin/adminUserBoard';

											} else if (keyword) {

												const URL = contextPath
														+ `/admin/searchAdminUserBoard?category=\${select.value}&keyword=\${keyword}`;
												location.href = URL;

											} else {
												alert('검색어를 입력해주세요.');
											}
										});

						document
								.getElementById('searchInput')
								.addEventListener(
										'keypress',
										function(e) {
											if (e.key === 'Enter') {
												document.getElementById(
														'searchButton').click();
											}
										});
					});
</script>


<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- userHeader.jsp -->
<div class="admin-header">
    <div class="header-left">
        <h1 class="page-title">
            <i class="bi bi-people-fill"></i>
            User
            <span class="subtitle">관리자 페이지</span>
        </h1>
    </div>
    
    <div class="header-center">
        <div class="search-area">
            <select id="searchCategory" onchange="changePlaceholder()">
                <option value="name">이름 검색</option>
                <option value="user_id">아이디 검색</option>
                <option value="email">이메일 검색</option>
            </select>
            <input type="text" id="searchInput" placeholder="사용자 아이디로 검색하기">
            <button type="button" id="searchButton" class="search-btn">
                <i class="bi bi-search"></i> 검색
            </button>
        </div>
    </div>
    
    <div class="header-right">
        <div class="current-time" id="currentTime">
            <i class="bi bi-clock"></i>
            <span></span>
        </div>
        <button class="report-btn">
            <i class="bi bi-exclamation-triangle-fill"></i>
            신고된 유저
        </button>
    </div>
</div>

<style>
.admin-header {
    background: #ffffff;
    height: 75px;
    padding: 0 2rem;
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-bottom: 1px solid #e9ecef;
    position: fixed;
    top: 0;
    right: 0;
    left: 93px;
    z-index: 100;
    box-shadow: 0 2px 4px rgba(0,0,0,0.03);
}

.header-left {
    min-width: 250px;
    display: flex;
    align-items: center;
}

.page-title {
    color: #2c3e50;
    font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    font-size: 28px;
    font-weight: 600;
    margin: 0;
    padding: 8px 15px;
    display: flex;
    align-items: center;
    gap: 12px;
    background: linear-gradient(to right, #f8f9fa 0%, transparent 100%);
    border-radius: 12px;
}

.page-title i {
    color: #1678f3;
    font-size: 26px;
    filter: drop-shadow(0 2px 4px rgba(22,120,243,0.2));
}

.page-title .subtitle {
    font-size: 14px;
    font-weight: 400;
    color: #6c757d;
    margin-left: 8px;
    padding-left: 8px;
    border-left: 2px solid #dee2e6;
}

.header-center {
    flex-grow: 1;
    display: flex;
    justify-content: center;
    padding: 0 2rem;
}

.search-area {
    display: flex;
    align-items: center;
    gap: 10px;
    max-width: 600px;
    width: 100%;
    background: #f8f9fa;
    padding: 6px;
    border-radius: 12px;
}

.search-area select {
    height: 37px;
    width: 120px;
    border-radius: 9px;
    border: 1px solid #e0e0e0;
    background: white;
    padding: 0 10px;
    font-size: 14px;
    cursor: pointer;
    transition: border-color 0.2s;
}

.search-area select:hover {
    border-color: #1678f3;
}

.search-area input {
    flex-grow: 1;
    height: 37px;
    border-radius: 9px;
    border: 1px solid #e0e0e0;
    background: white;
    padding: 0 15px;
    font-size: 14px;
    transition: border-color 0.2s;
}

.search-area input:focus {
    outline: none;
    border-color: #1678f3;
}

.search-btn {
    height: 37px;
    padding: 0 20px;
    border-radius: 9px;
    border: none;
    background: #1678f3;
    color: white;
    font-size: 14px;
    cursor: pointer;
    transition: all 0.2s;
    display: flex;
    align-items: center;
    gap: 5px;
}

.search-btn:hover {
    background: #1261c4;
    transform: translateY(-1px);
    box-shadow: 0 2px 4px rgba(22,120,243,0.2);
}

.header-right {
    display: flex;
    align-items: center;
    gap: 1.5rem;
}

.current-time {
    color: #666;
    font-size: 14px;
    display: flex;
    align-items: center;
    gap: 5px;
    padding: 8px 12px;
    background: #f8f9fa;
    border-radius: 8px;
}

.report-btn {
    height: 40px;
    padding: 0 20px;
    border-radius: 10px;
    border: none;
    background: #ff74a6;
    color: white;
    font-size: 14px;
    font-weight: 500;
    cursor: pointer;
    transition: all 0.2s;
    display: flex;
    align-items: center;
    gap: 5px;
}

.report-btn:hover {
    background: #ff5c94;
    transform: translateY(-1px);
    box-shadow: 0 2px 4px rgba(255,116,166,0.2);
}
</style>

<script>
const contextPath = '${pageContext.request.contextPath}';

function updateTime() {
    const now = new Date();
    const formattedDate = now.getFullYear() + '-' + 
        String(now.getMonth() + 1).padStart(2, '0') + '-' + 
        String(now.getDate()).padStart(2, '0') + ' ' + 
        String(now.getHours()).padStart(2, '0') + ':' + 
        String(now.getMinutes()).padStart(2, '0');
    
    document.querySelector('#currentTime span').textContent = formattedDate + ' 기준';
}

function changePlaceholder() {
    const select = document.getElementById('searchCategory');
    const input = document.getElementById('searchInput');
    
    switch(select.value) {
        case 'name':
            input.placeholder = "사용자 이름으로 검색하기";
            break;
        case 'user_id':
            input.placeholder = "사용자 id로 검색하기";
            break;
        case 'email':
            input.placeholder = "사용자 이메일로 검색하기";
            break;
    }
}

document.addEventListener('DOMContentLoaded', function() {
    updateTime();
    setInterval(updateTime, 60000);
    
    document.getElementById('searchButton').addEventListener('click', function() {
        const input = document.getElementById('searchInput');
        const select = document.getElementById('searchCategory');
        const keyword = input.value.trim();
        
        if(keyword) {
            const URL = contextPath + `/admin/searchAdminUserBoard?category=\${select.value}&keyword=\${keyword}`;
            location.href = URL;
        } else {
            alert('검색어를 입력해주세요.');
        }
    });

    document.getElementById('searchInput').addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            document.getElementById('searchButton').click();
        }
    });
});
</script> --%>