package udea.tecnicas.database;

import udea.tecnicas.Constants;
import udea.tecnicas.model.Client;
import udea.tecnicas.model.Request;
import udea.tecnicas.model.Resource;
import udea.tecnicas.model.Type;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {
    public void insert(Request request){
        if(request.getClient()==null){
            throw new DatabaseException("Cliente no puede ser nulo");
        }
        if(request.getDate()==null){
            throw new DatabaseException("Fecha no puede ser nula");
        }
        if(request.getState()==null){
            throw new DatabaseException("State no puede ser nula");
        }
        try{
            Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(
                    "insert into Request (id_cliente, date, state, estimated_impact, necessary_recovery, nombre_recurso, municipio, departamento) values (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, request.getClient().getCC());
            statement.setString(2, request.getDate().format(DateTimeFormatter.ISO_DATE));
            statement.setString(3, request.getState().toString());;
            statement.setDouble(4, request.getEstimatedImpact());
            statement.setDouble(5, request.getNecessaryRecovery());
            statement.setString(6, request.getNombreRecurso());
            statement.setString(7, request.getMunicipio());
            statement.setString(8, request.getDepartamento());
            statement.executeUpdate();
            statement.close();

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public List<Request> findByClientDocument(String document){
        try {
            Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(
                    "select * from Request where document = ?"
            );
            statement.setString(1, document);
            ResultSet rs = statement.executeQuery();
            List<Request> requests = serialize(rs);
            statement.close();
            return requests;
        }catch (SQLException e){
            throw new DatabaseException("Failed getting information about requests", e);
        }
    }
    public List<Request>  findAll() {
        try {
            Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(
                    "select * from Request"
            );
            ResultSet rs = statement.executeQuery();
            List<Request> requests = serialize(rs);
            statement.close();
            return requests;
        } catch(SQLException e){
            throw new DatabaseException("Failed getting information about requests", e);
        }
    }


    private List<Request> serialize(ResultSet rs) throws SQLException {
        List<Request> requests = new ArrayList<>();
        while (rs.next()) {
            Request request = new Request();
            request.setId(rs.getString("fullname"));
            Client client = new Client();
            //Resource resource = new Resource();
            client.setCC("");
            request.setClient(client);
            //request.setResource(rs.getString("resource"));
            request.setEstimatedImpact(rs.getFloat("estimatedImpact"));
            requests.add(request);
        }
        return requests;
    }
}

