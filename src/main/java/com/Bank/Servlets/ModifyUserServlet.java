package com.Bank.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bank.Bean.RegisterBean;
import com.Bank.Database.AdminDao;

@WebServlet("/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ModifyUserServlet() {
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
        HttpSession sess2 = request.getSession(false);
        String accno = (String) sess2.getAttribute("accno");
        try {
            String fname = request.getParameter("fname");
            String address = request.getParameter("address");
            String emailid = request.getParameter("emailid");
            String phoneno = request.getParameter("phoneno");
            String dob = request.getParameter("dob");
            String acctype = request.getParameter("acctype");
            String idproof = request.getParameter("idproof");

            RegisterBean bean = new RegisterBean();
            bean.setAccno(accno);
            bean.setAcctype(acctype);
            bean.setAddress(address);
            bean.setDob(dob);
            bean.setEmailid(emailid);
            bean.setFname(fname);
            bean.setIdproof(idproof);
            bean.setPhoneno(phoneno);

            AdminDao admindao = new AdminDao();

            if (admindao.modifyUser(bean)) {
                out.println("User Details Modified Successfully");
            } else {
                out.println("Failed to Modify User Details");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
