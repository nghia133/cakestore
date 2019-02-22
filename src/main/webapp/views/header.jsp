<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href=" <c:url value='/resources/index/css/bootstrap.min.css'/>"></link>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="<c:url value='/resources/index/css/header.css'/>"></link>


<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">

<script src="<c:url value='/resources/index/js/jquery-2.1.0.min.js'/>"></script>
<script src="<c:url value='/resources/index/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/index/js/header.js'/>"></script>


<title>Web bakery store</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg   fixed-top" id="header-top">
		<a class="navbar-brand" href="#">MP de Bakery</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="icon-bar"> </span>
		</button>



		<div>
			<a href="?lang=en_US">English</a> <a href="?lang=vi_VN">Viet Nam</a>
		</div>

		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="<c:url value='/' />"><i class="fas fa-home">&nbsp;<spring:message
								code="head.home" /></i> <span class="sr-only">(current)</span> </a></li>

				<sec:authorize access="hasRole('ADMIN')">
					<li class="nav-item "><a class="nav-link"
						href="<c:url value='/list' />"><i class="fas fa-user"></i>&nbsp;<spring:message
								code="head.userlist" /></a></li>

					<li class="nav-item "><a class="nav-link"
						href="<c:url value='/bill' />"><i class="fas fa-user"></i>&nbsp;<spring:message
								code="head.bill" /></a></li>
				</sec:authorize>

				<sec:authorize access="hasRole('ADMIN')">
					<li class="nav-item "><a class="nav-link"
						href="<c:url value='/productlist' />"><i class="fas fa-cookie"></i>&nbsp;<spring:message
								code="head.productlist" /></a></li>
				</sec:authorize>

				<li class="nav-item "><a class="nav-link"
					href="<c:url value='/products' />"><i class="fas fa-cookie"></i>&nbsp;<spring:message
							code="head.store" /></a></li>

				<li class="nav-item "><a class="nav-link"
					href="<c:url value='/cart'/>"> <span> <c:out
								value="${sessionScope.myCartNum}" /></span> <i
						class="fas fa-shopping-cart"></i> &nbsp;<spring:message
							code="head.cart" /></a></li>
				<c:choose>
					<c:when test="${loggedinuser == 'anonymousUser'}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"><i class="fas fa-user"></i>&nbsp;<spring:message
									code="head.customer" /> </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="<c:url value="/register" />"><i
									class="fas fa-user-plus"></i> &nbsp;<spring:message
										code="head.signup" /></a> <a class="dropdown-item"
									href="<c:url value="/login" />"><i
									class="fas fa-sign-in-alt"></i>&nbsp;<spring:message
										code="head.signin" /></a>
							</div></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"><i class="fas fa-user"></i>&nbsp;${loggedinuser}
						</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="edit"><i class="fas fa-edit"></i>
									&nbsp;edit</a> <a class="dropdown-item"
									href="<c:url value="/logout" />"><i
									class="fas fa-sign-out-alt"></i>&nbsp;logout</a>
							</div></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<form action="search">
				<input type="search" name="keyword" placeholder="Search" />

			</form>

		</div>
	</nav>
</body>
</html>