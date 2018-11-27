/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 16.11.2018
 *
 */

package by.gstu.Entities;


/**
 * Class that describes chidren group entity
 *
 * @Author Stanislav Ivanov
 */
public class ChildGroup {
    private int id;
    private String name;
    private String educatorFullName;

    /**
     * Constructor for full-filled class instance
     * @param id unique identificator
     * @param name Child group name
     * @param educatorFullName Educator full name
     */
    public ChildGroup(int id, String name, String educatorFullName) {
        this.id = id;
        this.name = name;
        this.educatorFullName = educatorFullName;
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

    public String getEducatorFullName() {
        return educatorFullName;
    }

    public void setEducatorFullName(String educatorFullName) {
        this.educatorFullName = educatorFullName;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nНазвание группы: " + name + "\nВоспитатель: " + educatorFullName + "\n";
    }
}
