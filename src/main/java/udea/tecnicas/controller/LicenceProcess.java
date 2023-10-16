package udea.tecnicas.controller;

import udea.tecnicas.model.License;
import udea.tecnicas.model.Request;
import udea.tecnicas.model.Resource;
import udea.tecnicas.model.State;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class LicenceProcess {
    public static License convertRequest(Request r){
        return new License();
    }
    public static Boolean validateLicense(Request r){
        return true;
    }

    public static Boolean GenerateRequest(String id,String clientId,String ResourceId,String state,Float stimated_impact,Float necessary_recovery){
        try {
            Database.add_Request(new Request(id, Database.GetClientByDocument(clientId), Database.GetResourceById(ResourceId), LocalDateTime.now(), State.stateRequest.valueOf(state), stimated_impact, necessary_recovery));
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    public static ArrayList<Request> ListRequestbyDocumentClient(String Document){
        ArrayList<Request> lr = new ArrayList<>();
        Database.GetRequests().forEach((document,request)->{
            if (request.getId_Cliente().equals(Document)){lr.add(request);}
        });
        return lr;
    }
}
