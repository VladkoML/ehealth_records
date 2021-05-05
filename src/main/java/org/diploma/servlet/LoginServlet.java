package org.diploma.servlet;

import org.diploma.dao.CrudDAO;
import org.diploma.dao.LoginDAO;
import org.diploma.dao.PatientDAOImpl;
import org.diploma.entity.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        int id = LoginDAO.validate(email, password);
//        out.write("<script type=\"text/javascript\">\n" +
//                "console.log(" + id + ")" +
//                "</script>");

        if(id > 0){

            CrudDAO<Patient> p = new PatientDAOImpl();
            Patient patient = p.find(id);

            req.setAttribute("patient", patient);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/profile.jsp");
            requestDispatcher.forward(req, resp);

        } else {

//            out.write("<h2 class=\"user__title\">" + "Email or password is incorrect!" + "</h2>");
            out.write("<script type=\"text/javascript\">\n" +
                    "alert(\"Email or password is incorrect\")" +
                    "</script>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
            requestDispatcher.include(req, resp);

        }

        out.close();

    }

}
