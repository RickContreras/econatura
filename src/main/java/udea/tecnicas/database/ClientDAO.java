package udea.tecnicas.database;

import udea.tecnicas.Constants;
import udea.tecnicas.model.Client;
import udea.tecnicas.model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    public void insert(Client client){
        try {
            Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(
                    "insert into Client (fullname,document,type) values (?, ?, ?)"
            );
            statement.setString(1, client.getFullName());
            statement.setString(2, client.getCC());
            statement.setString(3, client.getType().name());
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DatabaseException("Failed inserting client", e);
        }
    }

    public List<Client> findAll() {
        try {
            Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(
                    "select * from Client"
            );
            ResultSet rs = statement.executeQuery();
            return serialize(rs);
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
            return serialize(rs);
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
        }
        return clients;
    }
}
