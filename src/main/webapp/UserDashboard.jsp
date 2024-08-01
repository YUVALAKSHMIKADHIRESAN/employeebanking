<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.ResultSet" %>  
<%@ page language="java" import="java.sql.*" %>  
<%@ page language="java" import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<form method="post">
<table>
<%
HttpSession sess = request.getSession(false);  
ResultSet rs = (ResultSet) sess.getAttribute("result");
rs.next();
if (true) {
    String fname = rs.getString("name");
    String address = rs.getString("address");
    String phoneno = rs.getString("phoneno");
    String emailid = rs.getString("emailid");
    String acctype = rs.getString("acctype");
    long balance = rs.getLong("balance");
    String dob = rs.getString("DOB");
    String idproof = rs.getString("idproof");
    String accno = rs.getString("accno");
    String pass = rs.getString("pass");
    
    sess.setAttribute("accnumber", accno);
    sess.setAttribute("bal", balance);
%>

<tr>
<td colspan=2><input type="submit" value="Logout" formmethod="post" formaction="Login.jsp">
</td>
</tr>

<tr>
<td colspan=2><input type="submit" value="Change Password" formmethod="post" formaction="password.jsp">
</td>
</tr>

<tr>
<td><label>Name:</label></td>
<td><p><%= fname %></p></td>
</tr>

<tr>
<td><label>Account Number:</label></td>
<td><p><%= accno %></p></td>
</tr>

<tr>
<td><label>Account Type:</label></td>
<td><p><%= acctype %></p></td>
</tr>

<tr>
<td><label>BALANCE: </label></td>
<td><h3><%= balance %></h3></td>
</tr>


<tr>
<td colspan=2><input type="text" placeholder="Enter Amount" name="amt" id="amt"></td>
</tr>






<tr>
<td><input type="submit" value="Deposit" formmethod="post" formaction="DepositServlet"></td>
<td><input type="submit" value="Withdraw" formmethod="post" formaction="WithdrawServlet"></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="Last 10 Transactions" formmethod="post" formaction="TransactionHistoryServlet"></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="Close Account" formmethod="post" formaction="CloseAccountServlet"></td>
</tr>

</table>

<%}
else {
%>
<h1>No data Here!!!</h1>
<%
}
%>
</form>
</body>
</html>