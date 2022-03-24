<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function register() {
		location.href = "/member/register_view.jsp";
	}
</script>
<style type="text/css">
	input {width: 300px; padding: 10px 20px; margin: 5px 0;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../defualt/header.jsp"/>

<div class="wrap" align="center">
	<form action="${contextPath }/login/loginChk.jsp">
		<input type="text"> <br>
		<input type="password"> <br>
		<button type="submit">로그인</button>
		<button type="button" onclick="javascript:register()">회원가입</button>
	</form>
</div>

<jsp:include page="../defualt/footer.jsp"/>
</body>
</html>