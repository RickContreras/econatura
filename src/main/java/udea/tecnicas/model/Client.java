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
    public List<License> getLicenses() {
         return licenses;
    }

    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    @Override
    public String toString(){
        return this.getCC();
    }

}
