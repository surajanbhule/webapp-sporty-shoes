

<%@page import="com.surajanbhule.entities.User"%>
<%
User admin_user = (User) session.getAttribute("current-user");

if (admin_user == null) {
	session.setAttribute("messege", "Login With Admin Credentials To Access");
	session.setAttribute("msg_type", "danger");

	response.sendRedirect("/login");
	return;
}

if (admin_user.getUser_type().equals("normal")) {
	session.setAttribute("messege", "You are not allowed to access this page");
	session.setAttribute("msg_type", "danger");

	response.sendRedirect("/");
	return;
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<%@include file="/components/common-template.jsp"%>
</head>
<body>
	<%@include file="/components/navbar.jsp"%>

	<div class="container admin">

		<div class="row mt-3">

			<!-- Col 1 Users -->
			<div class="col-md-3">

				<div class="card shadow-lg mb-5 bg-body rounded mt-2">


					<div class="container text-center">
						<img style="max-width: 125px" src="/img/users.png"
							class="img-fluid" alt="...">
						<h4 class="text-black">
							USERS 
						<span class="badge text-bg-warning mb-3">50</span>
						</h4>
						


					</div>


				</div>



			</div>


			<!-- Col 2 Products -->
			<div class="col-md-3">

				<div class="card shadow-lg mb-5 bg-body rounded mt-2">


					<div class="container text-center">
						<img style="max-width: 125px" src="/img/products.png"
							class="img-fluid " alt="...">
						<h4 class="text-black">
						PRODUCTS
						<span class="badge text-bg-warning mb-3">500</span>
						</h4>



					</div>
				</div>


			</div>


			<!-- Col 3 Categories -->
			<div class="col-md-3">

				<div class="card shadow-lg mb-5 bg-body rounded mt-2">


					<div class="container text-center">
						<img style="max-width: 125px" src="/img/categories.png"
							class="img-fluid " alt="...">
						<h4 class="text-black">
						CATEGORIES
						<span class="badge text-bg-warning mb-3">20</span>
						</h4>



					</div>
				</div>

			</div>
			
			
			<!-- Col 4 Orders Details -->
			<div class="col-md-3">

				<div class="card shadow-lg mb-5 bg-body rounded mt-2">


					<div class="container text-center">
						<img style="max-width: 125px" src="/img/orders.png"
							class="img-fluid " alt="...">
						<h4 class="text-black">
						ORDERS
						<span class="badge text-bg-warning mb-3">20</span>
						</h4>



					</div>
				</div>

			</div>


		</div>
		<div class="row">
			<!-- Col 1 Add Product -->
			<div class="col-md-6">

				<div class="card shadow-lg mb-5 bg-body rounded mt-2">


					<div class="container text-center">
						<img style="max-width: 125px" src="/img/add_product.png"
							class="img-fluid " alt="...">
						<h1 class="text-black">ADD PRODUCT</h1>



					</div>
				</div>

			</div>


			<!-- Col 2 Add Category -->
			<div class="col-md-6">

				<div class="card shadow-lg mb-5 bg-body rounded mt-2">


					<div class="container text-center">
						<img style="max-width: 125px" src="/img/add_category.png"
							class="img-fluid " alt="...">
						<h1 class="text-black">ADD CATEGORY</h1>



					</div>
				</div>

			</div>



			


		</div>

	</div>
</body>
</html>