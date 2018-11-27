package by.gstu.servlets;

import by.gstu.dao.ChildGroupDAO;
import by.gstu.dao.DAOFactory;
import by.gstu.entities.ChildGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_groups")
public class AddGroupsServlet extends HttpServlet {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private ChildGroupDAO childGroupDAO = factory.getChildGroupDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("views/add_groups.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String groupName = request.getParameter("group_name");
        String educatorFullName = request.getParameter("educator_full_name");

        ChildGroup childGroup = new ChildGroup(groupName, educatorFullName);

        childGroupDAO.insertChildGroup(childGroup);

        request.getRequestDispatcher("index.html").forward(request, response);
    }
}
