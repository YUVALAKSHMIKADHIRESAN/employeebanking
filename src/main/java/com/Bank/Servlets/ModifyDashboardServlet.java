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

import com.Bank.Database.AdminDao;

@WebServlet("/ModifyDashboardServlet")
public class ModifyDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyDashboardServlet() {
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
            Connection conn = admindao.getConnection();
            String query = "select * from userdetails where accno = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, accno);
                ResultSet result = stmt.executeQuery();
                if (result.next()) {
                    HttpSession sess = request.getSession();
                    sess.setAttribute("accno", accno);
                    sess.setAttribute("name", result.getString("name"));
                    sess.setAttribute("address", result.getString("address"));
                    sess.setAttribute("phoneno", result.getString("phoneno"));
                    sess.setAttribute("emailid", result.getString("emailid"));
                    sess.setAttribute("acctype", result.getString("acctype"));
                    sess.setAttribute("dob", result.getString("DOB"));
                    sess.setAttribute("idproof", result.getString("idproof"));
                    
                    RequestDispatcher disp = request.getRequestDispatcher("ModifyUser.jsp");
                    disp.forward(request, response);
                } else {
                    out.println("<script>alert('Enter a valid account number');</script>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            out.println("<script>alert('Please provide a valid account number');</script>");
        }
	}

}
