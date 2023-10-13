package udea.tecnicas.controller;

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
}
