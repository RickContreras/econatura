package udea.tecnicas.database;

import udea.tecnicas.Constants;
import udea.tecnicas.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LicenseDAO {
    public void insert(License license){
        if (license.getRequest() == null || license.getRequest().getId() == null ) {
            throw new DatabaseException("Solicitud asociada no es valida");
        }
        if (license.getState() == null ) {
            throw new DatabaseException("Estado de la licencia no es valido");
        }
        if (license.getStart() == null ) {
            throw new DatabaseException("Fecha de inicio no valida");
        }
        if (license.getEnd() == null ) {
            throw new DatabaseException("Fecha de fin no valida");
        }
        try {
            Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO License (id_request,id_auditor,\"start\",\"end\",state)" +
                            " VALUES (?,?,?,?,?);"
            );
            statement.setString(1, license.getRequest().getId());
            statement.setString(2, license.getId_Auditor());
            statement.setString(3, license.getStart().format(DateTimeFormatter.ISO_DATE));
            statement.setString(4, license.getEnd().format(DateTimeFormatter.ISO_DATE));
            statement.setString(5, license.getState().name());
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e) {
            if(e.getErrorCode() == Constants.SQLITE_CONSTRAIN_ERROR){
                throw new DatabaseException("La licencia ya existe o la solicitud no es valida", e);
            }
            throw new DatabaseException("Fallo al intentar registrar licencia", e);
        }
    }

    public List<License> findAll() {
        try {
            Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(
                    "select l.id license_id, l.\"start\", l.\"end\", l.state license_state, " +
                            "r.id request_id, r.estimated_impact, r.necessary_recovery, r.nombre_recurso, " +
                            "r.municipio, r.departamento, r.id_cliente, r.date request_date, r.state request_state " +
                            "from License l " +
                            "inner join Request r " +
                            "on r.id = l.id_request "
            );
            ResultSet rs = statement.executeQuery();
            List<License> licenses = serialize(rs);
            statement.close();
            return licenses;
        } catch(SQLException e){
            throw new DatabaseException("Failed getting information about clients", e);
        }
    }

    public List<License> findByDocument(String document) {
        try {
            Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(
                    "select l.id license_id, l.\"start\", l.\"end\", l.state license_state, " +
                            "r.id request_id, r.estimated_impact, r.necessary_recovery, r.nombre_recurso, " +
                            "r.municipio, r.departamento, r.id_cliente, r.date request_date, r.state request_state " +
                            "from License l " +
                            "inner join Request r " +
                            "on r.id = l.id_request" +
                            "where r.id_cliente = ? "
            );
            statement.setString(1, document);
            ResultSet rs = statement.executeQuery();
            List<License> clients = serialize(rs);
            statement.close();
            return clients;
        } catch(SQLException e){
            throw new DatabaseException("Failed getting information about clients", e);
        }
    }

    private List<License> serialize(ResultSet rs) throws SQLException {
        List<License> licenses = new ArrayList<>();
        while(rs.next())
        {
            License license = new License();
            Request request = new Request();
            request.setNombreRecurso(rs.getString("nombre_recurso"));
            request.setMunicipio(rs.getString("municipio"));
            request.setDepartamento(rs.getString("departamento"));
            request.setEstimatedImpact(rs.getDouble("estimated_impact"));
            request.setNecessaryRecovery(rs.getDouble("necessary_recovery"));
            String dateString = rs.getString("request_date");
            if (dateString != null) {
                request.setDate(LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE));
            }
            String startString = rs.getString("start");
            if (startString != null) {
                request.setDate(LocalDate.parse(startString, DateTimeFormatter.ISO_DATE));
            }
            String endString = rs.getString("end");
            if (endString != null) {
                request.setDate(LocalDate.parse(endString, DateTimeFormatter.ISO_DATE));
            }
            String stateString = rs.getString("request_state");
            if (stateString != null) {
                request.setState(State.stateRequest.valueOf(stateString));
            }
            String licenseStateString = rs.getString("license_state");
            if (licenseStateString != null) {
                license.setState(State.stateLicense.valueOf(licenseStateString));
            }
            request.setId(rs.getString("request_id"));
            license.setRequest(request);

            licenses.add(license);
        }
        return licenses;
    }
}
