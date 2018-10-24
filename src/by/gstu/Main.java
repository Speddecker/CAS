/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 24.11.2018
 *
 */

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
            LessonDAO lessonDAO = mysqlFactory.getLessonDAO();

            Lesson lesson1 = new Lesson(3, "ТРПОСУ", LocalDate.of(2018, 10, 20));
            Lesson lesson2 = new Lesson(4, "ИОСУ", LocalDate.of(2018, 10, 21));

            lessonDAO.insertLesson(lesson1);
            lessonDAO.insertLesson(lesson2);

            for (Lesson lesson : lessonDAO.getAllLessons()) {
                System.out.println(lesson);
            }

        } catch (NullPointerException e) {
            System.out.println("Подходящей информации не найдено!");
        }
    }
}
