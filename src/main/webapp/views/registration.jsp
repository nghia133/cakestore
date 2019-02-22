<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="./resources/index/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./resources/index/css/login.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="./resources/index/js/jquery-2.1.0.min.js"></script>
<script src="./resources/index/js/bootstrap.min.js"></script>
<script src="./resources/index/js/register.js"></script>
<script
	src=https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js></script>
</head>
<body>

	<!-- login -->
	<div id="formWrapper">
		<div id="form">
			<div id="img-container">
				<img src="./resources/images/sp22.jpg" alt="img">
			</div>
			<div class="logins">Register</div>
			<form:form action="register" method="POST" modelAttribute="user"
				class="login">
				<div class="form-item">
					<form:input type="hidden" path="id" class="form-style"></form:input>
				</div>
				<div class="form-item">
					<p class="formLabel">Fullname</p>
					<form:input type="text" name="name" path="name" class="form-style"
						autocomplete="off"></form:input>
				</div>

				<div class="form-item">
					<p class="formLabel">Address</p>
					<form:input type="text" name="address" path="address"
						class="form-style" autocomplete="off"></form:input>
				</div>

				<div class="form-item">
					<p class="formLabel">Phone</p>
					<form:input type="text" name="phone" path="phone"
						class="form-style" autocomplete="off"></form:input>
				</div>

				<div class="form-item">
					<p class="formLabel">Email</p>
					<form:input type="email" name="email" path="email"
						class="form-style" autocomplete="off"></form:input>
				</div>

				<div class="form-item">
					<p class="formLabel">Password</p>
					<form:input type="password" path="password" class="form-style"></form:input>
				</div>

				<div class="form-item">
					<p class="formLabel">Confirm Password</p>
					<form:input type="password" name="confirm_password" path=""
						class="form-style"></form:input>
				</div>
				<form:input type="hidden" path="userProfiles" value="2"
					class="form-style"></form:input>

				<div class="form-item">
					<input type="submit" class="login pull-right" value="Register" /><a
						href="javascript: history.go(-1)">Cancel</a>


					<div class="clear-fix"></div>
				</div>
			</form:form>
		</div>
	</div>
	<!-- login -->
	<script type="text/javascript">

	
</script>
</body>
</html>