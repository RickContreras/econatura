package udea.tecnicas.database;

import udea.tecnicas.Constants;
import udea.tecnicas.model.License;
import udea.tecnicas.model.PenaltyFee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenaltyFeeDAO {
    public void insert(PenaltyFee fee){
        String query = "insert into PenaltyFee (reason, value, id_license) values (?, ?, ?)";
        try(
            Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
            PreparedStatement statement = connection.prepareStatement(query)
        ){
            statement.setString(1, fee.getReason());
            statement.setDouble(2, fee.getValue());
            statement.setString(3, fee.getIdLicense());
            statement.executeUpdate();
        }catch (SQLException exception){
            throw new DatabaseException("No se pudo guardar la multa", exception);
        }
    }

    public List<PenaltyFee> findByDocument(String document) {
        String query = "select " +
                "f.id, f.reason, f.value, f.id_license, " +
                    "(select (" +
                        "select r.id_cliente FROM Request r where r.id = l.id_request" +
                    ") document " +
                    "from License l where f.id  = l.id " +
                ") document " +
                "from PenaltyFee f " +
                "where document = ?";

        List <PenaltyFee> fees;
        try (
                Connection connection = DriverManager.getConnection(Constants.DATABASE_URL);
                PreparedStatement statement = connection.prepareStatement(query)
        ){
            statement.setString(1, document);
            ResultSet rs = statement.executeQuery();
            fees = serialize(rs);
        } catch(SQLException e){
            throw new DatabaseException("Failed getting information about penalty fee", e);
        }
        return fees;

    }
    private List<PenaltyFee> serialize(ResultSet rs) throws SQLException {
        List<PenaltyFee> fees = new ArrayList<>();
        while(rs.next()){
            PenaltyFee fee = new PenaltyFee();
            fee.setId(rs.getInt("id"));
            fee.setReason(rs.getString("reason"));
            fee.setValue(rs.getFloat("value"));
            fee.setIdLicense(String.valueOf(rs.getInt("id_license")));
            fees.add(fee);
        };
        return fees;
    }
}
