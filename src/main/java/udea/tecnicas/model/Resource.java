package udea.tecnicas.model;

public class Resource {
    private String name;
    private String lo;
    private String la;
    private Type.ResourceType type;
    private float capacity;
    private String id;

    public Resource() {
    }

    public String getName() {
        return name;
    }

    public Resource(String id,String name, String lo, String la, Type.ResourceType type, float capacity) {
        this.id = id;
        this.name = name;
        this.lo = lo;
        this.la = la;
        this.type = type;
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLo() {
        return lo;
    }

    public void setLo(String lo) {
        this.lo = lo;
    }

    public String getLa() {
        return la;
    }

    public void setLa(String la) {
        this.la = la;
    }

    public Type.ResourceType getType() {
        return type;
    }

    public void setType(Type.ResourceType type) {
        this.type = type;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }
}
