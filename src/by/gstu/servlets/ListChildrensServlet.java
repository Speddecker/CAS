package by.gstu.servlets;

import by.gstu.dao.ChildrenDAO;
import by.gstu.dao.DAOFactory;
import by.gstu.entities.Children;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/childrens")
public class ListChildrensServlet extends HttpServlet {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private ChildrenDAO childrenDAO = factory.getChildrenDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("views/childrens.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Gson gson = new Gson();
        List<Children> childrenList = childrenDAO.getAllChildrens();
        String json = gson.toJson(childrenList);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
