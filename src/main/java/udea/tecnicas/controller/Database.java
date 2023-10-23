package udea.tecnicas.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.HashMap;

import udea.tecnicas.Constants;
import udea.tecnicas.model.*;

public class Database {


    
    protected static HashMap<String,License> GetLicences(){
        return new HashMap<String,License>();
    }
    protected static HashMap<String,PenaltyFee> GetPenaltyFees(){
        return new HashMap<String,PenaltyFee>();
    }
    protected static HashMap<String,Resource> GetResource(){
        return new HashMap<String,Resource>();
    }
    protected static HashMap<String,Client> GetClientsbyId(){
        return new HashMap<String,Client>();
    }
    protected static HashMap<String,License> GetLicencesbyId(){
        return new HashMap<String,License>();
    }
    protected static HashMap<String,PenaltyFee> GetPenaltyFeesbyId(){
        return new HashMap<String,PenaltyFee>();
    }
    protected static HashMap<String,Person> GetPersonbyId(){
        return new HashMap<String,Person>();
    }
    protected static HashMap<String,Person> GetRequestbyId(){
        return new HashMap<String,Person>();
    }
    //protected static HashMap<String,Resource> GetResourcebyId(){
    //    return new HashMap<String,Resource>();
    //}

    protected static void updateClient(Client nc){
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(Constants.DATABASE_URL);
            Statement statement = connection.createStatement();
            statement.executeUpdate("update Client set fullname='"+nc.getFullName()+"',type='"+nc.getType()+"' where document="+nc.getCC());
        }
        catch(SQLException e) {
            System.out.println(e.toString());
        }
    }
}
