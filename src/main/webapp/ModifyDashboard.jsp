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
<form action="ModifyDashboardServlet" method="post">
    <label>Enter Account Number to Modify:</label>
    <input type="text" name="accno" id="accno" required>
    <input type="submit" value="Modify User">
</form>
</body>
</html>
