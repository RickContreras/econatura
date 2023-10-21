package udea.tecnicas.view;



import javafx.fxml.FXML;
import javafx.stage.Stage;
public class MultasCtrl {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void cerrarModal() {
        stage.close();
    }

}
