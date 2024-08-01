package com.Bank.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bank.Database.AdminDao;

@WebServlet("/CloseAccountServlet")
public class CloseAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CloseAccountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
		
		HttpSession sess3 = request.getSession(false);
		String accno = (String) sess3.getAttribute("accnumber");
		AdminDao dao = new AdminDao();
		if(dao.checkBalance(accno)) {
			if(dao.removeUser(accno)) {
				out.println("<script>alert('User removed successfully!');</script>");
			}
			else {
				out.println("<script>alert('User removed unsuccessfully!');</script>");
			}
		}
		else {
			out.println("<script>alert('Balance is not Zero!');</script>");
		}
	}

}
