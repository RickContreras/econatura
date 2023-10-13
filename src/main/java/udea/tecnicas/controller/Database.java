package udea.tecnicas.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import udea.tecnicas.model.*;

public class Database {

    public static void add_Client(Client c){
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:Hecatombe.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into Client (person_id) values('"+c.getId()+"')");
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    public static void add_License(License l,Client c){
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:Hecatombe.db");
            Statement statement = connection.createStatement();
            String query = "INSERT INTO License (id,id_client ,id_auditor,start,end,state,estimated_impact,necessary_recovery) values ('"+l.getId()+"','"+l.getId_Auditor()+"','"+l.getStart()+"','"+l.getEnd()+"','"+l.getState()+"','"+l.getEstimated_impact()+"','"+l.getNecessary_recovery()+"')";

        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    public static HashMap<String,Client> GetClients(){
        Connection connection = null;
        HashMap<String,Client> Client_list = new HashMap<>();
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:Hecatombe.db");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Client");

            while(rs.next())
            {
                Client_list.put(rs.getString("id"),new Client(rs.getString("id"),rs.getString("fullname"),rs.getString("documento")));
            }
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
        return Client_list;
    }
    public static HashMap<String,License> GetLicences(){
        return new HashMap<String,License>();
    }
    public static HashMap<String,PenaltyFee> GetPenaltyFees(){
        return new HashMap<String,PenaltyFee>();
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
    protected static HashMap<String,Person> GetPersonbyId(){
        return new HashMap<String,Person>();
    }
    protected static HashMap<String,Person> GetRequestbyId(){
        return new HashMap<String,Person>();
    }
    protected static HashMap<String,Resource> GetResourcebyId(){
        return new HashMap<String,Resource>();
    }
    public static void createTablesIfNotExist()
    {
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:Hecatombe.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.executeUpdate("create table IF NOT EXISTS Client (id string,fullname string, document string, type string )");
            statement.executeUpdate("create table IF NOT EXISTS License (id string, id_client string, id_auditor string , start string,end string, state string, estimated_impact string , necessary_recovery string)");
            statement.executeUpdate("create table IF NOT EXISTS PenaltyFee (id string, reason string, value real , state string)");
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
