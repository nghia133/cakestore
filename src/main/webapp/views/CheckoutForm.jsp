<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/index/css/bootstrap.min.css" />">
<script type="text/javascript"
	src="<c:url value="/resources/index/js/jquery-2.1.0.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/index/js/bootstrap.min.js" />"></script>
<%-- <link href="<c:url value='/resources/bootstrap.css' />" rel="stylesheet"></link> --%>
<link rel="stylesheet"
	href="<c:url value ='/resources/index/css/bill.css'/>">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<br />
	<br />
	<div id="page" class="page">
		<div class="header">
			<div class="company">Cakestore</div>
		</div>

		<!-- Default panel contents -->
		<br />
		<div class="title">
			HÓA ĐƠN THANH TOÁN <br /> -------oOo-------
		</div>
		<div class="footer-left">
			<div>customer: ${receipt.receiptName}</div>
			<div>phone: ${receipt.receiptphone}</div>
			<div>address: ${receipt.receiptAddress}</div>
		</div>
		<table class="TableData">
			<tr>
				<th>product</th>
				<th>price</th>
				<th>quantity</th>
				<th>total</th>
			</tr>

			<c:forEach var="map" items="${sessionScope.myCartItems}">
				<tr>
					<td><c:out value="${map.value.product.name}" /></td>
					<td><c:out value="${map.value.product.price}" /></td>
					<td><c:out value="${map.value.quantity}" /></td>
					<td><c:out
							value="${map.value.quantity * map.value.product.price}" /></td>

				</tr>

			</c:forEach>
		</table>
		<div class="footer-right">
			<div>Free Shipping</div>

			<div>
				Total:
				<c:out value="${sessionScope.myCartTotal}" />
			</div>

			<div>
				VAT (10%):
				<c:out value="${sessionScope.myCartTotal * 0.1}" />
			</div>

			<div>
				Pay:
				<c:out
					value="${sessionScope.myCartTotal + (sessionScope.myCartTotal * 0.1)}" />
			</div>

		</div>

		<br> <br> <br> <br> <br> <a
			href="<c:url value ='/cart/accept'/>">accept</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
			href="javascript: history.go(-1)">Cancel</a>



	</div>










	<br />
	<br />

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>