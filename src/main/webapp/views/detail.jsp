<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	href="<c:url value ='/resources/index/css/detail.css'/>">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<script src="./resources/index/js/jquery-2.1.0.min.js"></script>
<script src="./resources/index/js/bootstrap.min.js"></script>
<script src="./resources/index/js/detail.js"></script>



</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<!-- detail -->
	<div class="container">
		<div class="cards">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						<div class="preview-pic tab-content">
							<div class="imgBox">
								<img src="./imageDisplay?id=${product.id}" />
							</div>

						</div>
						<%--  <ul class="preview-thumbnail nav nav-tabs" id="thumb">
                        <li class="change"><a [href]="productslist.img" target="imgBox"><img src="./imageDisplay?id=${product.id}" /></a></li>
                        <li><img src="./imageDisplay?id=${product.id}" /></a></li>
                    </ul> --%>
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${product.name}</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>

						</div>
						<h4 class="price">
							Gia: <span>${product.price}</span>
						</h4>
						<!-- <p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p> -->
						<div class="menu"></div>
						<div class="action">
							<button
								onclick="location.href='<c:url value='/cart/add?id=${product.id}'/>'"
								class="add-to-cart btn btn-default">add to cart</button>
							<button
								onclick="location.href='<c:url value='/cart/buynow?id=${product.id}'/>'"
								class="add-to-cart btn btn-default">buy now</button>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="card card-outline-secondary my-4">
			<h5 class="card-header">GIỚI THIỆU SẢN PHẨM</h5>
			<br>
			<div class="card-header">${product.description}</div>
		</div>
		<%-- <form:form action="./save" method="post" modelAttribute="comment">
               			<form:textarea path="content" rows="5" cols="55" id="content" name="content" placeholder="Enter your comment here"/>
               			<form:input path="product.id" type="hidden" value="${product.id}"/>
               			<form:input path="username" type="hidden" value="${sessionScope.account.username}"/>
               			<div class="form-group">
							<div class="col-sm-offset-4 col-sm-6">
								<c:choose>
									<c:when test="${loggedinuser =='anonymousUser'}">
										<button type="submit" class="btn btn-primary">
											Comment
										</button>
									</c:when>
									<c:otherwise>
										<button type="button" onclick="location.href='../'" class="btn btn-primary">
											Login to Comment
										</button>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
               		</form:form> --%>


		<%-- <div data-aos="zoom-in" data-aos-duration="2500">
            <div class="row">
                <div class="product" class="col-md-12 mr-auto text-center">
                    <h2>Other Product</h2>
                    <hr class="bottom-line">
                </div>
            </div>
            <div class="container">
<p>${name}</p>
  <div class="row">    
    <div class="col-md-9 a" data-aos="fade-right" data-aos-duration="2000">
      <div class="row">
      <c:forEach items="${products}" var="product">
        <div class="col-md-4  portfolio-item">
          <div class="card h-100" id="card">
            <img onclick="viewProduct(${product.id});" class="card-img-top" src="/cakestore/imageDisplay?id=${product.id}">
            <div class="caption">
              <div class="blur"></div>
              <div class="caption-text"> 
              <button class="btn btn-primary" onclick="viewProduct(${product.id});" class="text">BUY NOW</button>                            
                <button class="btn btn-primary" onclick="getCart(${product.id})" class="text">ADD CARD</button>
                
    <sec:authorize access="hasRole('ADMIN')">    
    		
		<button class="btn btn-primary" onclick="editProduct(${product.id});"> Edit</button>
		<button class="btn btn-danger" onclick="deleteProduct(${product.id});"> Delete</button>
	
	</sec:authorize>
	
              </div>
            </div>
            <div class="card-body">
              <h4 class="card-title">
                <a>${product.name}</a>
              </h4>
              <p class="card-text">${product.price} <span class="woocommerce-Price-currencySymbol"></span></p>
            </div>
          </div>
        </div>
 	</c:forEach> 	
      </div>
    </div>   
  
    
  <c:forEach var="i" begin="0" end="${totalItem}">    
                  <a class="btn btn-default" href="<c:url value='/category${id}-${i+1}'/>"> <c:out value="${i+1}"/></a>
  </c:forEach>
</div>
        </div>
</div> --%>


		<!-- detail -->
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>