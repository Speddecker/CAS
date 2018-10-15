package by.gstu.DAO.MySQLDAO;

import by.gstu.DAO.LessonDAO;
import by.gstu.Entities.Lesson;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MySQLLessonDAO implements LessonDAO {
    private static Connection connection;
    private static ResourceBundle queries = ResourceBundle.getBundle("by.gstu.Queries");

    public MySQLLessonDAO() {
        connection = MySQLDAOFactory.createConnection();
    }

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
