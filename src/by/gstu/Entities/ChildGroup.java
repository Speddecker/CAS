package by.gstu.Entities;

public class ChildGroup {
    private int id;
    private String name;
    private String educatorFullName;

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
