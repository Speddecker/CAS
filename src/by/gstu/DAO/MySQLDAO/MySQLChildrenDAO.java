package by.gstu.DAO.MySQLDAO;

import by.gstu.DAO.ChildrenDAO;
import by.gstu.Entities.Children;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class MySQLChildrenDAO implements ChildrenDAO {
    private static Connection connection;
    private static ResourceBundle queries = ResourceBundle.getBundle("by.gstu.Queries");

    MySQLChildrenDAO() {
        connection = MySQLDAOFactory.createConnection();
    }

    @Override
    public boolean insertChildren(Children children) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("INSERT_CHILDREN"));
            preparedStatement.setString(1, children.getFirstName());
            preparedStatement.setString(2, children.getSecondName());
            preparedStatement.setString(3, children.getThirdName());
            preparedStatement.setDate(4, java.sql.Date.valueOf(children.getDateOfBirth()));
            preparedStatement.setInt(5, 1); //TODO: Исправить на вставку правильного child_group_id
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteChildren(Children children) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("DELETE_CHILDREN_BY_ID"));
            preparedStatement.setInt(1, children.getId());

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateChildren(Children children) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("UPDATE_CHILDREN_BY_ID"));
            preparedStatement.setString(1, children.getFirstName());
            preparedStatement.setString(2, children.getSecondName());
            preparedStatement.setString(3, children.getThirdName());
            preparedStatement.setDate(4, java.sql.Date.valueOf(children.getDateOfBirth()));
            preparedStatement.setInt(5, 1); //TODO: Исправить на вставку правильного child_group_id
            preparedStatement.setInt(6, children.getId());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Children findChildren(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("GET_CHILDREN_BY_ID"));
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            String firstName = resultSet.getString("first_name");
            String secondName = resultSet.getString("second_name");
            String thirdName = resultSet.getString("third_name");
            LocalDate dateOfBirth = resultSet.getDate("date_of_birth").toLocalDate();
            String group_name = resultSet.getString("group_name");

            return new Children(id, firstName, secondName, thirdName, dateOfBirth, group_name);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Children> getAllChildrens() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("GET_ALL_CHILDRENS"));
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Children> childrenList = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                String thirdName = resultSet.getString("third_name");
                LocalDate dateOfBirth = resultSet.getDate("date_of_birth").toLocalDate();
                String group_name = resultSet.getString("group_name");

                childrenList.add(new Children(id, firstName, secondName, thirdName, dateOfBirth, group_name));
            }

            return childrenList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
