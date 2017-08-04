<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <link href='<spring:url value="/res/css/bootstrap.min.css"></spring:url>' rel="stylesheet">

   
  </head>
<!-- NAVBAR
================================================== -->
  <body>
  <c:import url="/WEB-INF/views/templates/navigation.jsp"></c:import>
    <div class="container-wrapper" style="margin-top:3rem;">
    	<div class="container" ng-app="cartApp">
    		<div class="page-header">
    			<h1>Detail Product</h1>    			
    		</div>
    		<div class="container">
    			<div class="row">
    				<div class="col-md-5">
                                    <img src='<spring:url value="/res/images/${product.idProduct}.png" ></spring:url>' class="imageProduct"/>
    				</div>
    				<div class="col-md-5">
    					<h3>Product Name: ${product.productName}</h3>
    					<p>Product Description: ${product.productDescription}</p>
    					<p>Manufacturer: ${product.productManufacture}</p>
    					<p>Category: ${product.productCategory}</p>
    					<p>Condition: ${product.productCondition}</p>
    					<br>
    					<c:set var="role" scope="page" value="${param.role}"></c:set>
    					<c:set var="url"  scope="page" value="/productList"></c:set>
    					<c:if test="${role.admin}">
    						<c:set var="url" scope="page" value="/admin/productInventory"></c:set>
    					</c:if>
    					<p ng-controller="cartCtrl">
    						<a href='<c:url value="${url}"></c:url>' class="btn btn-default">Back</a>
<%--     						<a href="#" ng-click="addToCart('${product.productId}')"> <span class="glyphicon glyphicon-shopping-cart"/>Order Now</a> --%>
   							<a href="#" ng-click='addToCart("${product.idProduct}")' class="btn btn-warning btn-large">Order Now</a>
    						<a href='<spring:url value="/customer/cart"></spring:url>' class="btn btn-default"> <span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
    					</p>
    				</div>
    			</div>
    		</div>
			
		<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
    	</div>
   	
    </div>
	<script src='<c:url value="/res/js/controller.js"></c:url>'></script>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="<c:url value = "res/js/jquery-1.11.3.minjs"/>><\/script>');</script>
    <script src='<c:url value="/res/js/bootstrap.min.js"/>'></script>

  </body>
</html>
