package com.Bank.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bank.Bean.LoginBean;

public class LoginDao {
    private String dbUrl = "jdbc:mysql://localhost:3306/empbank";
    private String dbUname = "root";
    private String dbPassword = "Yuvakadhir@123";
    private String dbDriver = "com.mysql.cj.jdbc.Driver";

    public void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public boolean validate(LoginBean bean) {
        loadDriver(dbDriver);
        Connection conn = getConnection();
        boolean status = false;

        if (conn != null) {
            String sql = "SELECT * FROM userdetails WHERE accno = ? AND pass = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, bean.getAccno());
                ps.setString(2, bean.getPassword());

                try (ResultSet rs = ps.executeQuery()) {
                    status = rs.next();
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
            System.err.println("Failed to establish a database connection.");
        }

        return status;
    }
    
    public boolean changepass(String accno, String password) {
    	loadDriver(dbDriver);
        Connection conn = getConnection();
    	boolean status = false;
    	
    	if (conn != null) {
            String sql = "update userdetails set pass = ? where accno = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
            	ps.setString(1, password);
            	ps.setString(2, accno);
            	int rs = ps.executeUpdate();
            	status = rs > 0;
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
            System.err.println("Failed to establish a database connection.");
        }
    	
    	return status;
    }
    
    
}