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

    <title>Customer Managment Page</title>

    <!-- Bootstrap core CSS -->
    <link href='<spring:url value="/res/css/bootstrap.min.css"></spring:url>' rel="stylesheet">

    
  </head>
<!-- NAVBAR
================================================== -->
  <body>
  <c:import url="/WEB-INF/views/templates/navigation.jsp"></c:import>
    <div class="container-wrapper" style="margin-top:1rem;">
    	<div class="container">
    		<div class="page-header">
    			<h1>Customer managementy page</h1>
    			<p class="lead">This is the customer management page</p>
    		</div>
    		
			<table class="table">
				<thead>
					<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Username</th>
					<th>Enabled</th>					
					</tr>
				</thead>
				<tbody>
					<c:forEach items='${customerList}' var="customer">
					<tr>
						<th>${customer.customerName}</th>
						<th>${customer.customerEmail}</th>			
						<th>${customer.customerPhone}</th>
						<th>${customer.username}</th>
						<th>${customer.enabled}</th>
												
					</tr>
					</c:forEach>
				</tbody>
				
			</table>
	
		<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
    	</div>
   	
    </div>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src=""<c:url value = "res/js/jquery-1.11.3.minjs"/>'><\/script>')</script>
    <script src='<c:url value="res/js/bootstrap.min.js"/>'></script></script>

  </body>
</html>
