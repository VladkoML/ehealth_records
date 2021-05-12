package org.diploma.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import com.oreilly.servlet.MultipartRequest;
import org.diploma.dao.CrudDAO;
import org.diploma.dao.RecordDAOImpl;
import org.diploma.dao.ResultsDAOImpl;
import org.diploma.entity.Patient;
import org.diploma.entity.Record;
import org.diploma.entity.Result;

@WebServlet(name = "ResultsServlet", urlPatterns = {"/resultsServlet"})
public class ResultsServlet extends HttpServlet {

    static String Path = "/Diploma-1.0/results/";
    static String ServerPath = "/home/vlad/Apache Tomcat/apache-tomcat-9.0.45/webapps/Diploma-1.0/results";
    static String LocalPath = "/home/vlad/IdeaProjects/Practice/Diploma/src/main/webapp/results";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        Patient patient = (Patient) session.getAttribute("patient");

        CrudDAO<Result> resultCRUD = new ResultsDAOImpl();

        int id = patient.getPatientId();

        patient.setResults(resultCRUD.findAll(id));


//        File dir = new File(req.getSession().getServletContext().getRealPath("/results"));;
//        String[] files = dir.getAbsoluteFile().list();
//        List<String> list = Arrays.asList(files);

        req.setAttribute("results", patient.getResults());
//        req.setAttribute("path", Path);
//        req.setAttribute("files", list);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("results.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        Patient patient = (Patient) session.getAttribute("patient");

        MultipartRequest m = new MultipartRequest(req, ServerPath);

        String description = req.getParameter("description");

        out.write("<script type=\"text/javascript\">\n" +
                "alert(\"" + description + "\")" +
                "</script>");

        Result result = new Result(
                LocalDate.now(), Path + m.getFilesystemName("file"),
                description, m.getFilesystemName("file"), patient
        );

        CrudDAO<Result> resultsCRUD = new ResultsDAOImpl();

        resultsCRUD.save(result);

        int id = patient.getPatientId();

        patient.setResults(resultsCRUD.findAll(id));

        req.setAttribute("results", patient.getResults());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("results.jsp");
        requestDispatcher.forward(req, resp);

    }

}

