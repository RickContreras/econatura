package udea.tecnicas.view;

import udea.tecnicas.model.Resource;
import udea.tecnicas.model.State;

import java.time.LocalDateTime;

public class RequestString {
    private String id;
    private String id_Cliente;
    private String resource;

    public RequestString(String id, String id_Cliente, String resource, LocalDateTime date, String state, Float estimated_impact, Float necessary_recovery) {
        this.id = id;
        this.id_Cliente = id_Cliente;
        this.resource = resource;
        this.date = date;
        this.state = state;
        this.estimated_impact = estimated_impact;
        this.necessary_recovery = necessary_recovery;
    }

    private LocalDateTime date;

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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Float getEstimated_impact() {
        return estimated_impact;
    }

    public void setEstimated_impact(Float estimated_impact) {
        this.estimated_impact = estimated_impact;
    }

    public Float getNecessary_recovery() {
        return necessary_recovery;
    }

    public void setNecessary_recovery(Float necessary_recovery) {
        this.necessary_recovery = necessary_recovery;
    }

    private String state;
    private Float estimated_impact;
    private Float necessary_recovery;
}
