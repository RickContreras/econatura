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

import java.io.IOException;

public class UsuarioGenerarSolicitudCtrl {

    SpinnerValueFactory<Integer> valueFactoryImpacto = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
    SpinnerValueFactory<Integer> valueFactoryRecuperacion = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
    ObservableList<String> tipoRecurso = FXCollections.observableArrayList("Causes", "SuperficialWater", "UnderWater", "AliveFence", "ScientificResearch", "Woodland");
    ObservableList<String> tipoDocumento = FXCollections.observableArrayList("NIT", "CC");

    @FXML
    private ChoiceBox Recurso;

    @FXML
    private Spinner Impacto;

    @FXML
    private Spinner Recuperacion;
    @FXML
    private TextField Documento;

    @FXML
    private ChoiceBox TipoDocumento;



    @FXML
    private void initialize() {
        Recurso.setItems(tipoRecurso);
        Recurso.setValue("Causes");
        Impacto.setValueFactory(valueFactoryImpacto);
        Recuperacion.setValueFactory(valueFactoryRecuperacion);
        TipoDocumento.setItems(tipoDocumento);
        TipoDocumento.setValue("CC");
    }
    @FXML
    private void switchToSolicitud() throws IOException {
        Econatura.setRoot("usuarioSolicitudes");

        //Todo lo que se hace en el switchToSolicitud
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);
    }




}
