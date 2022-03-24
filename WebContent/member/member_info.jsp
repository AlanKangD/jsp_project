<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="com.care.root.member.dao.MemberDAO"/>
<c:set var="mem" value="${dao.memberInfo(param.id) }"/>
<jsp:include page="../defualt/header.jsp"/>


	<div class="wrap">
		<h1>개인정보 보여 줍니다.</h1>
		${param.id }, <%=request.getParameter("id") %>
		<hr>
		id : ${mem.id } <br>
		pwd : ${mem.pwd } <br>
		name : ${mem.name } <br>
		addr : ${mem.addr } <br>
		<hr>
		<button type="button" onclick="location='modify.jsp?id=${mem.id}'">수정</button>
		<button type="session_id" value="${mem.id }" scope="session">
		삭제
		</button>
		
		
		
	</div>
	
	
	
<jsp:include page="../defualt/footer.jsp"/>
</body>
</html>