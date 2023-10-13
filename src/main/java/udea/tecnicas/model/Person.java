package udea.tecnicas.model;

public class Person {
    private String id;
    private String fullName;
    private int CC;
    private Type.PersonType type;

    public Person(String id,String fullName, int CC) {
        this.fullName = fullName;
        this.CC = CC;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCC() {
        return CC;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    protected void setCC(int CC) {
        this.CC = CC;
    }
}
