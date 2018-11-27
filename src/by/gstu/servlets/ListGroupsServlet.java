package by.gstu.servlets;

import by.gstu.dao.ChildGroupDAO;
import by.gstu.dao.DAOFactory;
import by.gstu.entities.ChildGroup;
import by.gstu.entities.Children;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list_groups")
public class ListGroupsServlet extends HttpServlet {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private ChildGroupDAO childGroupDAO = factory.getChildGroupDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("views/list_groups.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        List<ChildGroup> childGroupList = childGroupDAO.getAllChildGroups();
        String json = gson.toJson(childGroupList);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
