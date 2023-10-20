package udea.tecnicas.view;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import udea.tecnicas.database.RequestDAO;
import udea.tecnicas.model.Client;
import udea.tecnicas.model.Request;
import udea.tecnicas.model.State;
import java.time.LocalDate;
import java.util.List;

public class FuncionarioSolicitudesController {

    ObservableList<State.stateRequest> status = FXCollections.observableArrayList(State.stateRequest.APROVED, State.stateRequest.REFUSED, State.stateRequest.IN_REVIEW, State.stateRequest.RECEIVED);

    @FXML
    private Label LabelStatus;
    @FXML
    private TextField documentFilter;

    @FXML
    private ChoiceBox<State.stateRequest> ChoiceBoxStatus;
    @FXML
    private TableView<Request> RequestTable;

    private void loadRequest(MouseEvent event){
        if(!RequestTable.getSelectionModel().isEmpty()){
            Request r = new RequestDAO().findById(RequestTable.getSelectionModel().getSelectedItem().getId()).get(0);
            LabelStatus.setText(r.getId());
            ChoiceBoxStatus.setValue(r.getState());
        }
    }
    private void changeStateRequest(ActionEvent id){
        if(!RequestTable.getSelectionModel().isEmpty()) {
            Request r = new RequestDAO().findById(RequestTable.getSelectionModel().getSelectedItem().getId()).get(0);
            if(!r.getState().equals(ChoiceBoxStatus.getValue()))
            {
                r.setState(ChoiceBoxStatus.getValue());
                //changeStatusRequest(r) Funcion a implementar
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Solicitud modificada");
                a.show();
            }
        }
    }
    private void searchRequest(KeyEvent e){

        if(e.getCode().equals(KeyCode.ENTER)){
            try {
                RequestTable.getItems().removeAll(RequestTable.getItems());
                List< Request> data;
                if(documentFilter.getText().isEmpty()){
                    data= new RequestDAO().findAll();
                }
                else{
                    data= new RequestDAO().findByClientDocument(documentFilter.getText());

                }
                data.forEach((n)->{
                    RequestTable.getItems().add(n);
                });
            }
            catch (Exception ev){
                System.out.println("Error cargando tabla");
                ev.printStackTrace();
            }
        }
    }
    public void initialize() {
        ChoiceBoxStatus.setItems(status);
        ChoiceBoxStatus.setOnAction(event -> changeStateRequest(event));
        RequestTable.onMouseClickedProperty().set(event->loadRequest(event) );
        documentFilter.onKeyPressedProperty().set(keyEvent -> searchRequest(keyEvent));

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
