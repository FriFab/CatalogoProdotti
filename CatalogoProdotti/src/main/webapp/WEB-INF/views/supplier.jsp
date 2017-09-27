<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>

<script src="/CatalogoProdotto/resources/js/controllers.js"></script>
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
			</div>
		</div>
	</section>
	<section class="container" ng-app="cartApp">
		<div class="row">
			<div class="col-md-5">
				<h3>${supplier.name}</h3>
				<p>${supplier.address}</p>
				<p>
					<strong>Contact : </strong><span class="label label warning">${supplier.email}
					</span>
				</p>
			</div>
		</div>
	</section>
</body>
</html>