package by.gstu;

import by.gstu.DAO.ChildGroupDAO;
import by.gstu.DAO.ChildrenDAO;
import by.gstu.DAO.DAOFactory;
import by.gstu.DAO.LessonDAO;
import by.gstu.Entities.ChildGroup;
import by.gstu.Entities.Children;
import by.gstu.Entities.Lesson;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

        try {

        } catch (NullPointerException e) {
            System.out.println("Подходящей информации не найдено!");
        }
    }
}
