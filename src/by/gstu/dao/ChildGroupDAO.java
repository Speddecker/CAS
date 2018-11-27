/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 16.11.2018
 *
 */

package by.gstu.DAO;

import by.gstu.Entities.ChildGroup;

import java.util.List;

public interface ChildGroupDAO {

    /**
     * Method that create new record in database
     * @param childGroup Full-filled instance of child group class
     * @return Status about success of inserting
     */
    boolean insertChildGroup(ChildGroup childGroup);

    /**
     * Method that delete new record in database
     * @param childGroup Full-filled instance of child group class
     * @return Status about success of deleting
     */
    boolean deleteChildGroup(ChildGroup childGroup);

    /**
     * Method that update new record in database
     * @param childGroup Full-filled instance of child group class
     * @return Status about success of updating
     */
    boolean updateChildGroup(ChildGroup childGroup);

    /**
     * Method which return instance of children group class, if record exist in database
     * @param id identificator of record in database
     * @return Child group instance
     */
    ChildGroup findChildGroup(int id);

    /**
     * Method for getting all records of records from database
     * @return List with children groups instances
     */
    List<ChildGroup> getAllChildGroups();
}
