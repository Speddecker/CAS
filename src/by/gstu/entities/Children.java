/*
 * Creator: Ivanov Stanislav
 *
 * Last modification 16.11.2018
 *
 */

package by.gstu.entities;

import java.time.LocalDate;


/**
 * Class that describes chidren entity
 *
 * @Author Stanislav Ivanov
 */
public class Children {
    private int id;
    private String firstName;
    private String secondName;
    private String thirdName;
    private LocalDate dateOfBirth;
    private int childGroupId;

    /**
     * Constructor for full-filled class instance
     * @param id unique identificator
     * @param firstName
     * @param secondName
     * @param thirdName
     * @param dateOfBirth
     * @param childGroupId name of the child group
     */
    public Children(int id, String firstName, String secondName, String thirdName, LocalDate dateOfBirth, int childGroupId) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.dateOfBirth = dateOfBirth;
        this.childGroupId = childGroupId;
    }

    public Children(String firstName, String secondName, String thirdName, LocalDate dateOfBirth, int childGroupId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.dateOfBirth = dateOfBirth;
        this.childGroupId = childGroupId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getChildGroupId() {
        return childGroupId;
    }

    public void setChildGroup(int childGroupId) {
        this.childGroupId = childGroupId;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + "," +
                "\"firstName\":\"" + firstName +"\"," +
                "\"secondName\":\"" + secondName + "\"," +
                "\"thirdName\":\"" + thirdName + "\"," +
                "\"dateOfBirth\":\"" + dateOfBirth.toString() + "\"," +
                "\"childGroupId\":\""+ childGroupId + "\"}";
    }
}
