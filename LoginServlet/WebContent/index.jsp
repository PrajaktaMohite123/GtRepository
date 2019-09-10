<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link href="design.css" rel="stylesheet" type="text/css">
<title>Login</title>
<link rel="stylesheet" href="styles/kendo.common.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.min.css" />
    <link rel="stylesheet" href="styles/kendo.default.mobile.min.css" />

    <script src="js/jquery.min.js"></script>
    <script src="js/kendo.all.min.js"></script>
    
    
</head>
<body>

<form action="LoginServlet2" method="post" class="loginPage" onsubmit="return validate()">

<div class="imgcontainer">
    <img src="loginImg.jpg" alt="Avatar" class="avatar">
  </div>



		<table  style="with: 50%">
 
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username"  required></td>
			</tr>
				<tr>
				<td>Password</td>
				<td><input type="password" name="password"  required></td>
			</tr>
		</table>
		<input type="submit" value="Login" />
		<a href="Register.jsp">signUp</a>
		
		</form>
		
</body>
</html>
