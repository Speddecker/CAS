package by.gstu.DAO.MySQLDAO;

import by.gstu.DAO.ChildGroupDAO;
import by.gstu.Entities.ChildGroup;

public class MySQLChildGroupDAO implements ChildGroupDAO {
    public MySQLChildGroupDAO() {
        //Initializing
    }

    @Override
    public int insertChildGroup() {
        return 0;
    }

    @Override
    public boolean deleteChildGroup() {
        return false;
    }

    @Override
    public boolean updateChildGroup() {
        return false;
    }

    @Override
    public ChildGroup findChildGroup(int id) {
        return null;
    }
}
