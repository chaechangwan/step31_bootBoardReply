<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	response.setStatus(200);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
메시지 : ${errMsg} / ${exception.message}
</h3>
<a href="javascript:history.back()">뒤로가기</a>
<a href="${pageContext.request.contextPath}/board/list">홈으로</a>

</body>
</html>