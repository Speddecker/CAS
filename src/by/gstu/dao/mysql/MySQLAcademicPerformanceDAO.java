package by.gstu.dao.mysql;

import by.gstu.dao.AcademicPerformanceDAO;
import by.gstu.entities.AcademicPerformance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MySQLAcademicPerformanceDAO implements AcademicPerformanceDAO {
    private static Connection connection;
    private static ResourceBundle queries = ResourceBundle.getBundle("by.gstu.Queries");

    public MySQLAcademicPerformanceDAO() { connection = MySQLDAOFactory.getConnection(); }

    @Override
    public boolean insertAcademicPerformance(AcademicPerformance ap) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("INSERT_AP"));
            preparedStatement.setInt(0, ap.getMark());
            preparedStatement.setInt(1, ap.getLessonId());
            preparedStatement.setInt(2, ap.getChildrenId());

            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateAcademicPerformance(AcademicPerformance ap) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("UPDATE_AP_BY_ID"));
            preparedStatement.setInt(0, ap.getMark());
            preparedStatement.setInt(1, ap.getLessonId());
            preparedStatement.setInt(2, ap.getChildrenId());
            preparedStatement.setInt(3, ap.getId());

            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAcademicPerformance(AcademicPerformance ap) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("DELETE_AP_BY_ID"));
            preparedStatement.setInt(0, ap.getId());

            return  preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public AcademicPerformance findAcademicPerformance(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("GET_AP_BY_ID"));
            preparedStatement.setInt(0, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int mark = resultSet.getInt("mark");
            int lessonId = resultSet.getInt("lesson_id");
            int childrenId = resultSet.getInt("children_id");

            return new AcademicPerformance(id, mark, lessonId, childrenId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AcademicPerformance> getAllAcademicPerformance() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("GET_ALL_AP"));
            List<AcademicPerformance> apList = new ArrayList<>();

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int mark = resultSet.getInt("mark");
                int lessonId = resultSet.getInt("lesson_id");
                int childrenId = resultSet.getInt("children_id");

                apList.add(new AcademicPerformance(id, mark, lessonId, childrenId));
            }

            return apList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
