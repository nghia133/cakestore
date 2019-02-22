<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<c:url value= '/resources/index/css/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="<c:url value ='/resources/index/css/product.css'/>">
<link rel="stylesheet"
	href="<c:url value = '/resources/index/css/collection.css'/>">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<script src="<c:url value = '/resources/index/js/jquery-2.1.0.min.js'/>"></script>
<script src="<c:url value = '/resources/index/js/bootstrap.min.js'/>"></script>
<script src="<c:url value = '/resources/index/js/product.js'/>"></script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="products">
		<p>
			<i class="fas fa-heart" data-aos="fade-down" data-aos-duration="1800"></i>
			Product <i class="fas fa-heart" data-aos="fade-down"
				data-aos-duration="2500"></i>
		</p>

	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-9 a" data-aos="fade-right"
				data-aos-duration="2000">
				<div class="row">
					<c:forEach items="${products}" var="product">
						<div class="col-md-4  portfolio-item">
							<div class="card h-100" id="card">
								<img onclick="location.href='viewproduct?id=${product.id}'"
									class="card-img-top"
									src="<c:url value = '/imageDisplay?id=${product.id}'/>">
								<div class="caption">
									<div class="blur"></div>
									<div class="caption-text">
										<button class="btn btn-primary"
											onclick="location.href='<c:url value ='/cart/buynow?id=${product.id}'/>'"
											class="text">BUY NOW</button>
										<button class="btn btn-primary"
											onclick="location.href='<c:url value='/cart/add?id=${product.id}'/>'"
											class="text">ADD CARD</button>
										<br>
										<sec:authorize access="hasRole('ADMIN')">
											<button class="btn btn-primary"
												onclick="location.href='<c:url value='/editproduct?id=${product.id}'/>'">
												Edit</button>
											<button class="btn btn-danger"
												onclick="location.href='<c:url value='/deleteproduct?id=${product.id}'/>'">
												Delete</button>

										</sec:authorize>

									</div>
								</div>
								<div class="card-body">
									<h4 class="card-title">
										<a>${product.name}</a>
									</h4>
									<p class="card-text">${product.price}
										<span class="woocommerce-Price-currencySymbol"></span>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>


			<div class="col-md-3" data-aos="fade-left" data-aos-duration="2000">
				<div id="menu">
					<h4>Menu product</h4>
					<c:forEach var="item" items="${categories}">
						<ul>
							<li><a onclick="category(${item.id});">${item.name}</a></li>
						</ul>
					</c:forEach>
					<sec:authorize access="hasRole('ADMIN')">
						<button onclick="location.href='addproduct'"
							class="btn btn-primary">ADD PRODUCT</button>
						<button onclick="location.href='addcategory'"
							class="btn btn-primary">ADD CATEGORY</button>
					</sec:authorize>
				</div>
			</div>
		</div>
		<!-- <nav aria-label="Page navigation example" id="pg">
    <ul class="pagination">
      <li class="page-item" *ngFor="let Em of tranglist"><a (click)=" onselecPG(Em)" class="page-link">{{Em.idpg}}</a></li>
    </ul>
  </nav> -->
		<c:forEach var="i" begin="0" end="${totalItem}">
			<a class="btn btn-default" href="<c:url value='/products-${i+1}'/>"><c:out
					value="${i+1}" /></a>
		</c:forEach>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>