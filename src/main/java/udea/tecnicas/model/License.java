package udea.tecnicas.model;

import java.time.LocalDateTime;
import java.util.HashMap;

public class License {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public String getId_Autor() {
        return id_Autor;
    }

    public void setId_Autor(String id_Autor) {
        this.id_Autor = id_Autor;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public HashMap<String, PenaltyFee> getPenaltyFees() {
        return PenaltyFees;
    }

    public void setPenaltyFees(HashMap<String, PenaltyFee> penaltyFees) {
        PenaltyFees = penaltyFees;
    }

    public State.stateLicense getState() {
        return state;
    }

    public void setState(State.stateLicense state) {
        this.state = state;
    }

    public float getEstimated_impact() {
        return estimated_impact;
    }

    public void setEstimated_impact(float estimated_impact) {
        this.estimated_impact = estimated_impact;
    }

    public float getNecessary_recovery() {
        return necessary_recovery;
    }

    public void setNecessary_recovery(float necessary_recovery) {
        this.necessary_recovery = necessary_recovery;
    }

    private String id;
    private String id_client;
    private String id_Autor;
    private LocalDateTime start;
    private LocalDateTime end;
    private HashMap<String,PenaltyFee> PenaltyFees;
    private State.stateLicense state;
    private float estimated_impact;
    private float necessary_recovery;
}
