package udea.tecnicas.controller;

import udea.tecnicas.model.License;
import udea.tecnicas.model.Request;

public class LicenceProcess {
    public static License convertRequest(Request r){
        return new License();
    }
    public static Boolean validateLicense(Request r){
        return true;
    }
}
