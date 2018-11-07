/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 24.11.2018
 *
 */

package by.gstu.DAO.MySQLDAO;

import by.gstu.DAO.ChildrenDAO;
import by.gstu.Entities.Children;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;


/**
 * Implementation of Children data access object for mysql
 *
 * @Author Stanislav Ivanov
 */
public class MySQLChildrenDAO implements ChildrenDAO {
    private static Connection connection;
    private static ResourceBundle queries = ResourceBundle.getBundle("by.gstu.Queries");

    /**
     * Constructor that initialize connection
     */
    MySQLChildrenDAO() {
        connection = MySQLDAOFactory.getConnection();
    }

    /**
     * Method which implements insertChildren for interface  ChildrenDAO
     * @param children Full-filled instance of children class
     * @return Status about success of inserting
     */
    @Override
    public boolean insertChildren(Children children) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("INSERT_CHILDREN"));
            preparedStatement.setString(1, children.getFirstName());
            preparedStatement.setString(2, children.getSecondName());
            preparedStatement.setString(3, children.getThirdName());
            preparedStatement.setDate(4, java.sql.Date.valueOf(children.getDateOfBirth()));
            preparedStatement.setInt(5, children.getChildGroupId());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method which implements deleteChildren for interface ChildrenDAO
     * @param children Full-filled instance of children class
     * @return Status about success of deleting
     */
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

    /**
     * Method which implements updateChildren for interface ChildrenDAO
     * @param children Full-filled instance of children class
     * @return Status about success of updating
     */
    @Override
    public boolean updateChildren(Children children) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.getString("UPDATE_CHILDREN_BY_ID"));
            preparedStatement.setString(1, children.getFirstName());
            preparedStatement.setString(2, children.getSecondName());
            preparedStatement.setString(3, children.getThirdName());
            preparedStatement.setDate(4, java.sql.Date.valueOf(children.getDateOfBirth()));
            preparedStatement.setInt(5, children.getChildGroupId());
            preparedStatement.setInt(6, children.getId());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method which implements findChildren for interface ChildrenDAO
     * @param id identificator of record in database
     * @return Full-filled instance of children class
     */
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
            int childGroupId = resultSet.getInt("child_groups_id");

            return new Children(id, firstName, secondName, thirdName, dateOfBirth, childGroupId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method which implements getAllChildrens of interface ChildrensDAO
     * @return List of children class instances
     */
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
                int childGroupId = resultSet.getInt("child_groups_id");

                childrenList.add(new Children(id, firstName, secondName, thirdName, dateOfBirth, childGroupId));
            }

            return childrenList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
