package com.Bank.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bank.Database.LoginDao;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public WithdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession(false);
        String accno = (String) sess.getAttribute("accnumber");

        LoginDao logindao = new LoginDao();

        String amts = request.getParameter("amt");
        long amount = Long.parseLong(amts);
        long balance = (long) sess.getAttribute("bal");

        if (amount > balance) {
            response.getWriter().println("Insufficient balance");
            RequestDispatcher disp = request.getRequestDispatcher("UserDashboard.jsp");
            disp.include(request, response);
        } else {
            try {
                Connection conn = logindao.getConnection();
                long result = balance - amount;
                String query = "UPDATE userdetails SET balance = ? WHERE accno = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setLong(1, result);
                stmt.setString(2, accno);
                stmt.executeUpdate();

                
                String tdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                String ttime = new SimpleDateFormat("HH:mm:ss").format(new Date());
                String insertTransaction = "INSERT INTO transactions (taccno, tdate, ttime, twd, tamt) VALUES (?, ?, ?, 'Withdraw', ?)";
                PreparedStatement transStmt = conn.prepareStatement(insertTransaction);
                transStmt.setString(1, accno);
                transStmt.setString(2, tdate);
                transStmt.setString(3, ttime);
                transStmt.setLong(4, amount);
                transStmt.executeUpdate();

                HttpSession session = request.getSession();
                String sql = "SELECT * FROM userdetails WHERE accno = ?";
                try {
                    PreparedStatement stmt2 = conn.prepareStatement(sql);
                    stmt2.setString(1, accno);
                    ResultSet rs = stmt2.executeQuery();
                    session.setAttribute("result", rs);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                RequestDispatcher disp = request.getRequestDispatcher("UserDashboard.jsp");
                disp.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
