package by.gstu.DAO;

import by.gstu.Entities.Lesson;

public interface LessonDAO {
    int insertLesson(Lesson lesson);
    boolean deleteLesson(Lesson lesson);
    boolean updateLesson(Lesson lesson);
    Lesson findLesson(int id);
    //List<Lesson> findLessons(String name);
}
