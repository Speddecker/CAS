package by.gstu.servlets;

import by.gstu.dao.DAOFactory;
import by.gstu.dao.LessonDAO;
import by.gstu.entities.Lesson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/add_lessons")
public class AddLessonsServlet extends HttpServlet {
    private DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private LessonDAO lessonDAO = daoFactory.getLessonDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("views/add_lessons.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String lessonName = request.getParameter("lesson_name");
        LocalDate classDate = LocalDate.parse(request.getParameter("lesson_class_date"));

        Lesson lesson = new Lesson(lessonName, classDate);

        lessonDAO.insertLesson(lesson);

        request.getRequestDispatcher("index.html").forward(request, response);
    }
}
