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
	<div class="container-wrapper" style="margin-top: 3rem;">
		<div class="container">
			<div class="login-box">
				<div class="page-header">
				<h1>Login Page</h1>
				<p class="lead">Login with Username and Password</p>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>	
				
			</div>

			<form name="loginForm"
				action='<c:url value="/j_spring_security_check"></c:url>'
				method="post">
				<c:if test="${not empty error}">
					<div class="msg">${error}</div>
				</c:if>	
				<div class="form-group">
					<label for="username">User:</label> 
					<input type="text" id="username" name="username" class="form-control" />
				</div>
				<div class="form-group">
					<label for="password">Password:</label> 
					<input type="text" id="password" name="password" class="form-control" />
				</div>
				<input type="submit" value="Submit" class="btn btn-default"/>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
				
			</div>
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
