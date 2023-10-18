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
    protected static void add_License(License l,Client c){
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(Constants.DATABASE_URL);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO License (id,id_client ,id_auditor,start,end,state,estimated_impact,necessary_recovery) values ('"+l.getId()+"','"+l.getId_Auditor()+"','"+l.getStart()+"','"+l.getEnd()+"','"+l.getState()+"','"+l.getEstimated_impact()+"','"+l.getNecessary_recovery()+"')";

        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    protected static HashMap<String,Client> GetClients(){
        Connection connection = null;
        HashMap<String,Client> Client_list = new HashMap<>();
        try
        {
            connection = DriverManager.getConnection(Constants.DATABASE_URL);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Client");

            while(rs.next())
            {
                Client_list.put(rs.getString("document"),new Client(rs.getString("fullname"),rs.getString("document"),Type.PersonType.valueOf(rs.getString("type"))));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return Client_list;
    }
    protected static Client GetClientByDocument(String Id){
        Connection connection = null;
        Client c = new Client();
        try
        {
            connection = DriverManager.getConnection(Constants.DATABASE_URL);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Client where Document='"+Id+"'");

            while(rs.next())
            {
                c = new Client(rs.getString("fullname"),rs.getString("document"),Type.PersonType.valueOf(rs.getString("type")));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return c;
    }
    protected static Resource GetResourceById(String Id){
        return new Resource();
    }
    protected static void add_Request(Request r){
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(Constants.DATABASE_URL);
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into Request (id,id_cliente,resource_id,date,state,estimated_impact,necessary_recovery) values('"+r.getId()+"','"+r.getIdClient()+"','"+r.getResource().getId()+"','"+ LocalDateTime.now().toString()+"','"+r.getState().toString()+"','"+r.getEstimatedImpact()+"','"+r.getNecessaryRecovery()+"')");
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
    }
   // protected static HashMap<String,Request> GetRequests(){
   //     Connection connection = null;
   //     HashMap<String,Request> r = new HashMap<>();
   //     try
   //     {
    //        connection = DriverManager.getConnection(Constants.DATABASE_URL);
   //         Statement statement = connection.createStatement();
   //         ResultSet rs = statement.executeQuery("select * from Request");

   //         while(rs.next())
   //         {
   //             r.put(rs.getString("id"),Database.GetClientByDocument(rs.getString("id_cliente")), LocalDateTime.parse(rs.getString("date")), State.stateRequest.valueOf(rs.getString("state")),Float.parseFloat(rs.getString("estimated_impact")),Float.parseFloat(rs.getString("necessary_recovery"))));
   //         }
   //     }
   //     catch(SQLException e){
   //         System.out.println(e.getMessage());
    //    }
   //     return r;
   // }
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
