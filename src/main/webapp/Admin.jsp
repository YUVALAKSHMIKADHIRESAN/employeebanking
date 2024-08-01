<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Portal</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<form>
<table>
<tr>
<td><label>Admin Id Number:</label></td>
<td><input type="text" name="adminId" id="adminId"></td>
</tr>
<tr>
<td><label>Password:</label></td>
<td><input type="password" name="password" id="password"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="Login" formmethod="post" formaction="AdminServlet"></td>
</tr>
</table>
</form>
</body>
</html>
