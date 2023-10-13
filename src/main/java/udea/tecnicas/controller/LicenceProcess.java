package udea.tecnicas.controller;

import udea.tecnicas.model.License;
import udea.tecnicas.model.Request;
import udea.tecnicas.model.Resource;
import udea.tecnicas.model.State;

import java.time.LocalDateTime;

public class LicenceProcess {
    public static License convertRequest(Request r){
        return new License();
    }
    public static Boolean validateLicense(Request r){
        return true;
    }

    public Boolean GenerateRequest(String id,String clientId,String ResourceId,String state,Float stimated_impact,Float necessary_recovery){
        try {
            Database.add_Request(new Request(id, Database.GetClientByDocument(clientId), Database.GetResourceById(ResourceId), LocalDateTime.now(), State.stateRequest.valueOf(state), stimated_impact, necessary_recovery));
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
