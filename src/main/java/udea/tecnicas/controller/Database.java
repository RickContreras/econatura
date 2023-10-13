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
            connection = DriverManager.getConnection("jdbc:sqlite:data_bank.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("create table IF NOT EXISTS Employee (id string, password string, username string, first_name string , last_name string,EmployeeType string)");
            statement.executeUpdate("create table IF NOT EXISTS Client (id string, ClientType string, first_name string , last_name string)");
            statement.executeUpdate("create table IF NOT EXISTS Account (id string, client_id string, limit_per_day integer , limit_per_amount integer, overdraft integer)");
            statement.executeUpdate("create table IF NOT EXISTS Transactions (uuid string, typet string, amount integer , account_id string, datetime string)");


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
