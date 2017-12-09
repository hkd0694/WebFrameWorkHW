<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr><td>년도</td><td>학기</td><td>과목코드</td><td>교과목</td><td>전교</td><td>학점</td></tr>
	<c:forEach var="cyear" items="${cyear}">
	<tr>
		<td>
			<c:out value="${cyear.c_year}"> </c:out>
		</td>
		<td>
			<c:out value="${cyear.c_term}"> </c:out>
		</td>
		<td>
			<c:out value="${cyear.c_code}"> </c:out>
		</td>
		<td>
			<c:out value="${cyear.c_subject}"> </c:out>
		</td>
		<td>
			<c:out value="${cyear.c_division}"> </c:out>
		</td>
		<td>
			<c:out value="${cyear.c_credit}"> </c:out>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>