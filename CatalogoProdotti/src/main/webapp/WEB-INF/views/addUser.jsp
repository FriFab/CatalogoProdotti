<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>User</title>
</head>
<body>
	<section>
		<div class="pull-right" style="padding-right: 50px">
			<a href="?language=en">English</a> | <a href="?language=it">Italian</a> |<a href="?language=nl">Dutch</a> | <a href="?language=jp">Japanese</a>
			<a href="<c:url value="/logout" />">Logout</a>
		</div>
	</section>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>Add products</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form method="POST" modelAttribute="newUser"
			class="form-horizontal" enctype="multipart/form-data">
			
			<form:errors path="*" cssClass="alert alert-danger" element="div"/>
			<fieldset>
				<legend>Add new User</legend>
			
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">
						<spring:message code="addUser.form.name.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text"
							class="form:input-large" />
								
						<form:errors path="name" cssClass="text-danger"/>
						
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="address">
						<spring:message code="addUser.form.address.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="address" path="address" type="text"
							class="form:input-large" />
								
						<form:errors path="address" cssClass="text-danger"/>
						
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="password">
						<spring:message code="addProduct.form.password.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="password" path="password" type="text"
							class="form:input-large" />
					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>