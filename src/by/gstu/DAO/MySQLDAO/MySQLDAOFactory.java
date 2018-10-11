package by.gstu.DAO.MySQLDAO;

import by.gstu.DAO.ChildGroupDAO;
import by.gstu.DAO.ChildrenDAO;
import by.gstu.DAO.DAOFactory;
import by.gstu.DAO.LessonDAO;

import java.sql.*;

public class MySQLDAOFactory extends DAOFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/child_account";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection createConnection() {
        //Should return connection pull

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return  null;
    }

    @Override
    public ChildrenDAO getChildrenDAO() {
        return new MySQLChildrenDAO();
    }

    @Override
    public ChildGroupDAO getChildGroupDAO() {
        return new MySQLChildGroupDAO();
    }

    @Override
    public LessonDAO getLessonDAO() {
        return new MySQLLessonDAO();
    }
}
