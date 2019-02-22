<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">

<link href="<c:url value='/resources/index/css/login.css' />"
	rel="stylesheet"></link>


</head>

<body>
	<div id="formWrapper">
		<div class="login-container">
			<div class="login-card" id="form">
				<div class="login-form">
					<div id="img-container">
						<img src="./resources/images/sp02.jpg" alt="img">
					</div>

					<div class="logins">Login</div>
					<br>
					<c:url var="loginUrl" value="/login" />
					<form action="${loginUrl}" method="post" class="form-horizontal">
						<c:if test="${param.error != null}">
							<div class="alert alert-danger">
								<p>Invalid username and password.</p>
							</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">
								<p>You have been logged out successfully.</p>
							</div>
						</c:if>
						<div class="form-item">

							<input type="text" class="form-style" id="username" name="email"
								placeholder="Enter Email" required>
						</div>
						<div class="form-item">

							<input type="password" class="form-style" id="password"
								name="password" placeholder="Enter Password" required>
						</div>
						<div class="input-group input-sm">
							<div class="checkbox">
								<label><input type="checkbox" id="rememberme"
									name="remember-me"> Remember Me</label>
							</div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<p class="pull-left">
							<a href="register">Register</a>
						</p>
						<div class="form-actions">
							<input type="submit" class="login pull-right" value="Log in">
						</div>
						<div class="clear-fix"></div>

					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>