

<%@page import="com.surajanbhule.entities.User"%>
<%
User admin_user=(User) session.getAttribute("current-user");

if(admin_user==null){
	session.setAttribute("messege", "Login With Admin Credentials To Access");
	session.setAttribute("msg_type","danger");
	
	response.sendRedirect("/login");
	return ;
}

if(admin_user.getUser_type().equals("normal")){
	session.setAttribute("messege", "You are not allowed to access this page");
	session.setAttribute("msg_type","danger");
	
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
</head>
<body>
	<h1>Welcome To Admin Page</h1>
</body>
</html>