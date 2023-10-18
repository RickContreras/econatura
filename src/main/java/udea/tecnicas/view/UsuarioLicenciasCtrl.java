package udea.tecnicas.view;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import udea.tecnicas.database.LicenseDAO;
import udea.tecnicas.model.License;

import java.time.LocalDate;
import java.util.List;

public class UsuarioLicenciasCtrl {
    @FXML
    private TableView<License> licenseTable;

    @FXML
    Label labelMessage;


    @FXML
    public void initialize() {
        TableColumn<License, String> colId = new TableColumn<>("id");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<License, String> colRequest= new TableColumn<>("Request");
        colRequest.setCellValueFactory(new PropertyValueFactory<>("request"));

        TableColumn<License, LocalDate> colRequestDate = new TableColumn<>("Request Date");
        colRequestDate.setCellValueFactory(p-> new ReadOnlyObjectWrapper<>(p.getValue().getRequest().getDate()));


        TableColumn<License, String> colStart= new TableColumn<>("Start");
        colStart.setCellValueFactory(new PropertyValueFactory<>("start"));

        TableColumn<License, String> colEnd= new TableColumn<>("End");
        colEnd.setCellValueFactory(new PropertyValueFactory<>("end"));

        TableColumn<License, Double> colEstimatedImpact = new TableColumn<>("Estimated impact");
        colEstimatedImpact.setCellValueFactory(p-> new ReadOnlyObjectWrapper<>(p.getValue().getRequest().getEstimatedImpact()));

        licenseTable.getColumns().addAll(colId, colRequest, colRequestDate, colStart, colEnd, colEstimatedImpact);

        loadtable();
    }

    private void loadtable(){
        try {
            List< License> data = new LicenseDAO().findByDocument(Econatura.getDocumentoCliente());
            licenseTable.setItems(FXCollections.observableArrayList(data));
            if(data.isEmpty()){
                licenseTable.setVisible(false);
                labelMessage.setVisible(true);
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
