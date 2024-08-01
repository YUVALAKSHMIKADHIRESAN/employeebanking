<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Portal</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<form>
<table>
<tr>
<td><label>Account Number:</label></td>
<td><input type="text" name="accno" id="accno"></td>
</tr>
<tr>
<td><label>Password:</label></td>
<td><input type="password" name="password" id="password"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Login" formmethod="post" formaction="LoginServlet"></td>
</tr>
</table>

</form>
</body>
</html>
