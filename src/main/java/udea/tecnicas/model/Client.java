package udea.tecnicas.model;

import java.util.HashMap;

public class Client extends Person{
    public Client(String id, String fullName, String CC) {
        super(id, fullName, CC);
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
