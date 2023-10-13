package udea.tecnicas.model;

public class Person {
    private String id;
    private String fullName;

    public String getId() {
        return id;
    }

    private String document;
    private Type.PersonType type;

    public Type.PersonType getType() {
        return type;
    }

    public void setType(Type.PersonType type) {
        this.type = type;
    }

    public Person(String id, String fullName, String CC) {
        this.fullName = fullName;
        this.document = CC;
        this.id = id;
    }
    public Person(String id, String fullName, String CC, Type.PersonType type) {
        this.fullName = fullName;
        this.document = CC;
        this.id = id;
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCC() {
        return document;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    protected void setCC(String CC) {
        this.document = CC;
    }
}
