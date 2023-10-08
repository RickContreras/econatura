package udea.tecnicas.view;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;

import java.lang.runtime.SwitchBootstraps;
import java.security.spec.RSAKeyGenParameterSpec;

public class MenuController {
    protected enum Menu_Option{
        Request,Request_Request,Request_License,Inform,Inform_Inform1,Cash,Cash_Cash,Setting_Type,Setting_Resuorce,Setting_Person
    }

    //<editor-fold desd="Inicializacion de objetos fxml">
    @FXML
    private Rectangle RRequest;
    @FXML
    private Group GRequest;
    @FXML
    private Rectangle RRequest_Request;
    @FXML
    private Group GRequest_Request;
    @FXML
    private Rectangle RRequest_License;
    @FXML
    private Group GRequest_License;
    @FXML
    private Rectangle RInform;
    @FXML
    private Group GInform;
    @FXML
    private Group GInform_Inform_1;
    @FXML
    private Rectangle RInform_Inform_1;
    @FXML
    private Rectangle RCash;
    @FXML
    private Group GCash;
    @FXML
    private Rectangle RCash_Cash;
    @FXML
    private Group GCash_Cash;
    @FXML
    private Rectangle RSettings;
    @FXML
    private Group GSettings;
    @FXML
    private Rectangle RSettings_Type;
    @FXML
    private Group GSettings_Type;
    @FXML
    private Rectangle RSettings_Resource;
    @FXML
    private Group GSettings_Resurce;
    @FXML
    private Rectangle RSettings_Person;
    @FXML
    private Group GSettings_Person;
    //</editor-fold">
    //<editor-fold desd="Inicializacion de funciones fxml">
    @FXML
    protected void GRequest_Click(MouseEvent e){
        Update_Menu(Menu_Option.Request);
    }
    @FXML
    protected void GRequest_Request_Click(MouseEvent e){

    }
    protected void GRequest_License_Click(MouseEvent e){

    }
    @FXML
    protected void GInform_Click(MouseEvent e){

    }
    @FXML
    protected void GInform_Inform_Click(MouseEvent e){

    }
    @FXML
    protected void GCash_Click(MouseEvent e){

    }
    @FXML
    protected void GCash_Cash_Click(MouseEvent e){

    }
    @FXML
    protected void GSettings_Click(MouseEvent e){

    }
    protected void GSettings_Type_Click(MouseEvent e){

    }
    protected void GSettings_Resource_Click(MouseEvent e){

    }
    protected void GSettings_Person_Click(MouseEvent e){

    }
    //</editor-fold >

    protected void Update_Menu(Menu_Option option){
        switch(option){
            case Request: case Request_Request :
                RRequest.setFill(Color.web("#EEF1F4",1.0));
        }

    }

}
