package com.Bank.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bank.Bean.RegisterBean;
import com.Bank.Database.AdminDao;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            Random rand = new Random();
            long account_number = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
            String accno = Long.toString(account_number);
            int password = 1000 + rand.nextInt(9000);
            String pass = Integer.toString(password);
            String fname = request.getParameter("fname");
            String address = request.getParameter("address");
            String emailid = request.getParameter("emailid");
            String phoneno = request.getParameter("phoneno");
            String dob = request.getParameter("dob");
            String acctype = request.getParameter("acctype");
            String idproof = request.getParameter("idproof");
            int inibal = Integer.parseInt(request.getParameter("inibal"));

            RegisterBean bean = new RegisterBean();
            bean.setAccno(accno);
            bean.setAcctype(acctype);
            bean.setAddress(address);
            bean.setDob(dob);
            bean.setEmailid(emailid);
            bean.setFname(fname);
            bean.setIdproof(idproof);
            bean.setInibal(inibal);
            bean.setPass(pass);
            bean.setPhoneno(phoneno);

            AdminDao admindao = new AdminDao();
            if(inibal >= 1000) {
                if (admindao.insert_user(bean)) {
                    out.println("Added Details Successfully");
                } else {
                    out.println("Adding Details has Failed!!!");
                }
            } else {
                out.println("Minimum Balance must be at least 1000!");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
