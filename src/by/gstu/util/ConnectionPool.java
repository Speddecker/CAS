/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 24.11.2018
 *
 */

package by.gstu.util;

import java.sql.Connection;

public interface ConnectionPool {

    /**
     * Method should return connection for concrete database
     * @return connection
     */
    Connection get();

    /**
     * Method should close unused connections
     * @param connection
     */
    void release(Connection connection);
}
