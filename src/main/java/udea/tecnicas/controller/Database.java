package udea.tecnicas.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import udea.tecnicas.model.*;

public class Database {

    public static HashMap<String,Client> GetClients(){
        return new HashMap<String,Client>();
    }
    public static HashMap<String,License> GetLicences(){
        return new HashMap<String,License>();
    }
    public static HashMap<String,PenaltyFee> GetPenaltyFees(){
        return new HashMap<String,PenaltyFee>();
    }
    public static HashMap<String,Person> GetPerson(){
        return new HashMap<String,Person>();
    }
    public static HashMap<String,Person> GetRequest(){
        return new HashMap<String,Person>();
    }
    public static HashMap<String,Resource> GetResource(){
        return new HashMap<String,Resource>();
    }
    public static HashMap<String,Client> GetClientsbyId(){
        return new HashMap<String,Client>();
    }
    public static HashMap<String,License> GetLicencesbyId(){
        return new HashMap<String,License>();
    }
    public static HashMap<String,PenaltyFee> GetPenaltyFeesbyId(){
        return new HashMap<String,PenaltyFee>();
    }
    public static HashMap<String,Person> GetPersonbyId(){
        return new HashMap<String,Person>();
    }
    public static HashMap<String,Person> GetRequestbyId(){
        return new HashMap<String,Person>();
    }
    public static HashMap<String,Resource> GetResourcebyId(){
        return new HashMap<String,Resource>();
    }
    protected static void createTablesIfNotExist()
    {
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:Hecatombe.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("create table IF NOT EXISTS Client (person_id string )");
            statement.executeUpdate("create table IF NOT EXISTS License (id string, id_cliente string, id_autor string , start string,end string, state string, estimated_impact string , necessary_recovery string)");
            statement.executeUpdate("create table IF NOT EXISTS PenaltyFee (id string, reason string, value float , state integer");
            statement.executeUpdate("create table IF NOT EXISTS Person (id string, fullname string, document string , person_type string)");
            statement.executeUpdate("create table IF NOT EXISTS Request (id string, id_cliente string, resource string , date string, state string,estimated_impact string,necessary_recovery string)");
            statement.executeUpdate("create table IF NOT EXISTS Resource (name string, lo string, la string , type string, capacity string)");


        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());

        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}
