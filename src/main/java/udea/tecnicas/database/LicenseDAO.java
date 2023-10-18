package udea.tecnicas.database;

import udea.tecnicas.Constants;
import udea.tecnicas.model.Client;
import udea.tecnicas.model.License;
import udea.tecnicas.model.Type;

import java.sql.*;
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

    public List<Client> findAll() {
        try {
            Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(
                    "select * from Client"
            );
            ResultSet rs = statement.executeQuery();
            List<Client> clients = serialize(rs);
            statement.close();
            return clients;
        } catch(SQLException e){
            throw new DatabaseException("Failed getting information about clients", e);
        }
    }

    public List<Client> findByDocument(String document) {
        try {
            Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(
                    "select * from Client where document = ?"
            );
            statement.setString(1, document);
            ResultSet rs = statement.executeQuery();
            List<Client> clients = serialize(rs);
            statement.close();
            return clients;
        } catch(SQLException e){
            throw new DatabaseException("Failed getting information about clients", e);
        }
    }

    private List<Client> serialize(ResultSet rs) throws SQLException {
        List<Client> clients = new ArrayList<>();
        while(rs.next())
        {
            Client client = new Client();
            client.setFullName(rs.getString("fullname"));
            client.setCC(rs.getString("document"));
            client.setType(Type.PersonType.valueOf(rs.getString("type")));
            clients.add(client);
        }
        return clients;
    }
}
