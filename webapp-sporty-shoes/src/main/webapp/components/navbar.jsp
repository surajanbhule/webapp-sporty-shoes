
<%@page import="com.surajanbhule.entities.User"%>
<%
User user = (User) session.getAttribute("current-user");
int noOfItems=0;
if(user==null){
	noOfItems=0;
}
else{
	noOfItems=user.getCart().getCart_products_list().size();
}
%>

<nav class="navbar navbar-expand-lg bg-light custom-navbar-bg">
	<div class="container-fluid">
		<a class="navbar-brand" href="/"><i class="fa-solid fa-boot-heeled text-secondary">Sporty Shoes</i></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			</ul>

			<%
			if (user == null) {
			%>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/login"><i class="fa-solid fa-right-to-bracket me-2"></i>Log In</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/register"><i class="fa-sharp fa-solid fa-user-plus me-2"></i>Register</a></li>
			</ul>

			<%
			} else {
			%>
            
			<ul class="navbar-nav ml-auto">
				
			    
				<li class="nav-item"><a class="nav-link active" data-bs-toggle="modal" data-bs-target="#cartModal"
					aria-current="page" href=""> <i class="fa-sharp fa-solid fa-cart-shopping text-primary">
					<sup class="fs-6 text-black fw-bold"><%= noOfItems==0? "" :noOfItems %></sup></i></a></li>
						 
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href=""><i class="fa-sharp fa-solid fa-user text-primary "></i><%= "  "+user.getFirst_name() %></a></li>
						 
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/logout"><i class="fa-solid fa-right-from-bracket text-primary"></i>Logout</a></li>
			</ul>

			<%
			}
			%>

		</div>
	</div>
</nav>

