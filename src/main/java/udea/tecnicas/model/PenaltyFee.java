package udea.tecnicas.model;

public class PenaltyFee {
    public String getId() {
        return id;
    }

    public String getId_license() {
        return id_license;
    }

    public String getReason() {
        return Reason;
    }

    public float getValue() {
        return value;
    }

    public boolean isState() {
        return state;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId_license(String id_license) {
        this.id_license = id_license;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public PenaltyFee(){

    }
    public PenaltyFee(String id, String id_license, String reason, float value, boolean state) {
        this.id = id;
        this.id_license = id_license;
        Reason = reason;
        this.value = value;
        this.state = state;
    }

    private String id;
    private String id_license;
    private String Reason;
    private float value;
    private boolean state;
}
