<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="webjars/bootstrap/3.3.7-1/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Home!</title>
</head>
<body>
	<%@ page import="com.revature.model.User" %>
	<% User user = (User) request.getSession().getAttribute("authorizedUser"); %>
	<h1>Welcome home, <%= user.getFirstname() %></h1>
</body>
</html>