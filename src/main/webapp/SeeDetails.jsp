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
<%
    HttpSession sess1 = request.getSession(false);
    if (sess1 == null || sess1.getAttribute("accno") == null) {
        out.println("<script>alert('Session expired or no user details found.'); window.location.href='UserDetails.jsp';</script>");
        return;
    }
%>

<table>
<tr>
    <td><label>Name:</label></td>
    <td><%= sess1.getAttribute("name") %></td>
</tr>
<tr>
    <td><label>Account Number:</label></td>
    <td><%= sess1.getAttribute("accno") %></td>
</tr>
<tr>
    <td><label>Address</label></td>
    <td><%= sess1.getAttribute("address") %></td>
</tr>
<tr>
    <td><label>Phone Number:</label></td>
    <td><%= sess1.getAttribute("phoneno") %></td>
</tr>
<tr>
    <td><label>Email ID:</label></td>
    <td><%= sess1.getAttribute("emailid") %></td>
</tr>
<tr>
    <td><label>Account Type</label></td>
    <td><%= sess1.getAttribute("acctype") %></td>
</tr>
<tr>
    <td><label>Date of Birth:</label></td>
    <td><%= sess1.getAttribute("dob") %></td>
</tr>
<tr>
    <td><label>ID Proof</label></td>
    <td><%= sess1.getAttribute("idproof") %></td>
</tr>
</table>
</body>
</html>
