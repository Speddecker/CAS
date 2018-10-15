package by.gstu.DAO;

import by.gstu.Entities.ChildGroup;

import java.util.List;

public interface ChildGroupDAO {
    boolean insertChildGroup(ChildGroup childGroup);
    boolean deleteChildGroup(ChildGroup childGroup);
    boolean updateChildGroup(ChildGroup childGroup);
    ChildGroup findChildGroup(int id);
    List<ChildGroup> getAllChildGroups();
}
