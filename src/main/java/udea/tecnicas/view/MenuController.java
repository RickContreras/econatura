package udea.tecnicas.view;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.lang.runtime.SwitchBootstraps;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.RSAOtherPrimeInfo;

public class MenuController {

    /*
    private int [] activeOption;
    private int [] olderOption;

    public void MenuController(){
        activeOption = new int[2];
        activeOption[0]=1;
        activeOption[1]=1;
        olderOption = new int[2];
        olderOption[0]=1;
        olderOption[1]=1;
    }*/
    protected enum Menu_Option{
        Request,Request_Request,Request_License,Inform,Inform_Inform_1,Cash,Cash_Cash,Settings,Settings_Type,Settings_Resource,Settings_Person
    }


    //<editor-fold desd="Inicializacion de objetos fxml">
    @FXML
    private Pane Panel1;
    @FXML
    private Pane Panel2;
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
    private Group GSettings_Resource;
    @FXML
    private Rectangle RSettings_Person;
    @FXML
    private Group GSettings_Person;
    //</editor-fold">
    //<editor-fold desd="Inicializacion de funciones fxml">
    @FXML
    protected void GRequest_Click(MouseEvent e){
        try
        {
            Group GroupClicked = (Group)e.getSource();

            System.out.println(GroupClicked.getId());
            Update_Menu(Menu_Option.valueOf(GroupClicked.getId().substring(1)));
        }
        catch (Exception Ex){
            System.out.println(Ex.getMessage());
        }
    }

    //</editor-fold >

    public MenuController(){


    }

    protected void Update_Menu(Menu_Option option){
        switch(option){
            case Request: case Request_Request :
                RRequest.setFill(Color.web("#EEF1F4",1.0));
                RRequest_Request.setFill(Color.web("#EEF1F4",1.0));
                GRequest_Request.setVisible(true);
                RRequest_License.setFill(Color.web("#FFFFFF",0.0));
                GRequest_License.setVisible(true);
                RInform.setFill(Color.web("#FFFFFF",0));
                RInform_Inform_1.setFill(Color.web("#FFFFFF",0));
                GInform_Inform_1.setVisible(false);
                RCash.setFill(Color.web("#FFFFFF",0));
                RCash_Cash.setFill(Color.web("#FFFFFF",0));
                GCash_Cash.setVisible(false);
                RSettings.setFill(Color.web("#FFFFFF",0));
                RSettings_Person.setFill(Color.web("#FFFFFF",0));
                GSettings_Person.setVisible(false);
                RSettings_Resource.setFill(Color.web("#FFFFFF",0));
                GSettings_Resource.setVisible(false);
                RSettings_Type.setFill(Color.web("#FFFFFF",0));
                GSettings_Type.setVisible(false);
                break;
            case Request_License:
                RRequest.setFill(Color.web("#EEF1F4",1.0));
                RRequest_Request.setFill(Color.web("#FFFFFF",0));
                RRequest_License.setFill(Color.web("#EEF1F4",1));
                break;
            case Inform: case Inform_Inform_1:
                RRequest.setFill(Color.web("#FFFFFF",0));
                GRequest_Request.setVisible(false);
                GRequest_License.setVisible(false);
                RInform.setFill(Color.web("#EEF1F4",1));
                RInform_Inform_1.setFill(Color.web("#EEF1F4",1));
                GInform_Inform_1.setVisible(true);
                RCash.setFill(Color.web("#FFFFFF",0));
                GCash_Cash.setVisible(false);
                RSettings.setFill(Color.web("#FFFFFF",0));
                GSettings_Person.setVisible(false);
                GSettings_Resource.setVisible(false);
                GSettings_Type.setVisible(false);
                break;
            case Cash: case Cash_Cash:
                RRequest.setFill(Color.web("#FFFFFF",0));
                GRequest_Request.setVisible(false);
                GRequest_License.setVisible(false);
                RInform.setFill(Color.web("#FFFFFF",0));
                GInform_Inform_1.setVisible(false);
                RCash.setFill(Color.web("#EEF1F4",1));
                RCash_Cash.setFill(Color.web("#EEF1F4",1));
                GCash_Cash.setVisible(true);
                RSettings.setFill(Color.web("#FFFFFF",0));
                GSettings_Person.setVisible(false);
                GSettings_Resource.setVisible(false);
                GSettings_Type.setVisible(false);
                break;
            case Settings: case Settings_Type:
                RRequest.setFill(Color.web("#FFFFFF",0));
                GRequest_Request.setVisible(false);
                GRequest_License.setVisible(false);
                RInform.setFill(Color.web("#FFFFFF",0));
                GInform_Inform_1.setVisible(false);
                RCash.setFill(Color.web("#FFFFFF",0));
                GCash_Cash.setVisible(false);
                RSettings.setFill(Color.web("#EEF1F4",1));
                RSettings_Person.setFill(Color.web("#FFFFFF",0));
                GSettings_Person.setVisible(true);
                RSettings_Resource.setFill(Color.web("#FFFFFF",0));
                GSettings_Resource.setVisible(true);
                RSettings_Type.setFill(Color.web("#EEF1F4",1));
                GSettings_Type.setVisible(true);
                break;
            case Settings_Resource:
                RSettings_Person.setFill(Color.web("#FFFFFF",0));
                RSettings_Resource.setFill(Color.web("#EEF1F4",1));
                RSettings_Type.setFill(Color.web("#FFFFFF",0));
                break;
            case Settings_Person:
                RSettings_Person.setFill(Color.web("#EEF1F4",1));
                RSettings_Resource.setFill(Color.web("#FFFFFF",0));
                RSettings_Type.setFill(Color.web("#FFFFFF",0));
                break;


        }

    }
    protected void Fill_Active_Option(){

    }

}
