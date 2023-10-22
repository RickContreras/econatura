package udea.tecnicas.view;



import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import udea.tecnicas.database.PenaltyFeeDAO;
import udea.tecnicas.model.PenaltyFee;

public class MultasCtrl {

    SpinnerValueFactory<Integer> idsLincense = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
    private Stage stage;

    @FXML
    private Spinner<Integer> IDLicense;

    @FXML
    private TextField Value;

    @FXML
    private TextArea Reason;

    PenaltyFeeDAO penaltyFeeDAO;
    @FXML
    private void initialize() {
        IDLicense.setEditable(true);
        IDLicense.setValueFactory(idsLincense);
        penaltyFeeDAO = new PenaltyFeeDAO();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void cerrarModal() {
        try {
            PenaltyFee fee = new PenaltyFee();
            fee.setReason(Reason.getText());
            fee.setValue(Float.parseFloat(Value.getText()));
            fee.setIdLicense(String.valueOf(IDLicense.getValue()));
            System.out.println(fee);
            penaltyFeeDAO.insert(fee);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        stage.close();
    }

}
