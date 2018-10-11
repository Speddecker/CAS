package by.gstu.DAO.MySQLDAO;

import by.gstu.DAO.ChildrenDAO;
import by.gstu.Entities.Children;

import java.sql.*;

public class MySQLChildrenDAO implements ChildrenDAO {
    private static Connection connection;

    public MySQLChildrenDAO() {
        connection = MySQLDAOFactory.createConnection();
    }

    @Override
    public int insertChildren() {
        return 0;
    }

    @Override
    public boolean deleteChildren() {
        return false;
    }

    @Override
    public boolean updateChildren() {
        return false;
    }

    @Override
    public Children findChildren(int id) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM childrens WHERE id=?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                String thirdName = resultSet.getString("third_name");
                Date dateOfBirth = resultSet.getDate("date_of_birth");

                return new Children(id, firstName, secondName, thirdName, dateOfBirth);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
