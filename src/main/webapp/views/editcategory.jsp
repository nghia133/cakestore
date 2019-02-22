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
<script
	src=https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js></script>
<script src="./resources/index/js/editcategory.js"></script>
</head>

<body>
	<%-- <jsp:include page="header.jsp"></jsp:include> --%>
	<br>
	<br>
	<br>
	<div class="generic-container">
		<div class="well lead">edit category</div>
		<form:form method="POST" modelAttribute="category"
			class="form-horizontal" id="login">
			<form:input type="hidden" path="id" id="id" />
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">category
						Name</label>
					<div class="col-md-7">
						<form:input type="text" path="name" name="name"
							class="form-control input-sm" />

					</div>
				</div>
			</div>


			<input type="submit" value="add" class="btn btn-primary btn" />
			<a href="javascript: history.go(-1)">Cancel</a>




		</form:form>
	</div>
</body>
</html>