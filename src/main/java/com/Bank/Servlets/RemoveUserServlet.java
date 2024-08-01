package com.Bank.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bank.Database.AdminDao;

@WebServlet("/RemoveUserServlet")
public class RemoveUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RemoveUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String accno = request.getParameter("accno");
        AdminDao admindao = new AdminDao();

        if (accno != null && !accno.isEmpty()) {
            boolean balanceCheck = admindao.checkBalance(accno);
            
            if (balanceCheck) {
            	
                boolean removed = admindao.removeUser(accno);

                if (removed) {
                    out.println("<script>alert('User removed successfully!');</script>");
                    out.println("<a href= AdminDashboard.jsp> back </a> ");
                } else {
                    out.println("<script>alert('Failed to remove user. Please try again later.');</script>");
                    out.println("<a href= AdminDashboard.jsp> back </a> ");
                }
            } else {
                out.println("<script>alert('User balance is not zero. User cannot be removed.');</script>");
                out.println("<a href= AdminDashboard.jsp> back </a> ");
            }
        } else {
            out.println("<script>alert('Please provide a valid account number');</script>");
            out.println("<a href= AdminDashboard.jsp> back </a> ");
        }
    }
}