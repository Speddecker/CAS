/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 16.11.2018
 *
 */

package by.gstu.DAO;

import by.gstu.Entities.Children;

import java.util.List;

public interface ChildrenDAO {

    /**
     * Method that create new record in database
     * @param children Full-filled instance of children class
     * @return Status about success of inserting
     */
    boolean insertChildren(Children children);

    /**
     * Method that delete new record in database
     * @param children Full-filled instance of children class
     * @return Status about success of deleting
     */
    boolean deleteChildren(Children children);

    /**
     * Method that update new record in database
     * @param children Full-filled instance of children class
     * @return Status about success of updating
     */
    boolean updateChildren(Children children);

    /**
     * Method which return instance of children class, if record exist in database
     * @param id identificator of record in database
     * @return Children instance
     */
    Children findChildren(int id);

    /**
     * Method for getting all records of records from database
     * @return List with children class instances
     */
    List<Children> getAllChildrens();
}
