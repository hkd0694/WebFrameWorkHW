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

	<tr><td>년도</td><td>학기</td><td>이수 학점</td><td>상세보기</td></tr>
	<c:forEach var="csum" items="${cSums}">
	<tr>
		<td>
			<c:out value="${csum.c_year}"> </c:out>
		</td>
		<td>
			<c:out value="${csum.c_term}"> </c:out>
		</td>
		<td>
			<c:out value="${csum.c_credit}"> </c:out>
		</td>
		<td><a href="${pageContext.request.contextPath}/clink?c_year=${csum.c_year}&c_term=${csum.c_term}">링크</a></td>
	</tr>
	</c:forEach>
	
</table>

</body>
</html>