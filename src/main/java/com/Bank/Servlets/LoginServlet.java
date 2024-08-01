package com.Bank.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bank.Bean.LoginBean;
import com.Bank.Database.LoginDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String account_number = request.getParameter("accno");
        String password = request.getParameter("password");

        LoginBean bean = new LoginBean();
        bean.setAccno(account_number);
        bean.setPassword(password);

        LoginDao logindao = new LoginDao();

        if (logindao.validate(bean)) {
        	HttpSession session = request.getSession();
    		session.setAttribute("beandet", bean);
    		Connection conn = logindao.getConnection();
			String sql = "select * from userdetails where accno = ? ";
        	try {
        		PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, account_number);
				ResultSet rs = stmt.executeQuery();
				session.setAttribute("result", rs);

			} catch (SQLException e) {
				
				e.printStackTrace();
			} 
        	finally {
        	RequestDispatcher disp = request.getRequestDispatcher("UserDashboard.jsp");
			disp.forward(request, response);
        	}
        } else {
            out.println("Failed");
        }
    }
}
