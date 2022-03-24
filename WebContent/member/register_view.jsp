<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input {width: 300px; padding: 10px 20px; margin: 5px 0;}
</style>
</head>
<body>
	<jsp:include page="../defualt/header.jsp"/>
	<div class="wrap">
	<div style="width: 500px; margin: 0 auto;">
	<h1>회원가입 페이지 입니다.</h1>
	<form action="${contextPath }/member/register.jsp" method="post">
		<input type="text" name="id" placeholder="input_id"> <br>
		<input type="password" name="pwd" placeholder="input_password"> <br>
		<input type="text" name="name" placeholder="input_name"> <br>
		<input type="text" name="addr" placeholder="input_address"> <br>
		<button type="submit">register</button>
	</form>
	</div>
	</div>
	<jsp:include page="../defualt/footer.jsp"/>
</body>
</html>