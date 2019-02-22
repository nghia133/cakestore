<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<c:url value= './resources/index/css/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="./resources/index/css/collection.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<script src="./resources/index/js/jquery-2.1.0.min.js"></script>
<script src="./resources/index/js/bootstrap.min.js"></script>

</head>

<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	<%-- <nav class="navbar navbar-expand-lg   fixed-top" id="header-top">
		<a class="navbar-brand" href="#">MP de Bakery</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="icon-bar"> </span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="admin/"><i
						class="fas fa-home">&nbsp;Home</i> <span class="sr-only">(current)</span>
				</a></li>			
						
				<li class="nav-item "><a class="nav-link" href="products/"><i
						class="fas fa-cookie"></i>&nbsp;Product </a></li>
						
									 
					
					
				
				<li class="nav-item "><a class="nav-link">
				<span> <c:out value="${sessionScope.myCartNum}"/></span>
				<i class="fas fa-shopping-cart"></i> &nbsp;Cart </a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i class="fas fa-user"></i>&nbsp;Customer
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="registration"><i class="fas fa-user-plus"></i>
							&nbsp;Sign up</a> <a class="dropdown-item" href="login"><i
							class="fas fa-sign-in-alt"></i>&nbsp;Sign in</a>
					</div></li>
			</ul>
			<form id="demo-2">
				<input type="search" placeholder="Search">
			</form>

		</div>
	</nav> --%>
	<!-- header -->
	<!-- body -->
	<!-- chua viet -->
	<div id="carouselExampleSlidesOnly" class="carousel slide"
		data-ride="carousel">
		<div id="carouselExampleControls" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-100" src="./resources/images/1.jpg"
						alt="First slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" src="./resources/images/5.jpg"
						alt="Second slide">
				</div>
				<div class="carousel-item">
					<img class="d-block w-100" src="./resources/images/4.jpg"
						alt="Third slide">
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleControls"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleControls"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<!-- collection -->
	<div class="container">

		<div data-aos="flip-up" data-aos-duration="1200">
			<div class="row">
				<div id="product" class="col-md-12 mr-auto text-center">
					<h2>Collection</h2>
					<hr class="bottom-line">
				</div>
			</div>

			<div id="social" class="row  scrollto ">
				<div data-aos="flip-up" data-aos-duration="2400" class="collec">
					<a class="col-3"><img src="./resources/images/sp4.jpg"></a>
					<div class="caption">
						<div class="blur"></div>
						<div class="caption-text">Chese Love</div>
					</div>
				</div>
				<div data-aos="flip-up" data-aos-duration="1200" class="collec">
					<a class="col-3"><img src="./resources/images/sp22.jpg"></a>
					<div class="caption">
						<div class="blur"></div>
						<div class="caption-text">Chese Mut</div>
					</div>
				</div>
				<div data-aos="flip-up" data-aos-duration="1300" class="collec">
					<a class="col-3"><img src="./resources/images/lamt1.jpg"
						style="max-width: 380px; height: 380px;"></a>
					<div class="caption">
						<div class="blur"></div>
						<div class="caption-text">Tart Matcha</div>
					</div>
				</div>
				<div data-aos="flip-up" data-aos-duration="2500" class="collec">
					<a class="col-3"><img src="./resources/images/lamini1.jpg"
						style="max-width: 380px; height: 380px;"></a>
					<div class="caption">
						<div class="blur"></div>
						<div class="caption-text">Tart mini</div>
					</div>
				</div>
				<div data-aos="flip-up" data-aos-duration="1400" class="collec">
					<a class="col-3"><img src="./resources/images/sp02.jpg"></a>
					<div class="caption">
						<div class="blur"></div>
						<div class="caption-text">Chese Tart</div>
					</div>

				</div>
				<div data-aos="flip-up" data-aos-duration="3000" class="collec">
					<a class="col-3"><img src="./resources/images/sp01.jpg"></a>
					<div class="caption">
						<div class="blur"></div>
						<div class="caption-text">Banh Su mini</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- collection -->
	<!-- body -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- footer -->
	<!-- <footer class="footer-site">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-lg-offset-1">
					<div class="footer">
						4 sub menu
						<div class="row">
							<div class="col-lg-8">
								menu
								<div class="row">
									<div class="col-lg-4">

										<h5>MP de Bakery</h5>
										<ul class="list_menu">
											<li><a href="#">Địa chỉ: 59 Lê Trung Nghĩa, Phường
													10, Quận Tân Bình, Tp HCM</a></li>
											<li><a href="#">Điện Thoại: 090090090</a></li>
											<li><a href="#">Bạn có thể liên hệ đến số trên qua
													điện thoại, tin nhắn, zalo, viber, kakaotalk</a></li>
											<li><a href="#">Bạn có thể làm đại lý nhỏ của cửa
													hàng</a></li>

										</ul>



									</div>
									<div class="col-lg-4">

										<h5>Thông Tin</h5>
										<ul class="list_menu">
											<li><a href="#">Sản phẩm MP de Bakery</a></li>
											<li><a href="#">Chính sách giao hàng</a></li>
											<li><a href="#">Đánh giá từ khách hàng</a></li>
											<li><a href="#">Thông tin liên hệ</a></li>
										</ul>



									</div>


								</div>

							</div>
							Social
							<div class="col-lg-4">
								<div class="row">
									<div class="social">
										<ul>
											<li><a class="fab fa-facebook-f" href="#"><span>Facebook</span></a></li>
											<li class="twitter"><a class="fab fa-twitter" href="#"><span>Twitter</span></a></li>
											<li class="google"><a class="fab fa-google-plus-square"
												href="#"><span>Google</span></a></li>
											<li><a class="fab fa-amazon" href="#"><span>Amazon</span></a></li>
										</ul>
									</div>
								</div>
								<div class="copyright">Copyright &copy; Website design by
									Minh Phuoc</div>

							</div>
						</div>

					</div>

				</div>


			</div>
		</div>
	</footer> -->
	<!-- footer -->
</body>
</html>
