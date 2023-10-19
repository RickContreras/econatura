package udea.tecnicas.view;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import udea.tecnicas.database.LicenseDAO;
import udea.tecnicas.model.License;
import udea.tecnicas.model.PenaltyFee;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UsuarioLicenciasCtrl {
    @FXML
    private TableView<License> licenseTable;

    @FXML
    private TableView<PenaltyFee> penaltyFeeTable;

    @FXML
    Label labelMessage;

    @FXML
    ImageView arrowImage;

    @FXML
    private void switchToGenerarSolicitud() throws IOException {

        Econatura.setRoot("usuarioGenerarSolicitud");
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);

    }

    @FXML
    public void initialize() {
        TableColumn<License, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<License, String> colIDRequest= new TableColumn<>("ID Request");
        colIDRequest.setCellValueFactory(new PropertyValueFactory<>("request"));


        TableColumn<License, String> colStart= new TableColumn<>("Inicio");
        colStart.setCellValueFactory(new PropertyValueFactory<>("start"));

        TableColumn<License, String> colEnd= new TableColumn<>("Final");
        colEnd.setCellValueFactory(new PropertyValueFactory<>("end"));

        TableColumn<License, Double> colState = new TableColumn<>("Estado");
        colState.setCellValueFactory(new PropertyValueFactory<>("state"));

        licenseTable.getColumns().addAll(colId, colIDRequest, colStart, colEnd, colState);

        loadtable();
    }

    private void loadtable(){
        try {
            List< License> data = new LicenseDAO().findByDocument(Econatura.getDocumentoCliente());
            licenseTable.setItems(FXCollections.observableArrayList(data));
            if(data.isEmpty()){
                arrowImage.setVisible(true);
                licenseTable.setVisible(false);
                labelMessage.setVisible(true);
                penaltyFeeTable.setVisible(false);
            }
            else{
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
