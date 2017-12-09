<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/incollege2"
		modelAttribute="college">

		<table border="1" cellpadding="10"
			style="border-collapse: collapse; text-align: center;">

			<caption>이수 구분별 학점내역</caption>

			<tbody>

				<tr>

					<td>Year:</td>

					<td>${college.c_year}</td>

				</tr>

				<tr>

					<td>Term:</td>

					<td>${college.c_term}</td>

				</tr>

				<tr>

					<td>Code:</td>

					<td><sf:input type="text" path="c_code" /><br /> <sf:errors
							path="c_code" /></td>

				</tr>

				<tr>

					<td>Subject:</td>

					<td><sf:input type="text" path="c_subject" /><br /> <sf:errors
							path="c_subject" /></td>

				</tr>

				<tr>

					<td>Division:</td>

					<td><sf:input type="text" path="c_division" /><br /> <sf:errors
							path="c_division" /></td>

				</tr>

				<tr>

					<td>Credit:</td>

					<td><sf:input type="text" path="c_credit" /><br /> <sf:errors
							path="c_credit" /></td>

				</tr>

				<tr>

					<td></td>

					<td><input type="submit" value="등록"></td>

				</tr>

			</tbody>

		</table>

	</sf:form>
</body>
</html>