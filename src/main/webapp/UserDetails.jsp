<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<form action = "UserDetailsServlet" method="post">
<label>Enter Account Number to see details:</label>
<input type="text" name="accno" id="accno" >
<input type="submit" value="Get Details" >

</form>
</body>
</html>
