package com.Bank.Servlets;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DownloadPDFServlet")
public class DownloadPDFServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=transactions.pdf");

        Document document = new Document();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            HttpSession session = request.getSession(false);
            String accountNo = (String) session.getAttribute("accnumber");

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empbank", "root", "Yuvakadhir@123");
            ps = con.prepareStatement("SELECT * FROM transactions WHERE taccno = ? ORDER BY tid DESC LIMIT 10");
            ps.setString(1, accountNo);
            rs = ps.executeQuery();

            while (rs.next()) {
                document.add(new Paragraph("Date: " + rs.getString("tdate")));
                document.add(new Paragraph("Time: " + rs.getString("ttime")));
                document.add(new Paragraph("Amount: " + rs.getString("tamt")));
                document.add(new Paragraph("Type: " + rs.getString("twd")));
                document.add(new Paragraph(" "));
            }

        } catch (DocumentException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen()) {
                document.close();
            }
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
