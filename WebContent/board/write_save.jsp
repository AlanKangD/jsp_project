<%@page import="com.care.root.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	request.setCharacterEncoding("utf-8");
	BoardDAO dao = new BoardDAO();
	dao.writeSave(request.getParameter("name"),
				request.getParameter("title"),
				request.getParameter("content"));
	response.sendRedirect("list.jsp");
--%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:requestEncoding value="utf-8"/>
<jsp:useBean id="dao" class="com.care.root.board.dao.BoardDAO"/>
${dao.(param.name, param.title, param.content) }
<c:redirect url="list.jsp"/>

</body>
</html>