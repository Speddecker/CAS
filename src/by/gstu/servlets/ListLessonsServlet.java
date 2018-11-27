package by.gstu.servlets;

import by.gstu.dao.DAOFactory;
import by.gstu.dao.LessonDAO;
import by.gstu.entities.Lesson;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list_lessons")
public class ListLessonsServlet extends HttpServlet {
    private DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private LessonDAO lessonDAO = daoFactory.getLessonDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("views/list_lessons.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Gson gson = new Gson();
        List<Lesson> lessonList = lessonDAO.getAllLessons();
        String json = gson.toJson(lessonList);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
