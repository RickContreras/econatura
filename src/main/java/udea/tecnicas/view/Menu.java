package udea.tecnicas.view;

import javafx.beans.NamedArg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class Menu extends AnchorPane {
    protected enum Menu_Option{
        Request,Request_Request,Request_License,Inform,Inform_Inform_1,Cash,Cash_Cash,Settings,Settings_Type,Settings_Resource,Settings_Person
    }
    private final Menu_Option Inicial_option;

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
    @FXML
    private Group GLogout;
    public Menu(@NamedArg("Inicial_option") String Inicial_option_) throws IOException {
        this.Inicial_option = Menu_Option.valueOf(Inicial_option_);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        configurar_eventos();
        Update_Menu(this.Inicial_option);

    }
    public void configurar_eventos(){
        GRequest.onMouseClickedProperty().set(event -> G_Click(event));
        GRequest_Request.onMouseClickedProperty().set(event -> G_Click(event));
        GRequest_License.onMouseClickedProperty().set(event -> G_Click(event));
        GInform.onMouseClickedProperty().set(event -> G_Click(event));
        GInform_Inform_1.onMouseClickedProperty().set(event -> G_Click(event));
        GCash.onMouseClickedProperty().set(event -> G_Click(event));
        GCash_Cash.onMouseClickedProperty().set(event -> G_Click(event));
        GSettings.onMouseClickedProperty().set(event -> G_Click(event));
        GSettings_Type.onMouseClickedProperty().set(event -> G_Click(event));
        GSettings_Resource.onMouseClickedProperty().set(event -> G_Click(event));
        GSettings_Person.onMouseClickedProperty().set(event -> G_Click(event));
        GLogout.onMouseClickedProperty().set(mouseEvent -> logout(mouseEvent));
    }
    protected void logout(MouseEvent ev){
        try {
            Econatura.getStage().setResizable(false);
            Econatura.getStage().setHeight(420);
            Econatura.getStage().setWidth(800);
            Econatura.setRoot("login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected void G_Click(MouseEvent e){
        try
        {
            Group GroupClicked = (Group)e.getSource();
            go_to_fxml(Menu_Option.valueOf(GroupClicked.getId().substring(1)));
        }
        catch (Exception Ex){
            System.out.println(Ex.getMessage());
        }
    }
    protected void go_to_fxml(Menu_Option option) throws IOException {
        Econatura.getStage().setResizable(false);
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);
        switch(option){
            case Request: case Request_Request:
                try {
                    Econatura.setRoot("FuncionarioSolicitudes");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case Request_License:
                try {
                    Econatura.setRoot("FuncionarioSolicitudesLicencias");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case Inform: case Inform_Inform_1:
                try {
                    Econatura.setRoot("FuncionarioInformes");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case Cash: case Cash_Cash:
                try {
                    Econatura.setRoot("FuncionarioCaja");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case Settings: case Settings_Type:
                try {
                    Econatura.setRoot("FuncionarioSettingsType");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case Settings_Resource:
                try {
                    Econatura.setRoot("FuncionarioSettingsResource");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case Settings_Person:
                try {
                    Econatura.setRoot("FuncionarioSettingsPerson");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;


        }
    }
    protected void Update_Menu(Menu_Option option) throws IOException {
        switch(option){
            case Request: case Request_Request:
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
                GCash_Cash.setVisible(false);
                GInform_Inform_1.setVisible(false);
                GCash_Cash.setVisible(false);
                GSettings_Resource.setVisible(false);
                GSettings_Person.setVisible(false);
                GSettings_Type.setVisible(false);
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
                GInform_Inform_1.setVisible(false);
                GCash_Cash.setVisible(false);
                GRequest_Request.setVisible(false);
                GRequest_License.setVisible(false);
                RSettings_Person.setFill(Color.web("#FFFFFF",0));
                RSettings_Resource.setFill(Color.web("#EEF1F4",1));
                RSettings_Type.setFill(Color.web("#FFFFFF",0));
                break;
            case Settings_Person:
                GCash_Cash.setVisible(false);
                GInform_Inform_1.setVisible(false);
                GRequest_Request.setVisible(false);
                GRequest_License.setVisible(false);
                RSettings_Person.setFill(Color.web("#EEF1F4",1));
                RSettings_Resource.setFill(Color.web("#FFFFFF",0));
                RSettings_Type.setFill(Color.web("#FFFFFF",0));
                break;


        }

    }
}
