package udea.tecnicas.model;

import java.time.LocalDate;
import java.util.HashMap;

public class License {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
    public Request getRequest() {
        return request;
    }

    public String getId_Auditor() {
        return id_Auditor;
    }

    public void setId_Auditor(String id_Auditor) {
        this.id_Auditor = id_Auditor;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
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
    private Request request;
    private String id_Auditor;
    private LocalDate start;
    private LocalDate end;
    private HashMap<String,PenaltyFee> PenaltyFees;
    private State.stateLicense state;
    private float estimated_impact;
    private float necessary_recovery;
}
