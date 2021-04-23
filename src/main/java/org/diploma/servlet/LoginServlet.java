package org.diploma.servlet;

import org.diploma.dao.LoginDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

//        List<Specialization> list = spec.getAll();
//        for(Specialization s : SpecializationDAO.getAll()) {
//            out.write("<h5>" + s.toString() + "</h5>");
//        }

        String name = req.getParameter("usermail");
        String password = req.getParameter("userpass");

        if(LoginDAO.validate(name, password)){

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("welcomeServlet");
            requestDispatcher.forward(req, resp);

        } else {

            out.write("<h1>" + "Sorry username or password error!" + "</h1>");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
            requestDispatcher.include(req, resp);

        }

        out.close();

    }

}
