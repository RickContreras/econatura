package udea.tecnicas.view;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        Econatura.setRoot("primary");
    }
}