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
		<div class="mt-3">
		<%@include file="/components/messege.jsp"%>
		</div>
			<div
				class="card mt-5  p-3 mb-5 bg-body rounded border border-5 form-border">
				<div
					class="card-header form-head shadow-lg p-3 mb-3 bg-body rounded">
					<h1 class="text-center">Login Here</h1>
				</div>
				
				<div class="card-body">
					<form action="">
						<input type="text" class="form-control mt-2" id="usernameInput"
							placeholder="Enter Your Username" name="username"> 
							
							<input type="password" class="form-control mt-3" id="passwordInput"
							        placeholder="Enter Your Password" name="password"> 

						<div class="container text-center mt-3">
							<button class="btn btn-outline-success " type="submit">Login</button>
						</div>
					</form>
				</div>
			</div>



		</div>
	</div>
</body>
</html>