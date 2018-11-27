/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 24.11.2018
 *
 */

package by.gstu;

import by.gstu.dao.ChildrenDAO;
import by.gstu.dao.DAOFactory;
import by.gstu.entities.Children;

public class Main {
    public static void main(String[] args) {
        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

        try {
            ChildrenDAO childrenDAO = mysqlFactory.getChildrenDAO();

            for(Children children : childrenDAO.getAllChildrens()) {
                System.out.println(children);
            }

        } catch (NullPointerException e) {
            System.out.println("Подходящей информации не найдено!");
        }
    }
}
