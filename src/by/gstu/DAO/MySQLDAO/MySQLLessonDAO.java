package by.gstu.DAO.MySQLDAO;

import by.gstu.DAO.LessonDAO;
import by.gstu.Entities.Lesson;

public class MySQLLessonDAO implements LessonDAO {
    public MySQLLessonDAO() {
        //Initializing
    }

    @Override
    public int insertLesson(Lesson lesson) {
        return 0;
    }

    @Override
    public boolean deleteLesson(Lesson lesson) {
        return false;
    }

    @Override
    public boolean updateLesson(Lesson lesson) {
        return false;
    }

    @Override
    public Lesson findLesson(int id) {
        return null;
    }
}
