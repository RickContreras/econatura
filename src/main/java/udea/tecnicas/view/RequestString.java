package udea.tecnicas.view;

import udea.tecnicas.model.Resource;
import udea.tecnicas.model.State;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RequestString {
    public String nombreRecurso;
    public String municipio;
    public String departamento;
    private String id;
    private String id_Cliente;

    private String state;
    private Double estimated_impact;
    private Double necessary_recovery;
    private LocalDate date;

    public RequestString(String id, String id_Cliente, LocalDate date, String state, String nombreRecurso, String municipio, String departamento, Double estimated_impact, Double necessary_recovery) {
        this.id = id;
        this.id_Cliente = id_Cliente;
        this.date = date;
        this.state = state;
        this.nombreRecurso = nombreRecurso;
        this.municipio = municipio;
        this.departamento = departamento;
        this.estimated_impact = estimated_impact;
        this.necessary_recovery = necessary_recovery;
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getEstimated_impact() {
        return estimated_impact;
    }

    public void setEstimated_impact(Double estimated_impact) {
        this.estimated_impact = estimated_impact;
    }

    public Double getNecessary_recovery() {
        return necessary_recovery;
    }

    public void setNecessary_recovery(Double necessary_recovery) {
        this.necessary_recovery = necessary_recovery;
    }

}
