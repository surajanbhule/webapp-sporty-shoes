<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/components/common-template.jsp"%>
</head>
<body>
	<%@include file="/components/navbar.jsp"%>

	<div class="row">
		<div class="col-md-4 offset-md-4">

			<div
				class="card mt-5  p-3 mb-5 bg-body rounded border border-5 form-border">
				<div
					class="card-header form-head shadow-lg p-3 mb-3 bg-body rounded">
					<h1 class="text-center">Register Here</h1>
				</div>

				<div class="card-body">
					<form action="/process-register" method="post">

						<input type="text" class="form-control " id="usernameInput"
							placeholder="Enter Your Username" name="username">
							
                        <input type="password" class="form-control mt-3" id="passwordInput"
                               placeholder="Enter Your Password" name="password"> 
                               
						<input type="text" class="form-control mt-3" id="first_nameInput"
						       placeholder="Enter Your First Name" name="first_name"> 
						<input
							type="text" class="form-control mt-3" id="last_nameInput"
							placeholder="Enter Your Last Name" name="last_name">

						<input type="email" class="form-control mt-3" id="emailInput"
						       placeholder="Enter Your Email" name="user_email">

						<input type="number"" class="form-control mt-3" id="emailInput"
						       placeholder="Enter Your Phone" name="user_phone">
						        
						<input type="text" class="form-control mt-3" id="cityInput"
							   placeholder="Enter Your City" name="address.city_name">
							   
						<input type="text" class="form-control mt-3" id="streetInput"
						       placeholder="Enter Your Street Name" name="address.street_name">

						<input type="text" class="form-control mt-3" id="landmarkInput"
						       placeholder="Enter Your Landmark" name="address.landmark">

						<input type="number" class="form-control mt-3" id="passwordInput"
	                           placeholder="Enter Your Pincode" name="address.pincode">


						<div class="container text-center mt-3">
							<button class="btn btn-outline-success " type="submit">Submit</button>
							<button class="btn btn-outline-warning ms-3" type="reset">Reset</button>
						</div>
					</form>
				</div>
			</div>



		</div>
	</div>
</body>
</html>