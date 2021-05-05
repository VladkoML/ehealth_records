package org.diploma.servlet;

import org.diploma.dao.ConnectionDB;
import org.diploma.entity.Patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/welcomeServlet"})
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Connection con = ConnectionDB.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT * FROM patients WHERE email=? AND password=?");
            ps.setString(1, "saintpeople1488@gmail.com");
            ps.setString(2, "qwerty12345");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("patient_id");
                out.write("<h2>Welcome " + id + "</h2>");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.close();

    }

}
