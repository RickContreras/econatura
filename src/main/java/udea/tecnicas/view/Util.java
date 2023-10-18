package udea.tecnicas.view;

import udea.tecnicas.model.Request;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<RequestString> convertRequestToRequestString(List<Request> lr){
        ArrayList<RequestString> nlr= new ArrayList<>();
        lr.forEach((r)->{
            nlr.add(new RequestString(r.getId(),r.getClient().getCC(),r.getDate().toLocalDate().atStartOfDay(), r.getState().toString(), r.getNombreRecurso(), r.getMunicipio(), r.getDepartamento(), r.getEstimatedImpact(),r.getNecessaryRecovery()));
        });
        return nlr;
    }
}
