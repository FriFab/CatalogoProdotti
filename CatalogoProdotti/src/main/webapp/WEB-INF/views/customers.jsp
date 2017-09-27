<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css
/bootstrap.min.css">
<title>Customers</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Fornitori</h1>
				<p>Tutti i nostri fornitori</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${Supplier}" var="supplier">
				<div class="col-sm-6 col-md-3">
					<div class="thumbnail">
						<div class="caption">
						
							<h3>${supplier.name}</h3>
							<p>${supplier.address}</p>
							<p>$${supplier.email}</p>
						   
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>