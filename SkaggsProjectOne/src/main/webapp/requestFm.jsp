<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursement Requests</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<%@ page import="com.revature.dao.Employee"%>
	<%
		Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
	%>
	<!-- Navbar begins  -->
	<div class="container">
		<nav class="navbar navbar-inverse">
		<div class="navbar-header col-md-2">
			<a href="./index.jsp" class="navbar-brand">Skaggs Corp</a>
		</div>
		<ul class="navbar-nav nav">
			<li><a href="fm.jsp">Home</a></li>
		</ul>
		<ul class="navbar-nav nav">
			<li><a href="update.jsp">Update Info</a></li>
		</ul>
		<ul class="navbar-nav nav">
			<li><a href="requestEmployee.jsp">View Reimbursement
					Requests</a></li>
		</ul>
		<ul class="navbar-nav nav navbar-right col-md-2 col-md-offset-2">
			<li><a href="logout.jsp">Log Out <span
					class="glyphicon glyphicon-log-out" id="logout-elmt"> </span></a></li>
		</ul>
		</nav>
	</div>
	<div class="container">
		<div class="col-md-7">
			<h2>Your Reimbursement Request</h2>
			<table class="table table-striped table-hover table-bordered"
				id="requestTable">
				<thead>
					<tr>
						<th>Reimbursement ID</th>
						<th>Category</th>
						<th>Status</th>
						<th>Amount</th>
						<th>Date Submitted</th>
						<th>Employee Name</th>
						<th>Approved By</th>
					</tr>
				</thead>
				<tbody id="table-body">
					<tr>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-md-7">
			<form id="update-request-form" action="update-request.do"
				method="post" role="form">
				<label for="inputId">Enter Reimbursement ID</label> <input
					type="number" id="inputId" name="inputId">
				<div class="form-group">
					<label>Reimbursement Type</label> <select class="form-control"
						id="approval" name="approval">
						<option>Approve</option>
						<option>Deny</option>
					</select>
				</div>
				<div>
					<input type="submit" name="update-request-submit" id="update-request-btn"
						class="form-control btn btn-submit" value="Approve or Deny">
				</div>
			</form>
		</div>
	</div>
	<script src="requestFm.js"></script>

</body>
</html>