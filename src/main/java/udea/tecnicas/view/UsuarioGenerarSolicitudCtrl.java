package udea.tecnicas.view;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UsuarioGenerarSolicitudCtrl {

    ObservableList<String> list = FXCollections.observableArrayList("Forestal", "Hidrico");
    @FXML
    private ChoiceBox recurso;


    @FXML
    private void initialize() {
        recurso.setValue("Forestal");
        recurso.setItems(list);
    }




}
