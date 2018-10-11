package by.gstu.Entities;

import java.util.Date;

public class Children {
    public Children(int id, String firstName, String secondName, String thirdName, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.dateOfBirth = dateOfBirth;
    }

    private int id;
    private String firstName;
    private String secondName;
    private String thirdName;
    private Date dateOfBirth;
    private String childGroup;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
