package udea.tecnicas.view;

import udea.tecnicas.model.Request;

import java.util.ArrayList;

public class Util {
    public static ArrayList<RequestString> convertRequestToRequestString(ArrayList<Request> lr){
        ArrayList<RequestString> nlr= new ArrayList<>();
        lr.forEach((r)->{
            nlr.add(new RequestString(r.getId(),r.getCliente().getCC(),r.getResource().getName(),r.getDate(),r.getState().toString(),r.getEstimated_impact(),r.getNecessary_recovery()));
        });
        return nlr;
    }
}
