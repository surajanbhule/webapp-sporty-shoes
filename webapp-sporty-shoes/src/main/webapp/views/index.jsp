
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
					
					<a href="/?catid=all" class="list-group-item list-group-item-action ${category_id==0? active :dont_active}" aria-current="true">All Products </a>
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
										<a href="/">
										<img style="max-height: 250px"
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
													<button type="button" class="btn btn-sm btn-primary ">Add To Cart</button>
												
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


</body>
</html>