


<%@page import="com.surajanbhule.entities.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.surajanbhule.repositories.CategoryRepository"%>
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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<%@include file="/components/common-template.jsp"%>
</head>
<body>
	<%@include file="/components/navbar.jsp"%>

	<div class="container admin mt-4">
	<%@include file="/components/messege.jsp"%>
		<div class="row mt-3">

			<!-- Col 1 Users -->
			<div class="col-md-3">

				<div class="card shadow-lg mb-5 bg-body rounded mt-2">


					<div class="container text-center">
						<img style="max-width: 125px" src="/img/users.png"
							class="img-fluid" alt="...">
						<h4 class="text-black">
							USERS <span class="badge text-bg-warning mb-3">50</span>
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
							PRODUCTS <span class="badge text-bg-warning mb-3">500</span>
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
							CATEGORIES <span class="badge text-bg-warning mb-3">20</span>
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
							ORDERS <span class="badge text-bg-warning mb-3">20</span>
						</h4>



					</div>
				</div>

			</div>


		</div>
		<div class="row">
			<!-- Col 1 Add Product -->
			<div class="col-md-6">

				<div class="card shadow-lg mb-5 bg-body rounded mt-2 "
					data-bs-toggle="modal" data-bs-target="#addProductModal">


					<div class="container text-center">
						<img style="max-width: 125px" src="/img/add_product.png"
							class="img-fluid " alt="...">
						<h1 class="text-black">ADD PRODUCT</h1>



					</div>
				</div>

			</div>


			<!-- Col 2 Add Category -->
			<div class="col-md-6">

				<div class="card shadow-lg mb-5 bg-body rounded mt-2"
					data-bs-toggle="modal" data-bs-target="#addCategoryModal">


					<div class="container text-center">
						<img style="max-width: 125px" src="/img/add_category.png"
							class="img-fluid " alt="...">
						<h1 class="text-black">ADD CATEGORY</h1>



					</div>
				</div>

			</div>






		</div>

	</div>

	<!-- Start Add Category Model -->




	<!-- Modal -->
	<div class="modal form-border" id="addCategoryModal" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header form-head">

					<div class="container text-center">
						<h5 class="modal-title text-black">ADD CATEGORY</h5>
					</div>


				</div>
				<div class="modal-body">

					<form action="/addCategory" method="post">
						<input type="text" class="form-control mt-2" id="categoryNameInput"
							placeholder="Enter Category Name" name="category_name"> 
							
						<input	type="text" style="height:125px" class="form-control mt-3" id="categoryDescriptionInput"
							placeholder="Enter Category Description" name="category_short_desc">

						<div class="container text-center mt-3">
							<button class="btn btn-outline-success " type="submit">ADD CATEGORY</button>
							
							<button type="button" class="btn btn-outline-danger"
							        data-bs-dismiss="modal">
							 Close
							</button>
						</div>
					</form>


				</div>
				

					

				
			</div>
		</div>
	</div>




	<!-- End Add Category Model -->


	<!-- Modal -->
	<div class="modal form-border" id="addProductModal" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header form-head">

					<div class="container text-center">
						<h5 class="modal-title text-black">ADD PRODUCT</h5>
					</div>


				</div>
				<div class="modal-body">
				
				<form action="/addProduct" method="post" enctype="multipart/form-data">
					
					<input type="text" class="form-control mt-2" id="productNameInput"
							placeholder="Enter Product Name" name="product_name"> 
							
				    <input type="text" style="height:125px" class="form-control mt-2" id="productDescriptionInput"
							placeholder="Enter Product Description" name="product_description">
						
					<select name="category" class="form-control mt-2">
						<c:forEach items="${categories}" var="category">
						<option value="${category.getCategory_id()}">${category.getCategory_name()}</option>
						</c:forEach>
					</select> 
					
					<input type="number"  class="form-control mt-2" id="product_stockInput"
							placeholder="Enter Product Stock" name="product_stock">
					
					<input type="number"  class="form-control mt-2" id="product_DiscountInput"
							placeholder="Enter Product Discount" name="product_discount">
					
					<input type="number"  class="form-control mt-2" id=" product_PriceInput"
							placeholder="Enter Product Price" name=" product_price">
							
					<input type="file" name="image1" class="form-control mt-2" placeholder="Select Product Image 1 ">	
					
					<input type="file" name="image2" class="form-control mt-2" placeholder="Select Product Image 2 ">	
					
					<input type="file" name="image3" class="form-control mt-2" placeholder="Select Product Image 3 ">	
					
					<input type="file" name="image4" class="form-control mt-2" placeholder="Select Product Image 4 ">
					
					<div class="container text-center mt-3">
							<button class="btn btn-outline-success " type="submit">ADD PRODUCT</button>
							
							<button type="button" class="btn btn-outline-danger"
							        data-bs-dismiss="modal">
							 Close
							</button>
						</div>				
				</form>
				
				</div>
				
			</div>
		</div>
	</div>


</body>
</html>