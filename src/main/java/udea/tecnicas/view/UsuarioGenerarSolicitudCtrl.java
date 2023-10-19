package udea.tecnicas.view;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import udea.tecnicas.database.ClientDAO;
import udea.tecnicas.database.RequestDAO;
import udea.tecnicas.model.Client;
import udea.tecnicas.model.Request;
import udea.tecnicas.model.State;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioGenerarSolicitudCtrl {
    SpinnerValueFactory<Double> valueFactoryImpacto = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 0);
    SpinnerValueFactory<Double> valueFactoryRecuperacion = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 0);
    ObservableList<String> tipoRecurso = FXCollections.observableArrayList("Causes", "SuperficialWater", "UnderWater", "AliveFence", "ScientificResearch", "Woodland");
    ObservableList<String> tipoDocumento = FXCollections.observableArrayList("NIT", "CC");

    @FXML
    private ChoiceBox Recurso;

    @FXML
    private Spinner<Double> impacto;

    @FXML
    private Spinner<Double> recuperacion;
    @FXML
    private TextField Documento;

    @FXML
    private ChoiceBox TipoDocumento;

    @FXML
    private TextField nombreRecurso;

    @FXML
    private TextField municipio;

    @FXML
    private TextField departamento;

    RequestDAO requestDAO;

    @FXML
    private void initialize() {
        impacto.setEditable(true);
        recuperacion.setEditable(true);
        Recurso.setItems(tipoRecurso);
        Recurso.setValue("Causes");
        impacto.setValueFactory(valueFactoryImpacto);
        recuperacion.setValueFactory(valueFactoryRecuperacion);
        TipoDocumento.setItems(tipoDocumento);
        TipoDocumento.setValue("CC");
        Documento.setText(Econatura.getDocumentoCliente());
        requestDAO = new RequestDAO();

    }
    @FXML
    private void switchToSolicitud() throws IOException {
        Econatura.setRoot("usuarioSolicitudes");
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);

    }

    @FXML
    private void sendRequest(){
        Request request = new Request();
        Client client=new Client();
        client.setCC(Documento.getText());
        request.setClient(client);
        request.setDate(LocalDate.now());
        request.setEstimatedImpact(impacto.getValue());
        request.setNecessaryRecovery(recuperacion.getValue());
        request.setNombreRecurso(nombreRecurso.getText());
        request.setMunicipio(municipio.getText());
        request.setDepartamento(departamento.getText());
        request.setState(State.stateRequest.RECEIVED);
        requestDAO.insert(request);
        try {
            switchToSolicitud();
        }catch (IOException ioException){
            System.out.println("Excepción al cambiar de pantalla");
            ioException.printStackTrace();
        }
    }
}
