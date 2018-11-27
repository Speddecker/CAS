/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 24.11.2018
 *
 */

package by.gstu.dao.MySQLDAO;

import by.gstu.dao.LessonDAO;
import by.gstu.entities.Lesson;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Implementation of Lesson data access objetc for mysql
 *
 * @Author Stanislav Ivanov
 */
public class MySQLLessonDAO implements LessonDAO {
    private static Connection connection;
    private static ResourceBundle queries = ResourceBundle.getBundle("by.gstu.Queries");

    /**
     * Constructor that initialize connection
     */
    public MySQLLessonDAO() {
        connection = MySQLDAOFactory.getConnection();
    }

    /**
     * Method which implements insertLesson for interface LessonDAO
     * @param lesson Full-filled instance of lesson class
     * @return Status about success of inserting
     */
    @Override
    public boolean insertLesson(Lesson lesson) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("INSERT_LESSON"));
            preparedStatement.setString(1, lesson.getName());
            preparedStatement.setDate(2, java.sql.Date.valueOf(lesson.getClassDate()));
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method which implements deleteLesson for interface LessonDAO
     * @param lesson Full-filled instance of lesson class
     * @return Status about success of deleting
     */
    @Override
    public boolean deleteLesson(Lesson lesson) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("DELETE_LESSON_BY_ID"));
            preparedStatement.setInt(1, lesson.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method which implements updateLesson for interface LessonDAO
     * @param lesson Full-filled instance of lesson class
     * @return Status about success of updating
     */
    @Override
    public boolean updateLesson(Lesson lesson) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("UPDATE_LESSON_BY_ID"));
            preparedStatement.setString(1, lesson.getName());
            preparedStatement.setDate(2, java.sql.Date.valueOf(lesson.getClassDate()));
            preparedStatement.setInt(3, lesson.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method which implements findLesson for interface LessonDAO
     * @param id identificator of record in database
     * @return Full-filled instance of lesson class
     */
    @Override
    public Lesson findLesson(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("GET_LESSON_BY_ID"));
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            String name = resultSet.getString("name");
            LocalDate classDate = resultSet.getDate("class_date").toLocalDate();

            return new Lesson(id, name, classDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method which implements getAllLessons of interface LessonsDAO
     * @return List of lesson class instances
     */
    @Override
    public List<Lesson> getAllLessons() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("GET_ALL_LESSONS"));
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Lesson> lessonList = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate classDate = resultSet.getDate("class_date").toLocalDate();

                lessonList.add(new Lesson(id, name, classDate));
            }

            return lessonList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
