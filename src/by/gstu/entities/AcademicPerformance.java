/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 16.11.2018
 *
 */

package by.gstu.entities;

/**
 * Class that describes academic performance entity
 *
 * @Author Stanislav Ivanov
 */
public class AcademicPerformance {
    private int id;
    private int mark;
    private int lessonId;
    private int childrenId;

    /**
     * Constructor for full-filled class instance
     * @param id
     * @param mark
     * @param lessonId
     * @param childrenId
     */
    public AcademicPerformance(int id, int mark, int lessonId, int childrenId) {
        this.id = id;
        this.mark = mark;
        this.lessonId = lessonId;
        this.childrenId = childrenId;
    }

    public AcademicPerformance(int mark, int lessonId, int childrenId) {
        this.mark = mark;
        this.lessonId = lessonId;
        this.childrenId = childrenId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getChildrenId() {
        return childrenId;
    }

    public void setChildrenId(int childrenId) {
        this.childrenId = childrenId;
    }

    @Override
    public String toString() {
        return  "{id:" + id +", mark:" + mark + ", lessonId:" + lessonId + ", childrenId:" + childrenId +"}";
    }
}
