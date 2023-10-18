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

import java.io.IOException;

public class UsuarioGenerarSolicitudCtrl {
    SpinnerValueFactory<Integer> valueFactoryImpacto = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
    SpinnerValueFactory<Integer> valueFactoryRecuperacion = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
    ObservableList<String> tipoRecurso = FXCollections.observableArrayList("Causes", "SuperficialWater", "UnderWater", "AliveFence", "ScientificResearch", "Woodland");
    ObservableList<String> tipoDocumento = FXCollections.observableArrayList("NIT", "CC");

    @FXML
    private ChoiceBox Recurso;

    @FXML
    private Spinner impacto;

    @FXML
    private Spinner recuperacion;
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
    private void switchToGenerarSolicitud() throws IOException {
        Econatura.setRoot("usuarioSolicitudes");

        //Todo lo que se hace en el switchToSolicitud
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);

    }

    @FXML
    private void sendRequest(){
        try {
            Request request = new Request();

            Client client=new Client();
            client.setCC(String.valueOf(Documento));
            request.setClient(client);
            request.setEstimatedImpact(Float.parseFloat(impacto.getValue().toString()));
            request.setNecessaryRecovery(Float.parseFloat(recuperacion.getValue().toString()));
            requestDAO.insert(request);
            System.out.println(impacto.getValue());
            switchToGenerarSolicitud();
        }catch (IOException ioException){
            System.out.println(ioException);
        }
    }


}
