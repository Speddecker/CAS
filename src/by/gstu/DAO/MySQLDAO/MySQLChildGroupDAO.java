package by.gstu.DAO.MySQLDAO;

import by.gstu.DAO.ChildGroupDAO;
import by.gstu.Entities.ChildGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MySQLChildGroupDAO implements ChildGroupDAO {
    private static Connection connection;
    private static ResourceBundle queries = ResourceBundle.getBundle("by.gstu.Queries");

    public MySQLChildGroupDAO() {
        connection = MySQLDAOFactory.createConnection();
    }

    @Override
    public boolean insertChildGroup(ChildGroup childGroup) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("INSERT_GROUP"));
            preparedStatement.setString(1, childGroup.getName());
            preparedStatement.setString(2, childGroup.getEducatorFullName());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteChildGroup(ChildGroup childGroup) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("DELETE_GROUP_BY_ID"));
            preparedStatement.setInt(1,childGroup.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateChildGroup(ChildGroup childGroup) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("UPDATE_GROUP_BY_ID"));
            preparedStatement.setString(1, childGroup.getName());
            preparedStatement.setString(2, childGroup.getEducatorFullName());
            preparedStatement.setInt(3, childGroup.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ChildGroup findChildGroup(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("GET_GROUP_BY_ID"));
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            String name = resultSet.getString("name");
            String educatorFullName = resultSet.getString("educatorFullName");

            return new ChildGroup(id, name, educatorFullName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChildGroup> getAllChildGroups() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("GET_ALL_GROUPS"));
            ResultSet resultSet = preparedStatement.executeQuery();
            List<ChildGroup> childGroupList = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String educatorFullName = resultSet.getString("educatorFullName");

                childGroupList.add(new ChildGroup(id, name, educatorFullName));
            }

            return childGroupList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
