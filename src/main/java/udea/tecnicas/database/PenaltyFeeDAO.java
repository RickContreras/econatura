package udea.tecnicas.database;

import udea.tecnicas.Constants;
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

    private List<PenaltyFee> serialize(ResultSet rs) throws SQLException {
        List<PenaltyFee> fees = new ArrayList<>();
        while(rs.next()){
            PenaltyFee fee = new PenaltyFee();
            fee.setReason(rs.getString("reason"));
            fee.setValue(rs.getFloat("value"));
            fee.setIdLicense(String.valueOf(rs.getInt("id_license")));
        };
        return fees;
    }
}
