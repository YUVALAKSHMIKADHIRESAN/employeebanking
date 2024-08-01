package com.Bank.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bank.Database.LoginDao;

@WebServlet("/PasswordServlet")
public class PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PasswordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession sess = request.getSession(false);  
		String accno = (String) sess.getAttribute("accnumber");
		
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		
		LoginDao dao = new LoginDao();
		
		if(pass.equals(repass)) {
			if(dao.changepass(accno, pass)) {
				out.println("Password Changed");
			}
			else {
				out.println("Password is not Changed");
			}
		}
		else {
			out.println("Passwords do not match!");
		}
	}

}