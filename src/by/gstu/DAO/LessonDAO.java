/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 16.11.2018
 *
 */

package by.gstu.DAO;

import by.gstu.Entities.Lesson;

import java.util.List;

public interface LessonDAO {

    /**
     * Method for creating new record in database
     * @param lesson Full-filled instance of lesson class
     * @return Status about success of inserting
     */
    boolean insertLesson(Lesson lesson);

    /**
     * Method for deleting existing record in database
     * @param lesson Full-filled instance of lesson class
     * @return Status about success of deleting
     */
    boolean deleteLesson(Lesson lesson);

    /**
     * Method for updating existing record in database
     * @param lesson Full-filled instance of lesson class
     * @return Status about success of updating
     */
    boolean updateLesson(Lesson lesson);

    /**
     * Method which return instance of lesson class, if record exist in database
     * @param id identificator of record in database
     * @return Lesson instance
     */
    Lesson findLesson(int id);

    /**
     * Method for getting all records of records from database
     * @return List with lessons instances
     */
    List<Lesson> getAllLessons();
}
