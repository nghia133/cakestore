<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit user</title>
<link href="<c:url value='/resources/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/resources/app.css' />" rel="stylesheet"></link>
<script src="./resources/index/js/jquery-2.1.0.min.js"></script>
<script src="./resources/index/js/edituser.js"></script>
<script
	src=https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js></script>
</head>

<body>
	<%-- <jsp:include page="header.jsp"></jsp:include> --%>
	<br>
	<br>
	<div class="generic-container">
		<div class="well lead">User Form</div>
		<form:form method="POST" modelAttribute="user" class="form-horizontal"
			id="login">
			<form:input type="hidden" path="id" id="id" />

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="name">name</label>
					<div class="col-md-7">
						<form:input type="text" path="name" id="name"
							class="form-control input-sm" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="address">address</label>
					<div class="col-md-7">
						<form:input type="text" path="address" id="address"
							class="form-control input-sm" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="phone">phone</label>
					<div class="col-md-7">
						<form:input type="text" path="phone" id="phone"
							class="form-control input-sm" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="email" id="email"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="email" class="help-inline" />
						</div>
					</div>
				</div>
			</div>




			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Password</label>
					<div class="col-md-7">
						<p class="pull-left">
							<a href="<c:url value='/editpass' />">change password</a>
						</p>
						<form:input type="hidden" path="password" id="password"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="password" class="help-inline" />
						</div>
					</div>
				</div>
			</div>


			<sec:authorize access="hasRole('ADMIN')">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="userProfiles">Roles</label>
						<div class="col-md-7">
							<form:select name="userProfiles" path="userProfiles"
								class="form-control input-sm">
								<c:forEach var="c" items="${roles}">
									<option value="${c.id}">${c.type}</option>
								</c:forEach>
							</form:select>
							<div class="has-error">
								<form:errors path="userProfiles" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</sec:authorize>

			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn" /> or	<a
								href="javascript: history.go(-1)">Cancel</a>

						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn" /> or <a
								href="javascript: history.go(-1)">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>