package udea.tecnicas.model;

import java.util.HashMap;
import java.util.List;

public class Client extends Person{
    public Client(String fullName, String CC, Type.PersonType type) {
        super( fullName, CC, type);
    }
    public Client(String doc,String name){
        super(name,doc);
    }
    public Client(){
        super();
    }
    public List<License> licenses;
    public List<Request> requests;
    public List<License> getLicenses(List<License> licenses) {
         this.licenses = licenses;
         return licenses;
    }

    public void setLicenses(HashMap<String, License> licenses) {
        Licenses = licenses;
    }

    public List<Request> getRequests(List<Request> requests) {
        this.requests = requests;
        return requests;
    }

    public void setRequests(HashMap<String, Request> requests) {
        Requests = requests;
    }

    private HashMap<String,License> Licenses;
    private HashMap<String,Request> Requests;
}
