<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Confirmation Page</title>
<link href="<c:url value='/resources/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="generic-container">


		<div class="alert alert-success lead">${success}</div>

		<span class="well floatRight"> Go to <a
			href="<c:url value='/' />">home</a>
		</span>
		<sec:authorize access="hasRole('ADMIN')">
			<span class="well floatRight"> Go to <a
				href="<c:url value='/list' />">Users List</a>
			</span>
		</sec:authorize>
	</div>
</body>

</html>