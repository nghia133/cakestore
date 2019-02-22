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
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br>
	<br>

	<div class="generic-container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Bill </span>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th>date</th>
						<th>Pay</th>
						<th>Phone</th>
						<th>Address</th>
						<sec:authorize access="hasRole('ADMIN')">
							<th width="100"></th>
						</sec:authorize>
					</tr>


				</thead>
				<tbody>
					<c:forEach items="${receipt}" var="receipt">
						<tr>
							<td>${receipt.receiptName}</td>
							<td>${receipt.receiptDate}</td>
							<td>${receipt.receiptPay}</td>
							<td>${receipt.receiptphone}</td>
							<td>${receipt.receiptAddress}</td>
							<sec:authorize access="hasRole('ADMIN')">
								<td><a
									href="<c:url value='/bill/view?id=${receipt.receiptId}' />"
									class="btn btn-success custom-width">View</a></td>
							</sec:authorize>
							<sec:authorize access="hasRole('ADMIN')">
								<td><a
									href="<c:url value='/bill/delete?id=${receipt.receiptId}'/>"
									class="btn btn-danger custom-width">delete</a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>