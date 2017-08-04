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
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <link href='https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css' rel="stylesheet">
    <link href='https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css' rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
  <c:import url="/WEB-INF/views/templates/navigation.jsp"></c:import>
    <div class="container-wrapper" style="margin-top:3rem;">
    	<div class="container">
    		<div class="page-header">
    			<h1>Admin Page</h1>
    			<p class="lead">This administrator page</p>
    		</div>
    		
			<table class="table">
				<thead>
					<tr>
					<th>Photo</th>
					<th>ProductName</th>
					<th>Product Category</th>
					<th>Product Condition</th>
					<th>Product Price</th>
					<th>Product Configuration</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items='${products}' var="product">
					<tr>
						<th><img src='<spring:url value="/res/images/${product.idProduct}.png" ></spring:url>' class="imageCell"/></th>
						<th>${product.productName}</th>			
						<th>${product.productCategory}</th>
						<th>${product.productCondition}</th>
						<th>${product.productPrice}</th>
						<th><a href='<spring:url value="/admin/product/editProduct/${product.idProduct}"></spring:url>'><span class=" glyphicon glyphicon-pencil"/></a></a><a href='<spring:url value="/admin/product/deleteProduct/${product.idProduct}"></spring:url>'><span class=" glyphicon glyphicon-remove"/></a><a href='<spring:url value="/productList/productDetail/${product.idProduct}"></spring:url>'><span class=" glyphicon glyphicon-info-sign"/></a></th>						
					</tr>
					</c:forEach>
				</tbody>
				
			</table>
            <a class="btn btn-primary" href='<spring:url value="/admin/product/addProduct"></spring:url>'>Add Product</a>
	
		<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
    	</div>
   	
    </div>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src='<c:url value = "res/js/jquery-1.11.3.minjs"/>'><\/script>')</script>
    <script src='<c:url value="/res/js/bootstrap.min.js"/>'></script></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src='<c:url value="res/js/bootstrap.min.js"/>'></script></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var searchCondition = '${searchCondition}';
			$('.table').DataTable({
				"lengthMenu":[[1,2,3,4,5,10,-1],[1,2,3,4,5,10,"ALL"]],
				"oSearch": {"sSearch":searchCondition}
			});
		});
	</script>

  </body>
</html>
