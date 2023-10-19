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

public class MenuUsuarios extends AnchorPane {
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
    private Group GLogout;
    public MenuUsuarios(@NamedArg("Inicial_option") String Inicial_option_) throws IOException {

        this.Inicial_option = Menu_Option.valueOf(Inicial_option_);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuUsuarios.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        }
        catch (IOException e) {
            System.out.println("Error Cargar Menu "+e.getCause()+e.getMessage());
            throw new RuntimeException(e);

        }
        catch (RuntimeException re){
            System.out.println(re.getMessage());
        }
        configurar_eventos();
        Update_Menu(this.Inicial_option);

    }
    public void configurar_eventos(){
        GRequest.onMouseClickedProperty().set(event -> G_Click(event));
        GRequest_Request.onMouseClickedProperty().set(event -> G_Click(event));
        GRequest_License.onMouseClickedProperty().set(event -> G_Click(event));
        GLogout.onMouseClickedProperty().set(mouseEvent -> logout(mouseEvent));
    }
    protected void logout(MouseEvent ev){
        try {
            Econatura.getStage().setResizable(false);
            Econatura.getStage().setHeight(400);
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
            System.out.println(GroupClicked.getId());
            go_to_fxml(Menu_Option.valueOf(GroupClicked.getId().substring(1)));
        }
        catch (Exception Ex){
            System.out.println(Ex.getMessage());
            Ex.printStackTrace();
        }
    }
    protected void go_to_fxml(Menu_Option option) throws IOException {
        Econatura.getStage().setResizable(false);
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);
        switch(option){
            case Request: case Request_Request:
                try {
                    Econatura.setRoot("usuarioSolicitudes");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case Request_License:
                try {
                    Econatura.setRoot("usuarioLicencias");
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
                break;
            case Request_License:
                RRequest.setFill(Color.web("#EEF1F4",1.0));
                RRequest_Request.setFill(Color.web("#FFFFFF",0));
                RRequest_License.setFill(Color.web("#EEF1F4",1));
                break;

        }

    }
}
