/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 24.11.2018
 *
 */

package by.gstu.dao.MySQLDAO;

import by.gstu.dao.ChildGroupDAO;
import by.gstu.entities.ChildGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Implementation of ChildrenGroup data access object for mysql
 *
 * @Author Stanislav Ivanov
 */
public class MySQLChildGroupDAO implements ChildGroupDAO {
    private static Connection connection;
    private static ResourceBundle queries = ResourceBundle.getBundle("by.gstu.Queries");

    /**
     * Constructor that initialize connection
     */
    public MySQLChildGroupDAO() {
        connection = MySQLDAOFactory.getConnection();
    }

    /**
     * Method which implements insertChildGroup for interface  ChildGroupDAO
     * @param childGroup Full-filled instance of child group class
     * @return Status about success of inserting
     */
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

    /**
     * Method which implements deleteChildGroup for interface  ChildGroupDAO
     * @param childGroup Full-filled instance of child group class
     * @return Status about success of deleting
     */
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

    /**
     * Method which implements updateChildGroup for interface  ChildGroupDAO
     * @param childGroup Full-filled instance of child group class
     * @return Status about success of updating
     */
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

    /**
     * Method which implements findChildGroup for interface  ChildGroupDAO
     * @param id identificator of record in database
     * @return Full-filled instance of child group class
     */
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

    /**
     * Method which implements getAllChildGroups of interface ChildGroupDAO
     * @return List of child groups instances
     */
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
