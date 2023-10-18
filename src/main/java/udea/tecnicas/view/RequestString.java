package udea.tecnicas.view;

import udea.tecnicas.model.Resource;
import udea.tecnicas.model.State;

import java.time.LocalDateTime;

public class RequestString {
    public String nombreRecurso;
    public String municipio;
    public String departamento;
    private String id;
    private String id_Cliente;


    public RequestString(String id, String id_Cliente, LocalDateTime date, String state, String nombreRecurso, String municipio, String departamento, Float estimated_impact, Float necessary_recovery) {
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
