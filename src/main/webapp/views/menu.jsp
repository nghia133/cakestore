<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="menu">
		<h4>Menu product</h4>
		<c:forEach var="item" items="${categories}">
			<ul>
				<li><a (click)="onselectDM(Emp)">${item.name}</a></li>
			</ul>
		</c:forEach>
		<sec:authorize access="hasRole('ADMIN')">
			<button onclick="location.href='addproduct'" class="btn btn-primary">ADD
				PRODUCT</button>
		</sec:authorize>
	</div>
</body>
</html>