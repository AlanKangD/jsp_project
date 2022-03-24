<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:ital,wght@1,700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/0ab647ee38.js" crossorigin="anonymous"></script>
<style>
.body {
    margin: 0;
    font-family: 'Source Sans Pro', sans-serif;
}
a {
    text-decoration: none;
    color: white;
}

.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: #263343;
}

.navbar_logo   {
font-size: 24px;
color: white;
}

.navbar_logo i {
    color: #d49466;
}
.navbar_menu {
    display: flex;
    list-style: none;
    padding-left: 0;
}

.navbar_menu li:hover {
    background-color: #d49466;
    border-radius: 4px;
}
.navbar_menu li {
    padding: 8px 12px;
}

.navbar_icons{
    list-style: none;
    color: white;
    display: flex;
}

.navbar_icons li {
    padding: 8px 12px;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
 </head> 
 
 <body>
<nav class="navbar" >
        <div class="navbar_logo">
            <i class="fa-brands fa-accusoft"></i>
            <a href="${contextPath }/defualt/main.jsp">DreamCoding</a>
        </div>
        <ul class="navbar_menu">
            <li><a href="${contextPath }/defualt/main.jsp">HOME</a></li>
            <li><a href="${contextPath }/member/memberView.jsp">Membership</a></li>
            <li><a href="${contextPath }/login/loginChkForm.jsp">login</a></li>
            <li><a href="${contextPath }/board/list.jsp">BOARD</a></li>
            <li><a href="">FAQ</a></li>
            <li><a href="">Bookings</a></li>
        </ul>
        <ul class="navbar_icons">
            <li><i class="fa-brands fa-twitter"></i></li>
            <li><i class="fa-brands fa-facebook-f"></i></li>
        </ul>
    </nav>
</body> </html>
