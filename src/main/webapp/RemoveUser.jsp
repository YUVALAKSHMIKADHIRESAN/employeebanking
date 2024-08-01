<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove User</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<form action="RemoveUserServlet" method="post">
    <label>Enter Account Number to Remove:</label>
    <input type="text" name="accno" id="accno" required>
    <input type="submit" value="Remove User">
</form>
</body>
</html>
