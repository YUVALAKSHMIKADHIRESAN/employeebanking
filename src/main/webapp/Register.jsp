<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<form action="RegisterServlet" method="post">
<table>
<tr>
<td><label>Full Name:</label></td>
<td><input placeholder="Enter user's Full Name" type="text" name="fname" id="fname" required></td>
</tr>

<tr>
<td><label>Address:</label></td>
<td><input placeholder="Enter user's Address" type="text" name="address" id="address" required></td>
</tr>

<tr>
<td><label>Email Id:</label></td>
<td><input placeholder="Enter user's Email ID" type="email" name="emailid" id="emailid" required></td>
</tr>

<tr>
<td><label>Phone Number:</label></td>
<td><input placeholder="Enter user's Phone Number"  type="text" name="phoneno" id="phoneno" required></td>
</tr>

<tr>
<td><label>Date of Birth:</label></td>
<td><input placeholder="Enter user's Date of Birth" type="date" name="dob" id="dob" required></td>
</tr>

<tr>
<td><label>Account Type:</label></td>
<td><input placeholder="Enter user's Account Type" type="text" name="acctype" id="acctype" required></td>
</tr>

<tr>
<td><label>ID Proof:</label></td>
<td><input placeholder="Enter user's Aadhar Number" type="text" name="idproof" id="idproof" required></td>
</tr>

<tr>
<td><label>Initial Balance:</label></td>
<td><input placeholder="Enter user's Initial Balance" type="number" name="inibal" id="inibal" required></td>
</tr>

<tr>
<td colspan=2><input type="submit" value="Register User"></td>
</tr>

</table>
</form>
</body>
</html>
