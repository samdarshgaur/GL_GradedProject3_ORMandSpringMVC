<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Customer Form</title>
</head>
<body>
	
	<div class="container">
		<h3>Customer Relationship Management</h3>
		<hr>
		
		<h4>Customer Form</h4>
		
		<form action="/CustomerRelationshipManagement/customers/save" method="POST">
			<input type="hidden" name="id" value="${customer.id}" />
			
			<div class="form-inline">
				<input type="text" name="firstName" value="${customer.firstName}"
					class="form-control mb-4 col-4" placeholder="FirstName">
			</div>
			
			<div class="form-inline">
				<input type="text" name="lastName" value="${customer.lastName}"
					class="form-control mb-4 col-4" placeholder="LastName">
			</div>

			<div class="form-inline">
				<input type="text" name="email" value="${customer.email}"
					class="form-control mb-4 col-4" placeholder="Email">
			</div>
			
			<button type="submit" class="btn btn-success col-2">Save</button>
		</form>
		
		<hr>
		<a href="/CustomerRelationshipManagement/customers/list">Back to Customers List</a>
		
	</div>
	
</body>
</html>