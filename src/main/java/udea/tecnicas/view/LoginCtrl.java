package udea.tecnicas.view;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginCtrl {

    @FXML
    private void switchToFuncionario() throws IOException {
        Econatura.setRoot("FuncionarioSolicitudes");
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);
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
