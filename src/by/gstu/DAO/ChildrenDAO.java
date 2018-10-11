package by.gstu.DAO;

import by.gstu.Entities.Children;

public interface ChildrenDAO {
    public int insertChildren();
    public boolean deleteChildren();
    public boolean updateChildren();
    public Children findChildren(int id);
    //List<Children> findChildrens(String firstName, String secondName, String thirdName);
}
