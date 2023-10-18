package udea.tecnicas.model;

import java.time.LocalDateTime;

public class Request {
    public String nombreRecurso;
    public String municipio;
    public String departamento;

    public void setNombreRecurso(){
        this.nombreRecurso = nombreRecurso;
    }

    public String getNombreRecurso(){
        return nombreRecurso;
    }

    public void setMunicipio(){
        this.municipio = municipio;
    }

    public void setDepartamento(){
        this.departamento = departamento;
    }

    public String getDepartamento(){
        return departamento;
    }

    public String getMunicipio(){
        return municipio;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdClient() {
        return client.getCC();
    }
    public Client getClient() {
        return client;
    }

    public void setIdClient(Client client) {
        this.client = client;
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

    public float getEstimatedImpact() {
        return estimatedImpact;
    }

    public void setEstimatedImpact(float estimatedImpact) {
        this.estimatedImpact = estimatedImpact;
    }

    public float getNecessaryRecovery() {
        return necessaryRecovery;
    }

    public void setNecessaryRecovery(float necessaryRecovery) {
        this.necessaryRecovery = necessaryRecovery;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    private String id;
    private Client client;

    public Request() {
    }

    public Request(String id, Client client, LocalDateTime date, State.stateRequest state, String nombreRecurso, String municipio, String departamento, float estimatedImpact, float necessaryRecovery) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.nombreRecurso = nombreRecurso;
        this.state = state;
        this.municipio = municipio;
        this.departamento = departamento;
        this.estimatedImpact = estimatedImpact;
        this.necessaryRecovery = necessaryRecovery;
    }

    private LocalDateTime date;
    private State.stateRequest state;
    private float estimatedImpact;
    private float necessaryRecovery;
}
