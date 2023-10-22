package udea.tecnicas.model;

public class PenaltyFee {
    public String getId() {
        return id;
    }

    public String getIdLicense() {
        return idLicense;
    }

    public String getReason() {
        return Reason;
    }

    public float getValue() {
        return value;
    }


    public void setIdLicense(String idLicense) {
        this.idLicense = idLicense;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public void setValue(float value) {
        this.value = value;
    }


    public PenaltyFee(){

    }
    public PenaltyFee(String id, String idLicense, String reason, float value) {
        this.idLicense = idLicense;
        Reason = reason;
        this.value = value;
    }
    private String id;
    private String idLicense;
    private String Reason;
    private float value;

}
