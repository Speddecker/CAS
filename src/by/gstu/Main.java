package by.gstu;

import by.gstu.DAO.ChildrenDAO;
import by.gstu.DAO.DAOFactory;
import by.gstu.Entities.Children;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

        try {
            ChildrenDAO childrenDAO = mysqlFactory.getChildrenDAO();

//            Children children = new Children(1,"Стас", "Пупкин", "Волоторович",
//                    LocalDate.of(2002,1,22), "Силичи");

//            System.out.println(childrenDAO.insertChildren(children));
//            System.out.println(childrenDAO.deleteChildren(children));

            List<Children> childrenList = childrenDAO.getAllChildrens();

            for (Children children: childrenList) {
                System.out.println(children);
            }

            Children children = childrenList.get(2);

            children.setFirstName("Владимир");
            children.setSecondName("Валерьянов");
            children.setThirdName("Копатыч");
            children.setDateOfBirth(LocalDate.of(1980,7,11));

            childrenDAO.updateChildren(children);

        } catch (NullPointerException e) {
            System.out.println("Подходящей информации не найдено!");
        }
    }
}
