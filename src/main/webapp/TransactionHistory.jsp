<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction History</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<table>
    <tr>
        <th>Transaction ID</th>
        <th>Account Number</th>
        <th>Date</th>
        <th>Time</th>
        <th>Type</th>
        <th>Amount</th>
    </tr>
<%
ResultSet transactions = (ResultSet) request.getAttribute("transactions");
while (transactions.next()) {
%>
    <tr>
        <td><%= transactions.getInt("tid") %></td>
        <td><%= transactions.getString("taccno") %></td>
        <td><%= transactions.getString("tdate") %></td>
        <td><%= transactions.getString("ttime") %></td>
        <td><%= transactions.getString("twd") %></td>
        <td><%= transactions.getString("tamt") %></td>
    </tr>
<%
}
%>
</table>
<a href="DownloadPDFServlet" class="download-link">Download Transactions as PDF</a>
</body>
</html>
