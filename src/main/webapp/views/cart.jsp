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
	href="<c:url value ='/resources/index/css/product.css'/>">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<br />
	<br />
	<div class="container">
		<div class="row">
			<div class="col-md-9 a" data-aos="fade-right"
				data-aos-duration="2000">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<span class="lead">YOUR CART</span>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th width="100"></th>
							<th>Sản phẩm</th>
							<th>Số lượng</th>
							<th>Đơn giá</th>
							<th>Số tiền</th>
							<th>Thao tác</th>

						</tr>
					</thead>
					<c:forEach var="map" items="${sessionScope.myCartItems}">
						<tr>
							<td width="200"><img class="card-img-top-1"
								src="<c:url value = '/imageDisplay?id=${map.value.product.id}'/>"
								class="img-responsive" alt=""></td>
							<td><c:out value="${map.value.product.name}" /></td>
							<td><c:out value="${map.value.quantity}" /></td>
							<td><c:out value="${map.value.product.price}" /></td>
							<td><c:out
									value="${map.value.quantity * map.value.product.price}" /></td>
							<td><a
								href="<c:url value ='/cart/remove/${map.value.product.id}.html'/>">Remove
									item</a></td>
					</c:forEach>
				</table>
			</div>


			<div class="col-md-3" data-aos="fade-left" data-aos-duration="2000">
				<div id="menu">
					<h4>PAYMENT</h4>
					<ul>Free Shipping
					</ul>
					<ul>
						Total:
						<c:out value="${sessionScope.myCartTotal}" />
					</ul>

					<ul>
						VAT (10%):
						<c:out value="${sessionScope.myCartTotal * 0.1}" />
					</ul>

					<ul>
						Pay:
						<c:out
							value="${sessionScope.myCartTotal + (sessionScope.myCartTotal * 0.1)}" />
					</ul>
					<div class="col-md-6 contact-top">

						<form:form method="POST" action="cart/checkout"
							modelAttribute="receipt">
							<div>
								<form:input type="hidden" path="receiptName"
									value="${user.name}" />
							</div>

							<div>
								<form:input type="hidden" path="receiptPay"
									value="${sessionScope.myCartTotal}" />
							</div>
							<div>
								<span>Your phone</span>
								<form:input type="text" path="receiptphone"
									value="${user.phone}" />


							</div>
							<div>
								<span>Your Address</span>
								<form:input type="text" path="receiptAddress"
									value="${user.address}" />


							</div>
							<c:if
								test="${sessionScope.myCartTotal + (sessionScope.myCartTotal * 0.1) != 0}">
								<button class="btn btn-primary" type="submit">CHECKOUT</button>
							</c:if>
						</form:form>
					</div>


				</div>
			</div>
		</div>
	</div>





	<br />
	<br />

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>