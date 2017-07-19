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
	<c:import url="/WEB-INF/views/templates/header.jsp"></c:import>
	<div class="container-wrapper">
		<div class="container" ng-app="cartApp">
			<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
				<section>
				<div class="jumbotron">
					<h1>Cart</h1>
					<p>All selected products in your shopping cart</p>
				</div>
				</section>
				<section>
				<div>
					<a class="btn btn-danger pull-left" ng-click="clearCart()"><span
						class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
				</div>
				<table class="table table-hover">
					<tr>
						<th>Product</th>
						<th>Unit Price</th>
						<th>Quatity</th>
						<th>Total Price</th>
						<th>Action</th>
					</tr>
					
					<tr ng-repeat="item in cart.cartItems">
						<th>{{item.product.productName}}</th>
						<th>{{item.product.productPrice}}</th>
						<th>{{item.quatity}}</th>
						<th>{{item.totalPrice}}</th>
						<th><a href="#"  ng-click='removeFromCart(item.product.idProduct)'>remove</a></th>
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th>Grand Total</th>
						<th>{{cart.grandTotal}}</th>
					</tr>
				</table>
				{{cart}}
				<a href='<c:url value="/productList"></c:url>' class="btn btn-default">Continue shoping</a> </section>
			</div>
			<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
		</div>

	</div>

	
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src='<c:url value="/res/js/controller.js"></c:url>'></script>
	<script>window.jQuery || document.write('<script src="<c:url value = "/res/js/jquery-1.11.3.minjs"/>><\/script>')</script>
	<script src='<c:url value="/res/js/bootstrap.min.js"/>'></script>
	</script>

</body>
</html>
