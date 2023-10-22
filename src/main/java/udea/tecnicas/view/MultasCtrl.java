package udea.tecnicas.view;



import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import udea.tecnicas.database.RequestDAO;

public class MultasCtrl {

    SpinnerValueFactory<Integer> idsLincense = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
    private Stage stage;

    @FXML
    private Spinner<Integer> IDLicense;

    @FXML
    private TextField Value;

    @FXML
    private TextArea Reason;

    @FXML
    private void initialize() {

        IDLicense.setValueFactory(idsLincense);


    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void cerrarModal() {
        stage.close();
    }

}
