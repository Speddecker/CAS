package by.gstu.DAO;

import by.gstu.Entities.Children;

import java.util.List;

public interface ChildrenDAO {
    boolean insertChildren(Children children);
    boolean deleteChildren(Children children);
    boolean updateChildren(Children children);
    Children findChildren(int id);
    List<Children> getAllChildrens();
}
