package by.gstu.DAO;

import by.gstu.Entities.ChildGroup;

public interface ChildGroupDAO {
    int insertChildGroup();
    boolean deleteChildGroup();
    boolean updateChildGroup();
    ChildGroup findChildGroup(int id);
    //public List<ChildGroup> findChildGroups(String name);
}
