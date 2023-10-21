package udea.tecnicas.view;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class SecondaryController {

    public AnchorPane Menu;


    @FXML
    private void switchToPrimary() throws IOException {
        Econatura.setRoot("primary");

    }
}