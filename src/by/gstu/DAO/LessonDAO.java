package by.gstu.DAO;

import by.gstu.Entities.Lesson;

import java.util.List;

public interface LessonDAO {
    boolean insertLesson(Lesson lesson);
    boolean deleteLesson(Lesson lesson);
    boolean updateLesson(Lesson lesson);
    Lesson findLesson(int id);
    List<Lesson> getAllLessons();
}
