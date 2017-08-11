<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Main CSS -->
<link href='<c:url value="/res/css/main.css"></c:url>' rel="stylesheet">

<!-- ANGULAR JS -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<div class="navbar-wrapper">
	<div class="container">

		<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href='<c:url value="/"></c:url>'>PrimeStore</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href='<c:url value="/"></c:url>'>Home</a></li>
						<li><a href='<c:url value="/product/productList"></c:url>'>Products</a></li>
						<li><a href="#contact">Contact</a></li>
					</ul>

					<ul class="nav navbar-nav pull-right">
						<c:choose>
							<c:when test="${pageContext.request.userPrincipal.name != null}">
								
								<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
									<li><a href='<c:url value="/admin"/>'>Control Panel</a></li>																		
								</c:if>
								<c:if test="${pageContext.request.userPrincipal.name}!='admin' ">
									<li><a href='<c:url value="/cutomer/cart"/>'><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
								</c:if>
								<li><a href='<c:url value="/" />'>Profile${pageContext.request.userPrincipal.name}</a></li>
								<li><a href='<c:url value="/j_spring_security_logout" />'>Log out</a></li>
							</c:when>
							<c:otherwise>
								<li><a href='<c:url value="/login"></c:url>'>Login</a></li>
								<li><a href='<c:url value="/register"></c:url>'>Register</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</nav>

	</div>
</div>