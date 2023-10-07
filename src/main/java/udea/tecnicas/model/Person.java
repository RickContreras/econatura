package udea.tecnicas.model;

public class Person {
    private String fullName;
    private int CC;

    public Person(String fullName, int CC) {
        this.fullName = fullName;
        this.CC = CC;
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
