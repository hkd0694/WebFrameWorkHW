<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<p>
		<a href="${pageContext.request.contextPath}/colleges">Show current
			College</a>
	</p>
	<%--   ${pageContext.request.contextPath}<-현재 context 의 root  --%>

	<p>
		<a href="${pageContext.request.contextPath}/createcollege">Add a new
			offer</a>
	</p>
</body>
</html>
