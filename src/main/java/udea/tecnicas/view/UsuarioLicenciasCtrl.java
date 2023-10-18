package udea.tecnicas.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import udea.tecnicas.database.LicenseDAO;
import udea.tecnicas.model.License;
import udea.tecnicas.model.Request;

import java.util.List;

public class UsuarioLicenciasCtrl {
    @FXML
    private TableView<License> licenseTable;
    @FXML
    ImageView arrowImage;
    @FXML
    Label labelMessage;


    @FXML
    public void initialize() {
        TableColumn<License, String> colId = new TableColumn<>("id");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<License, Request> colRequest = new TableColumn<>("Request");
        colRequest.setCellValueFactory(new PropertyValueFactory<>("request"));

        licenseTable.getColumns().addAll(colId, colRequest);

        loadtable();


        //tableView.getItems().addAll(getDataFromSource()); // Perfectly Ok here, as FXMLLoader already populated all @FXML annotated members.
    }

    private void loadtable(){
        try {
            //List<RequestString> data = Util.convertRequestToRequestString(new RequestDAO().findByClientDocument(Econatura.getDocumentoCliente()));
            List< License> data = new LicenseDAO().findByDocument(Econatura.getDocumentoCliente());
            licenseTable.setItems(FXCollections.observableArrayList(data));
            if(data.isEmpty()){
                arrowImage.setVisible(true);
                licenseTable.setVisible(false);
                labelMessage.setVisible(true);
            }
            else{
                arrowImage.setVisible(false);
                licenseTable.setVisible(true);
                labelMessage.setVisible(false);
            }
        }
        catch (Exception e){
            System.out.println("Error cargando tabla");
            e.printStackTrace();
        }
    }
}
