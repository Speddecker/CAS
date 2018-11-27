/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 24.11.2018
 *
 */

package by.gstu.dao.mysql;

import by.gstu.dao.ChildGroupDAO;
import by.gstu.dao.ChildrenDAO;
import by.gstu.dao.DAOFactory;
import by.gstu.dao.LessonDAO;
import by.gstu.util.ConnectionPool;
import by.gstu.util.MySQLConnectionPool;

import java.sql.*;


/**
 * Implementation of data access object factory for mysql
 *
 * @Author Stanislav Ivanov
 */
public class MySQLDAOFactory extends DAOFactory {
    private static final ConnectionPool connectionPool = MySQLConnectionPool.getInstance();

    /**
     * Method for getting connection from connection pool
     * @return Connection to database
     */
    static Connection getConnection() {
        return connectionPool.get();
    }

    /**
     * Method that provide access to database fot children information
     * @return Instance of ChildrenDAO
     */
    @Override
    public ChildrenDAO getChildrenDAO() {
        return new MySQLChildrenDAO();
    }

    /**
     * Method that provide access to database fot child group information
     * @return Instance of ChildGroupnDAO
     */
    @Override
    public ChildGroupDAO getChildGroupDAO() {
        return new MySQLChildGroupDAO();
    }

    /**
     * Method that provide access to database fot lesson information
     * @return Instance of LessonDAO
     */
    @Override
    public LessonDAO getLessonDAO() {
        return new MySQLLessonDAO();
    }
}
