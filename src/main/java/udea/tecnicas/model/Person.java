package udea.tecnicas.model;

public class Person {
    private String id;
    private String fullName;
    private int document;
    private Type.PersonType type;

    public Person(String id,String fullName, int CC) {
        this.fullName = fullName;
        this.document = CC;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCC() {
        return document;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    protected void setCC(int CC) {
        this.document = CC;
    }
}
