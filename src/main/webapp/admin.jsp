<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<link rel="stylesheet" href="Assets/css/admin.css">
<title>Admin</title>
</head>
<body>

		<div class="left-page">

			<div class="left-select">
				<%="Welcome " + session.getAttribute("user")%>
			</div>

			<div class="left-select">
				<i class="fas fa-bars"></i> Dashboard
			</div>
			<div class="left-select">
				<i class="fas fa-user"></i> Staff Manager
			</div>
			<a href="logout" class="left-select-a">LogOut</a>
		</div>

		<div class="right-page">
			<img alt="picture" src="Assets/img/FptUniversity.jpg">

			<table class="table">
				<caption class="table-caption">Member of the team</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Student ID</th>
					<th>Class</th>
				</tr>
				<tr>
					<td>1</td>
					<td>Member 1</td>
					<td>Member code 1</td>
					<td>Class 1</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Member 2</td>
					<td>Member code 2</td>
					<td>Class 2</td>
				</tr>
			</table>
		</div>

</body>
</html>