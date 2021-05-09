package org.diploma.servlet;

import org.diploma.dao.ConnectionDB;
import org.diploma.dao.CrudDAO;
import org.diploma.dao.PatientDAOImpl;
import org.diploma.entity.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/profileServlet"})
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();

        req.setAttribute("patient", (Patient) session.getAttribute("patient"));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("profile.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        Patient patient = (Patient) session.getAttribute("patient");

        String fullName = req.getParameter("full-name");
        String profession = req.getParameter("profession");
        String height = req.getParameter("height");
        String weight = req.getParameter("weight");
        String addressOfResidence = req.getParameter("address-of-residence");
        String addressOfWork = req.getParameter("address-of-work");

        patient.setFullName(fullName);
        patient.setProfession(profession);
        patient.setHeight(Integer.parseInt(height));
        patient.setWeight(Integer.parseInt(weight));
        patient.setAddressOfResidence(addressOfResidence);
        patient.setAddressOfWork(addressOfWork);

        session.setAttribute("patient", patient);

        CrudDAO<Patient> patientCrudDAO = new PatientDAOImpl();

        patientCrudDAO.update(patient);

        req.setAttribute("patient", patient);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("profile.jsp");
        requestDispatcher.forward(req, resp);

    }
}
