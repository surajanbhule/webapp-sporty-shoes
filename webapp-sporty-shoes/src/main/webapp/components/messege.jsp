
<%
String messege = (String) session.getAttribute("messege");

session.removeAttribute("messege");
String status="";
if(messege==null)
	status="hide";
else
	status="show";
	
%>

<div class="alert alert-success alert-dismissible fade <%= status %>" role="alert">
  <h3 class="text-center"><%= messege %></h3>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>