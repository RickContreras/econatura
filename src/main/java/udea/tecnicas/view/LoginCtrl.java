package udea.tecnicas.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import udea.tecnicas.database.ClientDAO;
import udea.tecnicas.database.DatabaseException;
import udea.tecnicas.model.Client;
import udea.tecnicas.model.Type;

import java.io.IOException;

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

    ClientDAO clientDAO;

    public void initialize() {
        clientDAO = new ClientDAO();
    }

    @FXML
    private void switchToFuncionario() throws IOException {
        Econatura.setRoot("FuncionarioSolicitudes");
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);
    }
    @FXML
    private void login(){
        LabelErrorLogin.setVisible(false);
        if(clientDAO.findByDocument(TextFieldUsuariosRegistrado.getText()).isEmpty()) {
            LabelErrorLogin.setText("Usuario no registrado");
            LabelErrorLogin.setVisible(true);
        } else {
            try {
                Econatura.SetDocumentoCliente(TextFieldUsuariosRegistrado.getText());
                switchToUsuario();
            } catch(IOException e){
                LabelErrorLogin.setVisible(true);
                LabelErrorLogin.setText(e.getMessage());
                System.out.println(e.getMessage()+e.getCause());
            }
        }
    }
    @FXML
    private void signin(){
        LabelErrorSignin.setVisible(false);
        try {
            Client client = new Client();
            client.setType(Type.PersonType.UNDEFINED);
            client.setCC(TextFieldUsuariosNuevoDocumento.getText());
            client.setFullName(TextFieldUsuariosNuevoNombre.getText());
            clientDAO.insert(client);
            switchToUsuario();
            Econatura.SetDocumentoCliente(TextFieldUsuariosNuevoDocumento.getText());
        } catch (DatabaseException | IOException ex) {
            LabelErrorSignin.setVisible(true);
            LabelErrorSignin.setText(ex.getMessage());
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
