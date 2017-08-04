<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Carousel Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link
	href='<spring:url value="/res/css/bootstrap.min.css"></spring:url>'
	rel="stylesheet">


</head>
<!-- NAVBAR
================================================== -->
<body>
	<c:import url="/WEB-INF/views/templates/navigation.jsp"></c:import>
	<div class="container-wrapper" style="margin-top: 2rem;">
		<div class="container">
			<div class="page-header">
				<h1>Customer</h1>
				<p class="lead">Customer details</p>
			</div>

			<form:form commandName="order" class="form-horizontal">
				<h2>Shipping Address</h2>
				
				<div class="form-group">
					<label for="bStreetname">Street Name</label>
					<form:input path="cart.customer.shippingAddress.streetName" id="bStreetname"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="bAparmentNumber">Apartment Number</label>
					<form:input path="cart.customer.shippingAddress.aparmentNumber"
						id="bAparmentNumber" class="form-control" />
				</div>
				<div class="form-group">
					<label for="bCity">City</label>
					<form:input path="cart.customer.shippingAddress.city" id="bCity"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="bState">State</label>
					<form:input path="cart.customer.shippingAddress.state" id="bState"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="bContry">Country</label>
					<form:input path="cart.customer.shippingAddress.country" id="bCountry" class="form-control"/>
					
				</div>
				<div class="form-group">
					<label for="bZipCode">ZipCode</label>
					<form:input path="cart.customer.shippingAddress.zipCode" id="bZipCode" class="form-control"/>
				</div>
				
				<div class="form-group">
					<input type="hidden" name="_flowExecutionKey">
					<button class="btn btn-default" name="_eventId_backCollectCustommerInfo">Back</button>
					<input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected">
					<button class="btn btn-default" name="_eventId_cancel">Cancel</button>
				</div>
			</form:form>

			<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
		</div>

	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src='<c:url value = "/res/js/jquery-1.11.3.minjs"/>><\/script>')</script>
	<script src='<c:url value="/res/js/bootstrap.min.js"/>'></script>
	</script>

</body>
</html>
