package udea.tecnicas.view;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import udea.tecnicas.database.LicenseDAO;
import udea.tecnicas.model.License;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class FuncionarioSolicitudesLicenciasController {

    @FXML
    private TextField licenseFilter;

    @FXML
    private TableView<License> licenseTable;
    @FXML
    public Button botonMultas;


    @FXML
    Label labelMessage;

    @FXML
    public void initialize() {
        licenseTable.setPlaceholder(new Label("No hay licencias creadas"));
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
            List<License> data = new LicenseDAO().findAll() ;
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


    public void abrirVentanaModal(){
        try {
            FXMLLoader loader = new FXMLLoader(Econatura.class.getResource("Multas.fxml"));
            Parent root = loader.load();

            // Crear el escenario para la ventana modal
            Stage EscenarioModal = new Stage();
            EscenarioModal.initModality(Modality.APPLICATION_MODAL); // Configurar modalidad
            EscenarioModal.initStyle(StageStyle.UTILITY); // Configurar estilo
            EscenarioModal.setTitle("Multas");

            // Asociar el controlador de la ventana modal
            MultasCtrl modalController = loader.getController();
            modalController.setStage(EscenarioModal);

            // Establecer el contenido en el escenario y mostrar la ventana modal
            EscenarioModal.setScene(new Scene(root));
            EscenarioModal.showAndWait(); // Mostrar y esperar hasta que se cierre
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
