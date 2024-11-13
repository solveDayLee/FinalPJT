<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
 
</head>
<body>
    <!-- 사이드바 include -->
    <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>

    <div class="main-content">
        <div class="welcome-container">
            <div class="welcome-content">
                <h1 class="title">Welcome To Our AdminPage</h1>
                <p class="subtitle">Click Button Below to Start the administrator Program</p>
                
                <a href="${pageContext.request.contextPath}/admin/adminUserBoard" class="start-button">
                    Get Started
                    <div class="button-gradient"></div>
                </a>
            </div>
        </div>
    </div>
</body>

<style>
.main-content {
    margin-left: 93px;
    min-height: 100vh;
    position: relative;
    background: linear-gradient(
        69.25deg,
        rgba(209, 107, 165, 0.3) 0%,
        rgba(134, 168, 231, 0.3) 51.74%,
        rgba(95, 251, 241, 0.3) 100%
    );
    backdrop-filter: blur(15px);
}

.welcome-container {
    width: 100%;
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: flex-start;
    padding-left: 8%;
}

.welcome-content {
    max-width: 800px;
}

.title {
    color: #ffffff;
    font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    font-size: 70px;
    font-weight: 700;
    line-height: 1.2;
    margin-bottom: 2rem;
    text-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.subtitle {
    color: #ffffff;
    font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    font-size: 35px;
    font-weight: 500;
    margin-bottom: 3rem;
    text-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.start-button {
    display: inline-block;
    background: #1678f3;
    border-radius: 56.5px;
    width: 268px;
    height: 72.8px;
    position: relative;
    text-decoration: none;
    overflow: hidden;
    transition: all 0.3s ease;
}

.start-button::before {
    content: "Get Started";
    position: absolute;
    width: 100%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #ffffff;
    font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    font-size: 28px;
    z-index: 2;
}

.button-gradient {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: linear-gradient(
        265.94deg,
        rgba(249, 132, 244, 1) 0%,
        rgba(22, 120, 243, 0) 100%
    );
    opacity: 0;
    transition: opacity 0.3s ease;
}

.start-button:hover {
    transform: translateY(-2px);
    box-shadow: 0 4px 8px rgba(22, 120, 243, 0.2);
}

.start-button:hover .button-gradient {
    opacity: 1;
}

@media (max-width: 768px) {
    .welcome-container {
        padding: 2rem;
    }
    
    .title {
        font-size: 40px;
    }
    
    .subtitle {
        font-size: 24px;
    }
    
    .start-button {
        width: 200px;
        height: 60px;
    }
    
    .start-button::before {
        font-size: 20px;
    }
}
</style>
</html>