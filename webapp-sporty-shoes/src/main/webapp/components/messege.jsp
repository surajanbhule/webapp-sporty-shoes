
<%
String messege = (String) session.getAttribute("messege");
String alert_type=(String)session.getAttribute("msg_type");
session.removeAttribute("messege");
String status="";

if(messege==null)
	status="hide";
else
	status="show";
	
%>

<div class="alert alert-<%=alert_type%> alert-dismissible fade <%= status %>" role="alert">
  <h3 class="text-center"><%= messege %></h3>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>