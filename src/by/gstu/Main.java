package by.gstu;

import by.gstu.DAO.ChildrenDAO;
import by.gstu.DAO.DAOFactory;

public class Main {
    public static void main(String[] args) {
        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

        ChildrenDAO childrenDAO = mysqlFactory.getChildrenDAO();

        System.out.print(childrenDAO.findChildren(1).getFirstName());
    }
}
