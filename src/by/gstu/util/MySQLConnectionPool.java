/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 24.11.2018
 *
 */

package by.gstu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Implementation of connection pool for mysql
 *
 * @Author Stanislav Ivanov
 */
public class MySQLConnectionPool implements ConnectionPool{
    private static final String URL = "jdbc:mysql://localhost:3306/child_account?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /** Instance of MySQLConnectionPool */
    private static MySQLConnectionPool instance;

    /** List of connections for pool */
    private final List<Connection> connections;

    /**
     * Constructor that initialize connections
     */
    private MySQLConnectionPool() {
        connections = Collections.synchronizedList(new LinkedList<Connection>());
    }

    /**
     * Method that return instance of this class
     * @return instance
     */
    public static MySQLConnectionPool getInstance() {
        if (instance == null) {
            instance = new MySQLConnectionPool();
        }
        return instance;
    }

    /**
     * Method that returns one connection
     * @return Connection
     */
    public Connection get() {
        if (!connections.isEmpty()) {
            return connections.remove(0);
        }
        return createNewConnection();
    }

    /**
     * Method for creating the connection to mysql database
     * @return Connection
     */
    private Connection createNewConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD); //TODO: Использовать .properties-файл
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Method for closing unused connection
     * @param connection
     */
    public void release(Connection connection) {
        //TODO: Реализовать освобождение соединений
    }
}
