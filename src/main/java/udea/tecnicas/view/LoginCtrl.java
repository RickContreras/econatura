package udea.tecnicas.view;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginCtrl {

    @FXML
    private void switchToSecondary() throws IOException {
        Econatura.setRoot("login");
    }
    @FXML
    private void TestMenu() throws IOException {
        Econatura.setRoot("Menu");
    }
}
