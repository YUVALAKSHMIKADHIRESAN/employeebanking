<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form method="post">
<table>
<%
HttpSession sess = request.getSession(false);  
String accno = (String) sess.getAttribute("accnumber");
%>

<tr>
<td><label>Enter new Password:</label></td>
<td><input type="text" name="pass" id="pass">
</td>
</tr>

<tr>
<td><label>Re - Enter new Password:</label></td>
<td><input type="text" name="repass" id="repass"> 
</td>
</tr>

<tr>
<td colspan=2>
<input type="submit" value="Change Password" formaction="PasswordServlet" formmethod="post" >
</td>
</tr>

</table>

</form>
</body>
</html>