
<%@page import="java.util.ArrayList"%>
<%@page import="com.surajanbhule.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.surajanbhule.entities.User"%>
<%@page import="com.surajanbhule.entities.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes</title>
<%@include file="/components/common-template.jsp"%>
</head>
<body>
	<%@include file="/components/navbar.jsp"%>

	<div class="container-fluid">


		<div class="row mt-4">
			<!-- Categories -->
			<div class="col-md-2 mt-4">

				<div class="list-group">

					<a href="/?catid=all"
						class="list-group-item list-group-item-action ${category_id==0? active :dont_active}"
						aria-current="true">All Products </a>
					<c:forEach items="${categories}" var="category">

						<a href="/?catid=${category.getCategory_id()}"
							class="list-group-item list-group-item-action ${category_id==category.getCategory_id()? active :dont_active}"
							aria-current="true">${category.getCategory_name() } </a>
					</c:forEach>

				</div>
			</div>

			<!-- Products -->

			<div class="col-md-10">

				<div class="row mt-4">


					<div class="col-md-12">




						<div class="row row-cols-1 row-cols-md-3 g-4">
							<c:forEach items="${products}" var="product">
								<div class="col">

									<div class="card">

										<div class="container text-center">
											<a href="/"> <img style="max-height: 250px"
												src="/img/products/${product.getImage1()}"
												class="card-img-top" alt="...">
											</a>
										</div>


										<div class="card-body">


											<h5 class="card-title text-black">${product.getProduct_name()}</h5>


											<div class="card-footer text-center">
												<span class="text-black ms-1"> &#8377
													${product.getProduct_original_price() }</span> <span
													class="text-black ms-1">&#8377 <s>
														${product.getProduct_price() }</s></span> <span
													class="badge rounded-pill text-bg-success ms-1">
													${product.getProduct_discount() }%</span>
													
												<a href="/addToCart?product_id=${product.getProduct_id()}"><button type="button" class="btn btn-sm btn-primary ">Add To Cart</button></a>
													

											</div>
										</div>
									</div>

								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


<!-- Modal -->
	<div class="modal form-border" id="cartModal" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header form-head">

					<div class="container text-center">
						<h5 class="modal-title text-black">CART</h5>
					</div>


				</div>
				<div class="modal-body">
                   <%
                    User user2=(User) session.getAttribute("current-user");
                   List<Product>list_products=null;
                   if(user2==null){
                	   list_products =new ArrayList<>();
                   }
                   else{
                	 list_products = user2.getCart().getCart_products_list();
                   }
                   
                   double totalamount=0;
                   for(Product p:list_products)
                	   totalamount+=p.getProduct_original_price();
                   %>
					<ul class="list-group">
					<c:forEach items="<%=list_products%>" var="cp">
						<li class="list-group-item">
						
						<div class="row">
						
						<div class="col-md-4">
							<span>${cp.getProduct_name()}</span>
						</div>
						
						<div class="col-md-4">
						    <span class="ms-3">${cp.getProduct_original_price()}</span>
						</div>
						
						<div class="col-md-4">
							<button type="button" class="btn btn-danger fixed-end">Delete</button>
						</div>
						
						</div>
						</li>
						</c:forEach>
						<li class="list-group-item mt-4">
						<span><b class="me-1">Total Amount:</b>   <b class="text-green">&#8377 <%= Math.round(totalamount)  %></b> </span>
						</li>
					
					</ul>

				</div>
			<div class="modal-footer">
			
					<button type="button" class="btn btn-success"
						data-bs-dismiss="modal">Place Order</button>
			         
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>