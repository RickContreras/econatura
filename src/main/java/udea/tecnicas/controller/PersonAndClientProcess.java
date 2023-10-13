package udea.tecnicas.controller;

import udea.tecnicas.model.Client;
import udea.tecnicas.model.Person;

import java.util.HashMap;

public class PersonAndClientProcess {
    public static Boolean PersonExist(String n){
        HashMap<String, Client> clients = Database.GetClients();
        return(clients.containsKey(n));
    }
}
