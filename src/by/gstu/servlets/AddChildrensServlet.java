package by.gstu.servlets;

import by.gstu.dao.ChildrenDAO;
import by.gstu.dao.DAOFactory;
import by.gstu.entities.Children;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/add_childrens")
public class AddChildrensServlet extends HttpServlet {
    private DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private ChildrenDAO childrenDAO = dao.getChildrenDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("views/add_childrens.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("first_name");
        String secondName = request.getParameter("second_name");
        String thirdName = request.getParameter("third_name");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("date_of_birth"));
        int childGroupId = Integer.parseInt(request.getParameter("child_group_id"));

        Children children = new Children(firstName, secondName, thirdName, dateOfBirth, childGroupId);

        childrenDAO.insertChildren(children);

        request.getRequestDispatcher("index.html").forward(request, response);
    }
}
