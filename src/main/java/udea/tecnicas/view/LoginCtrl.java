package udea.tecnicas.view;

import java.io.IOException;
import java.lang.runtime.SwitchBootstraps;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import udea.tecnicas.controller.PersonAndClientProcess;

public class LoginCtrl {
    @FXML
    TextField TextFieldUsuariosRegistrado;
    @FXML
    TextField TextFieldUsuariosNuevoNombre;
    @FXML
    TextField TextFieldUsuariosNuevoDocumento;
    @FXML
    Label LabelErrorLogin;
    @FXML
    Label LabelErrorSignin;
    @FXML
    private void switchToFuncionario() throws IOException {
        Econatura.setRoot("FuncionarioSolicitudes");
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);
    }
    @FXML
    private void login(){
        LabelErrorLogin.setVisible(false);
        if(PersonAndClientProcess.PersonExist(TextFieldUsuariosRegistrado.getText())){
            try{
                Econatura.SetDocumentoCliente(TextFieldUsuariosRegistrado.getText());
                switchToUsuario();
            }
            catch(IOException e){
                LabelErrorLogin.setVisible(true);
                LabelErrorLogin.setText(e.getMessage());
                System.out.println(e.getMessage()+e.getCause());
            }
        }
        else {
            LabelErrorLogin.setText("Usuario no registrado");
            LabelErrorLogin.setVisible(true);
        }
    }
    @FXML
    private void signin(){
        LabelErrorSignin.setVisible(false);
        if(!PersonAndClientProcess.PersonExist(TextFieldUsuariosNuevoDocumento.getText())){
            System.out.println("Usuario no Registrado");
            if(PersonAndClientProcess.Sign(TextFieldUsuariosNuevoDocumento.getText(),TextFieldUsuariosNuevoNombre.getText())){
                System.out.println("Usuario Registrado Correctamente");
                try{
                    switchToUsuario();
                    Econatura.SetDocumentoCliente(TextFieldUsuariosNuevoDocumento.getText());
                }
                catch(IOException e){
                    LabelErrorSignin.setVisible(true);
                    LabelErrorSignin.setText(e.getMessage());

                }
            }
        }
        else {

            LabelErrorSignin.setText("Usuario ya registrado");
            LabelErrorSignin.setVisible(true);
        }
    }


    @FXML
    private void switchToUsuario() throws IOException {

        Econatura.setRoot("usuarioSolicitudes");
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);
    }
    @FXML
    private void TestMenu() throws IOException {
        Econatura.setRoot("Menu");

    }
}
