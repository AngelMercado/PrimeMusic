<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="now" class="java.util.Date" />

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
				<h1>Order</h1>
				<p class="lead">Order Confirmation</p>
			</div>
			<div class="container">
				<div class="row">

					<form:form commandName="order" class="form-horizontal">
						<div
							class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-md-offset-3 ">

							<div class="text-center">
								<h1>Recipt</h1>
							</div>
							<div class="row">
								<div class="col-xs-6 col-md-6 col-sd-6">
									<address>
										<strong>Shipping Address</strong></br>
										<p>${order.cart.customer.shippingAddress.streetName}</p>
										</br>
										<p>${order.cart.customer.shippingAddress.aparmentNumber}</p>
										</br>
										<p>${order.cart.customer.shippingAddress.city},
											${order.cart.customer.shippingAddress.state}</p>
										</br>
										<p>${order.cart.customer.shippingAddress.country},
											${order.cart.customer.shippingAddress.zipCode}</p>

									</address>
								</div>
								<div class="col-xs-6 col-md-6 col-sd-6">
									<p>
										Shipping Date:
										<fmt:formatDate value="${now}" />
									</p>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6 col-md-6 col-sd-6">
									<address>
										<strong>Billing Address</strong></br>
										<p>${order.cart.customer.billingAddress.streetName}</p>
										</br>
										<p>${order.cart.customer.billingAddress.aparmentNumber}</p>
										</br>
										<p>${order.cart.customer.billingAddress.city},
											${order.cart.customer.billingAddress.state}</p>
										</br>
										<p>${order.cart.customer.billingAddress.country},
											${order.cart.customer.billingAddress.zipCode}</p>

									</address>
								</div>
							</div>
							<div class="row">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>Product</th>
											<th>#</th>
											<th class="text-center">Price</th>
											<th class="text-center">Total</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cartItem" items="${order.cart.cartItems}">
											<tr>
												<td class="col-md-9 "><em>${cartItem.product.productName}</em></td>
												<td class="col-md-1" style="text-align: center;">${cartItem.quatity}</td>
												<td class="col-md-1" style="text-align: center;">${cartItem.product.productPrice}</td>
												<td class="col-md-1" style="text-align: center;">${cartItem.totalPrice}</td>
											</tr>
										</c:forEach>
										<tr>
											<td></td>
											<td></td>
											<td class="text-right">
												<h4>
													<strong>Grand Total:</strong>
												</h4>
											</td>
											<td class="text-center text-danger">
												<h4>
													<strong>${order.cart.grandTotal}</strong>
												</h4>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="form-group">
								<input type="hidden" name="_flowExecutionKey">
								<button class="btn btn-default"
									name="_eventId_backCollectShippingDetail">Back</button>
								<input type="submit" value="Submit Order" class="btn btn-default"
									name="_eventId_orderConfirmed" />
								<input type="submit" value="Paypal" class="btn btn-default"
									name="_eventId_securePaypal" />	
<!-- 								<div id="paypal" ></div> -->
									
								<button class="btn btn-default" name="_eventId_cancel">Cancel</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>

			<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
		</div>

	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="<c:url value = '/res/js/jquery-1.11.3.minjs'/>"><\/script>')</script>
	<script src='<c:url value="/res/js/bootstrap.min.js"/>'></script>

</body>
</html>
