package by.gstu.servlets;

import by.gstu.dao.AcademicPerformanceDAO;
import by.gstu.dao.DAOFactory;
import by.gstu.entities.AcademicPerformance;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/academic-performance")
public class ListAcademicPerformanceServlet extends HttpServlet {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private AcademicPerformanceDAO academicPerformanceDAO = factory.getAcademicPerformanceDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("views/academic-performance.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        List<AcademicPerformance> academicPerformancesList = academicPerformanceDAO.getAllAcademicPerformance();
        String json = gson.toJson(academicPerformancesList);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
