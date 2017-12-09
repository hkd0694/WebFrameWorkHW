<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
	<tr>
	<c:forEach var="cdivide" items="${cdivide}">
		<td>
			<c:out value="${cdivide.c_division}"> </c:out>
		</td>
	</c:forEach>
	</tr>
	<tr>
	<c:forEach var="cdivide" items="${cdivide}">
		<td>
			<c:out value="${cdivide.c_credit}"> </c:out>
		</td>
	</c:forEach>
	</tr>
	
</table>

</body>
</html>