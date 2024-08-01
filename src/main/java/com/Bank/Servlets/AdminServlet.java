package com.Bank.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bank.Bean.AdminBean;
import com.Bank.Database.AdminDao;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String adminid = request.getParameter("adminId");
		String password = request.getParameter("password");
		
		AdminBean bean = new AdminBean();
		
		bean.setAdminid(adminid);
		bean.setAdminpass(password);
		
		AdminDao dao = new AdminDao();
		
		if(dao.validate(bean)) {
			RequestDispatcher disp = request.getRequestDispatcher("AdminDashboard.jsp");
			disp.forward(request, response);
		}
		else {
			out.println("Failed");
		}
	}

}
