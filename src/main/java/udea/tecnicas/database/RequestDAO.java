package udea.tecnicas.database;

import udea.tecnicas.Constants;
import udea.tecnicas.model.Client;
import udea.tecnicas.model.Request;
import udea.tecnicas.model.Resource;
import udea.tecnicas.model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {
    public void insert(Request request){
        try{
            Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(
                    "insert into Request (id_cliente, resource_id, date, state, estimated_impact, necessary_recovery) values (?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, request.getClient().getCC());
            //statement.setString(2, request.getResource().getId());
            //statement.setTimestamp(3, java.sql.Timestamp.valueOf(request.getDate()));
            //statement.setString(4, request.getState().toString());
            statement.setFloat(5, request.getEstimatedImpact());
            statement.setFloat(6, request.getNecessaryRecovery());
            statement.executeUpdate();
            statement.close();

        }catch (SQLException e){
            System.out.println(e);
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

