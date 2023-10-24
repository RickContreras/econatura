package udea.tecnicas.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import udea.tecnicas.database.RequestDAO;
import udea.tecnicas.model.Client;
import udea.tecnicas.model.Request;
import udea.tecnicas.model.State;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


public class UsuarioSolicitudesCtrl {
    @FXML
    ImageView arrowImage;
    @FXML
    Label LabelMessage;

    @FXML
    private TableView<Request> RequestTable;


    @FXML
    private void switchToSolicitud() throws IOException {

        Econatura.setRoot("usuarioGenerarSolicitud");
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);

    }
    @FXML
    public void initialize() {
        TableColumn<Request, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Request, LocalDate> colDate = new TableColumn<>("Fecha");
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Request, State.stateRequest> colState = new TableColumn<>("Estado");
        colState.setCellValueFactory(new PropertyValueFactory<>("state"));

        TableColumn<Request, Double> colEstimated = new TableColumn<>("Impacto Estimado");
        colEstimated.setCellValueFactory(new PropertyValueFactory<>("estimatedImpact"));

        TableColumn<Request, Double> colRecovery = new TableColumn<>("Recuperacion necesaria");
        colRecovery.setCellValueFactory(new PropertyValueFactory<>("necessaryRecovery"));

        TableColumn<Request, State.stateRequest> colMunicipio = new TableColumn<>("Municipio");
        colMunicipio.setCellValueFactory(new PropertyValueFactory<>("municipio"));

        TableColumn<Request, Double> colDepartamento = new TableColumn<>("Departamento");
        colDepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));

        TableColumn<Request, Double> colRecurso = new TableColumn<>("Recurso");
        colRecurso.setCellValueFactory(new PropertyValueFactory<>("nombreRecurso"));

        RequestTable.getColumns().addAll(colId, colDate,colEstimated, colRecovery, colState,colRecurso,colMunicipio,colDepartamento);

        loadtable();

        //tableView.getItems().addAll(getDataFromSource()); // Perfectly Ok here, as FXMLLoader already populated all @FXML annotated members.
    }
    private void loadtable(){
        try {
            List< Request> data = new RequestDAO().findByClientDocument(Econatura.getDocumentoCliente());
            data.forEach((n)->{
                RequestTable.getItems().add(n);
            });
            if(data.stream().count()==0){
                arrowImage.setVisible(true);
                RequestTable.setVisible(false);
                LabelMessage.setVisible(true);
            }
            else{
                arrowImage.setVisible(false);
                RequestTable.setVisible(true);
                LabelMessage.setVisible(false);
            }
        }
        catch (Exception e){
            System.out.println("Error cargando tabla");
            e.printStackTrace();
        }

    }
}
