<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
<link href="<c:url value='/resources/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/app.css' />" rel="stylesheet"></link>
<script src="<c:url value = '/resources/index/js/product.js'/>"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<br>


	<div class="generic-container">
		<p>${name}</p>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Products </span>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>id</th>
						<th>Name</th>
						<th>Price</th>
						<th width="100">Image</th>
						<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							<th width="100"></th>
						</sec:authorize>
						<sec:authorize access="hasRole('ADMIN')">
							<th width="100"></th>
						</sec:authorize>
					</tr>


				</thead>
				<tbody>
					<c:forEach items="${products}" var="product">
						<tr>
							<td>${product.id}</td>

							<td>${product.name}</td>
							<td>${product.price}</td>
							<td width="200"><img class="card-img-top"
								src="./imageDisplay?id=${product.id}"></td>
							<sec:authorize access="hasRole('ADMIN')">
								<td><a
									href="<c:url value='editproduct?id=${product.id}' />"
									class="btn btn-success custom-width">edit</a></td>
							</sec:authorize>
							<sec:authorize access="hasRole('ADMIN')">
								<td><a
									href="<c:url value='deleteproduct?id=${product.id}' />"
									class="btn btn-danger custom-width">delete</a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
	<div class="generic-container-form" data-aos="fade-left"
		data-aos-duration="2000">
		<div id="menu">
			<h4>Menu product</h4>
			<c:forEach var="item" items="${categories}">
				<ul>
					<li><a onclick="listcategory(${item.id});">${item.name}</a></li>
				</ul>
			</c:forEach>
			<sec:authorize access="hasRole('ADMIN')">
				<button onclick="location.href='addproduct'" class="btn btn-primary">ADD
					PRODUCT</button>
				<button onclick="location.href='addcategory'"
					class="btn btn-primary">ADD CATEGORY</button>

			</sec:authorize>
		</div>
	</div>

</body>
</html>