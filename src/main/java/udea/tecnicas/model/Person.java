package udea.tecnicas.model;

public class Person {

    private String fullName;
    private String document;
    private Type.PersonType type;

    public Type.PersonType getType() {
        return type;
    }

    public void setType(Type.PersonType type) {
        this.type = type;
    }

    public Person( String fullName, String CC,String type) {
        this.fullName = fullName;
        this.document = CC;
        this.type = Type.PersonType.valueOf(type);

    }

    public Person() {
    }

    public Person(String fullName, String document) {
        this.fullName = fullName;
        this.document = document;
        this.type = Type.PersonType.NATURAL;
    }

    public Person( String fullName, String CC, Type.PersonType type) {
        this.fullName = fullName;
        this.document = CC;
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

    public void setCC(String CC) {
        this.document = CC;
    }
}
