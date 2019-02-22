<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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


</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<br />
	<br />
	<button class="btn btn-info" onclick="location.href='getReceiptItem'">History</button>
	<div class="container">
		<div class="content">
			<div class="shopping_cart">
				<c:forEach var="map" items="${sessionScope.myCartItems}">
					<div class="cart_box">
						<div class="message">
							<div class="list_close">
								<a href="remove/${map.value.product.id}.html">Remove item</a>
							</div>
							<div class="list_desc">
								<h4>
									<a href="#"><c:out value="${map.value.product.name}" /></a>
								</h4>
								<c:out value="${map.value.quantity}" />
								x
								<c:out value="${map.value.product.price}" />
								= <span class="actual"> <c:out
										value="${map.value.quantity * map.value.product.price}" /></span>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="total">
				<div class="total_right">Free Shipping</div>
				<div class="clearfix"></div>
				<div class="total_right">
					Total:
					<c:out value="${sessionScope.myCartTotal}" />
				</div>
				<div class="clearfix"></div>
				<div class="total_right">
					VAT (10%):
					<c:out value="${sessionScope.myCartTotal * 0.1}" />
				</div>
				<div class="clearfix"></div>
				<div class="total_right">
					Pay:
					<c:out
						value="${sessionScope.myCartTotal + (sessionScope.myCartTotal * 0.1)}" />
				</div>
				<div class="clearfix"></div>
			</div>


			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="contact">
		<h2 class=" contact-in">CHECKOUT</h2>


		<div class="col-md-6 contact-top">
			<form:form method="POST" action="checkout" modelAttribute="receipt">
				<div>
					<span>Your Name</span>
					<form:input path="receiptName" />


				</div>
				<div>
					<span>Your Email</span>
					<form:input path="receiptMail" />


				</div>
				<div>
					<span>Your Address</span>
					<form:input path="receiptAddress" />


				</div>
				<input type="submit" value="SEND">
			</form:form>
		</div>
		<div class="clearfix"></div>

	</div>

	<br />
	<br />

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>