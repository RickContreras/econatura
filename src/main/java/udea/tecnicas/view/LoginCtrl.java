package udea.tecnicas.view;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginCtrl {

    @FXML
    private void switchToSecondary() throws IOException {
        Econatura.setRoot("Funcionario_Solicitudes");
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);
    }
    @FXML
    private void TestMenu() throws IOException {
        Econatura.setRoot("Menu");

    }
}
