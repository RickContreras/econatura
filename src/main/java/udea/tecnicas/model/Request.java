package udea.tecnicas.model;

import java.time.LocalDate;

public class Request {
    public String nombreRecurso;
    public String municipio;
    public String departamento;
    private LocalDate date;
    private State.stateRequest state;
    private double estimatedImpact;
    private double necessaryRecovery;

    public void setNombreRecurso(String nombreRecurso){
        this.nombreRecurso = nombreRecurso;
    }

    public String getNombreRecurso(){
        return nombreRecurso;
    }

    public void setMunicipio(String municipio){
        this.municipio = municipio;
    }

    public void setDepartamento(String departamento){
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


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public State.stateRequest getState() {
        return state;
    }

    public void setState(State.stateRequest state) {
        this.state = state;
    }

    public double getEstimatedImpact() {
        return estimatedImpact;
    }

    public void setEstimatedImpact(double estimatedImpact) {
        this.estimatedImpact = estimatedImpact;
    }

    public double getNecessaryRecovery() {
        return necessaryRecovery;
    }

    public void setNecessaryRecovery(double necessaryRecovery) {
        this.necessaryRecovery = necessaryRecovery;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    private String id;
    private Client client;

    public Request() {
    }

    public Request(String id, Client client, LocalDate date, State.stateRequest state, String nombreRecurso, String municipio, String departamento, float estimatedImpact, float necessaryRecovery) {
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

    public String toString() {
        return this.id;
    }
}
