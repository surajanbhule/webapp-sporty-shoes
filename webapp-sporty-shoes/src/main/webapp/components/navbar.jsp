
<%@page import="com.surajanbhule.entities.User"%>
<%
User user = (User) session.getAttribute("current-user");
%>

<nav class="navbar navbar-expand-lg bg-light custom-navbar-bg">
	<div class="container">
		<a class="navbar-brand" href="/">Sporty Shoes</a>
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
					aria-current="page" href="/login">Login</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/register">Register</a></li>
			</ul>

			<%
			} else {
			%>

			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/logout">Logout</a></li>
                <li class="nav-item" ><a class="nav-link active" data-bs-toggle="modal" data-bs-target="#cartModal"
					aria-current="page" href="">Cart</a></li>
			</ul>

			<%
			}
			%>

		</div>
	</div>
</nav>

