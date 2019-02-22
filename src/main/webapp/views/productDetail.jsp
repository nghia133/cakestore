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
<script src="./resources/index/js/editproduct.js"></script>
<script
	src=https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js></script>

</head>
<body>
	<%-- <jsp:include page="header.jsp"></jsp:include> --%>
	<br>
	<br>
	<br>

	<div class="generic-container">
		<div class="well lead">product Form</div>
		<form:form action="saveproduct?${_csrf.parameterName}=${_csrf.token}"
			method="POST" modelAttribute="product" enctype="multipart/form-data"
			class="form-horizontal" id="login">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<form:input path="id" type="hidden" />

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="name">name</label>
					<div class="col-md-7">
						<form:input path="name" type="text" class="form-control" id="name"
							name="name" placeholder="${name}" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">image</label>
					<div class="col-md-7">
						<form:input path="image" type="file" class="form-control"
							name="image" size="60" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="price">price</label>
					<div class="col-sm-7">
						<form:input path="price" type="text" class="form-control input-sm"
							id="price" name="price" placeholder="${price}" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="price">category</label>
					<div class="col-sm-7">
						<form:select id="category" name="category" path="category.id"
							class="form-control input-sm">
							<option value="default">Select a category</option>
							<c:forEach var="c" items="${categories}">
								<option value="${c.id}">${c.name}</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">description</label>
					<div class="col-md-7">
						<form:textarea path="description" type="text" class="form-control"
							name="description" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn" /> or	<a
								href="javascript: history.go(-1)">Cancel</a>

						</c:when>
						<c:otherwise>
							<input type="submit" value="add" class="btn btn-primary btn" /> or <a
								href="javascript: history.go(-1)">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

		</form:form>

	</div>

</body>
</html>