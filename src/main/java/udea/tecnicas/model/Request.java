package udea.tecnicas.model;

import java.time.LocalDateTime;

public class Request {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(String id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public State.stateRequest getState() {
        return state;
    }

    public void setState(State.stateRequest state) {
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
    private String id_Cliente;

    public Request() {
    }

    public Request(String id, String id_Cliente, Resource resource, LocalDateTime date, State.stateRequest state, float estimated_impact, float necessary_recovery) {
        this.id = id;
        this.id_Cliente = id_Cliente;
        this.resource = resource;
        this.date = date;
        this.state = state;
        this.estimated_impact = estimated_impact;
        this.necessary_recovery = necessary_recovery;
    }

    private Resource resource;
    private LocalDateTime date;
    private State.stateRequest state;
    private float estimated_impact;
    private float necessary_recovery;
}
