package udea.tecnicas.view;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        Econatura.setRoot("secondary");
    }
}
