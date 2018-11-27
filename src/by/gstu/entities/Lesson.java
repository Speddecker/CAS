/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 16.11.2018
 *
 */

package by.gstu.Entities;

import java.time.LocalDate;


/**
 * Class that describes lesson entity
 *
 * @Author Stanislav Ivanov
 */
public class Lesson {
    private int id;
    private String name;
    private LocalDate classDate;

    /**
     * Constructor for create full-filled instance of class
     * @param id unique identificator
     * @param name lesson name
     * @param classDate
     */
    public Lesson(int id, String name, LocalDate classDate) {
        this.id = id;
        this.name = name;
        this.classDate = classDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getClassDate() {
        return classDate;
    }

    public void setClassDate(LocalDate classDate) {
        this.classDate = classDate;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nНазвание учебного предмета: " + name + "\nВремя проведения занятия: " + classDate + "\n";
    }
}
