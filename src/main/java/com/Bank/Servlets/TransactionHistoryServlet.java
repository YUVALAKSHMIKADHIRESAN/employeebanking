package com.Bank.Servlets;

import java.io.IOException;
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

import com.Bank.Database.LoginDao;

@WebServlet("/TransactionHistoryServlet")
public class TransactionHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TransactionHistoryServlet() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession(false);
        String accno = (String) sess.getAttribute("accnumber");

        LoginDao logindao = new LoginDao();

        try {
            Connection conn = logindao.getConnection();
            String sql = "SELECT * FROM transactions WHERE taccno = ? ORDER BY tid DESC LIMIT 10";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, accno);
            ResultSet rs = stmt.executeQuery();
            request.setAttribute("transactions", rs);
            RequestDispatcher disp = request.getRequestDispatcher("TransactionHistory.jsp");
            disp.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
