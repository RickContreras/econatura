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
import udea.tecnicas.database.PenaltyFeeDAO;
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

        penaltyFeeTable.setPlaceholder(new Label("No hay multas asociadas"));


        // Construcción de las columnas para la tabla de licencias
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

        loadLicenseTable();

        // Construcción de las columnas para la tabla de multas

        TableColumn<PenaltyFee, String> colIdMulta = new TableColumn<>("ID");
        colIdMulta.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<PenaltyFee, String> colReason = new TableColumn<>("Razón");
        colReason.setCellValueFactory(new PropertyValueFactory<>("Reason"));

        TableColumn<PenaltyFee, String> colValue = new TableColumn<>("Valor");
        colValue.setCellValueFactory(new PropertyValueFactory<>("value"));

        TableColumn<PenaltyFee, String> colPenaltyFeeIdLicense = new TableColumn<>("Id Licensia");
        colPenaltyFeeIdLicense.setCellValueFactory(new PropertyValueFactory<>("idLicense"));

        penaltyFeeTable.getColumns().addAll(colIdMulta, colReason,  colValue, colPenaltyFeeIdLicense);

        loadPenaltyFeeTable();
    }

    private void loadLicenseTable(){
        try {
            List<License> data = new LicenseDAO().findByDocument(Econatura.getDocumentoCliente());
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

    private void loadPenaltyFeeTable(){
        try{
            List<PenaltyFee> data = new PenaltyFeeDAO().findByDocument(Econatura.getDocumentoCliente());
            penaltyFeeTable.setItems(FXCollections.observableArrayList(data));
            if(data.isEmpty()){
                labelMessage.setVisible(true);
                penaltyFeeTable.setVisible(false);
            }
            else {
                penaltyFeeTable.setVisible(true);
                labelMessage.setVisible(false);

            }
        }catch (Exception e){
            System.out.println("Error cargando tabla");
            e.printStackTrace();
        }
    }


}
