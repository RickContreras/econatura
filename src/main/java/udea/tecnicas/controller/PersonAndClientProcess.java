package udea.tecnicas.controller;

import udea.tecnicas.model.Client;
import udea.tecnicas.model.Person;

import java.util.HashMap;

public class PersonAndClientProcess {
    public static Boolean PersonExist(String n){
        HashMap<String, Client> clients = Database.GetClients();
        return(clients.containsKey(n));
    }
    public static Boolean Sign(String Document,String Name){
        try{
            Client c = new Client(Document,Name);
            Database.add_Client(c);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
