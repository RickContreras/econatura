package udea.tecnicas.view;


import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import org.w3c.dom.Text;
import udea.tecnicas.database.RequestDAO;
import udea.tecnicas.model.Client;
import udea.tecnicas.model.Request;
import udea.tecnicas.model.State;

import java.time.LocalDate;
import java.util.List;

public class FuncionarioSolicitudesController {
    @FXML
    private TableView<Request> RequestTable;

    private void loadRequest(MouseEvent event){
        Node rs = event.getPickResult().getIntersectedNode();
        ObservableMap<Object,Object> data = rs.getProperties();
        System.out.println(rs.getProperties().get("text"));

        System.out.println(rs.toString());

    }
    public void initialize() {
        RequestTable.onMouseClickedProperty().set(event->loadRequest(event) );
        TableColumn<Request, String> colId = new TableColumn<>("id");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Request, Client> colCliente = new TableColumn<>("Cliente");
        colCliente.setCellValueFactory(new PropertyValueFactory<>("client"));

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

        RequestTable.getColumns().addAll(colId,colCliente, colDate,colEstimated, colRecovery, colState,colRecurso,colMunicipio,colDepartamento);

        loadtable();

        //tableView.getItems().addAll(getDataFromSource()); // Perfectly Ok here, as FXMLLoader already populated all @FXML annotated members.
    }
    private void loadtable(){
        try {
            //List<RequestString> data = Util.convertRequestToRequestString(new RequestDAO().findByClientDocument(Econatura.getDocumentoCliente()));
            List< Request> data = new RequestDAO().findAll();
            data.forEach((n)->{
                RequestTable.getItems().add(n);
            });
        }
        catch (Exception e){
            System.out.println("Error cargando tabla");
            e.printStackTrace();
        }

    }
}
