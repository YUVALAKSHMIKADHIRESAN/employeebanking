<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify User Details</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<%
    HttpSession sess2 = request.getSession(false);
    if (sess2 == null || sess2.getAttribute("accno") == null) {
        out.println("<script>alert('Session expired or no user details found.'); window.location.href='ModifyDashboard.jsp';</script>");
        return;
    }
%>
<form action="ModifyUserServlet" method="post">
<table>

<tr>
<td><label>Full Name:</label></td>
<td><input placeholder="Enter user's Full Name" value="<%= sess2.getAttribute("name") %>" type="text" name="fname" id="fname"></td>
</tr>

<tr>
<td><label>Address:</label></td>
<td><input placeholder="Enter user's Address" value="<%= sess2.getAttribute("address") %>" type="text" name="address" id="address"></td>
</tr>

<tr>
<td><label>Email Id:</label></td>
<td><input placeholder="Enter user's Email ID" value="<%= sess2.getAttribute("emailid") %>" type="email" name="emailid" id="emailid"></td>
</tr>

<tr>
<td><label>Phone Number:</label></td>
<td><input placeholder="Enter user's Phone Number" value="<%= sess2.getAttribute("phoneno") %>"  type="text" name="phoneno" id="phoneno"></td>
</tr>

<tr>
<td><label>Date of Birth:</label></td>
<td><input placeholder="Enter user's Date of Birth" value="<%= sess2.getAttribute("dob") %>" type="date" name="dob" id="dob"></td>
</tr>

<tr>
<td><label>Account Type:</label></td>
<td><input placeholder="Enter user's Account Type" value="<%= sess2.getAttribute("acctype") %>" type="text" name="acctype" id="acctype"></td>
</tr>

<tr>
<td><label>ID Proof:</label></td>
<td><input placeholder="Enter user's Aadhar Number" value="<%= sess2.getAttribute("idproof") %>" type="text" name="idproof" id="idproof"></td>
</tr>

<tr>
<td colspan=2><input type="submit" value="Modify User"></td>
</tr>

</table>
</form>
</body>
</html>
