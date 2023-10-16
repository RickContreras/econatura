package udea.tecnicas.model;

import java.util.HashMap;

public class Client extends Person{
    public Client( String fullName, String CC, Type.PersonType type) {
        super( fullName, CC, type);
    }
    public Client(String doc,String name){
        super(name,doc);
    }
    public Client(){
        super();
    }

    public HashMap<String, License> getLicenses() {
        return Licenses;
    }

    public void setLicenses(HashMap<String, License> licenses) {
        Licenses = licenses;
    }

    public HashMap<String, Request> getRequests() {
        return Requests;
    }

    public void setRequests(HashMap<String, Request> requests) {
        Requests = requests;
    }

    private HashMap<String,License> Licenses;
    private HashMap<String,Request> Requests;
}
