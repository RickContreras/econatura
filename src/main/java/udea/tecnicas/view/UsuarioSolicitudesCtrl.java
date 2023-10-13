package udea.tecnicas.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import udea.tecnicas.model.Request;

import java.io.IOException;
import java.util.HashMap;

public class UsuarioSolicitudesCtrl {
    @FXML
    private void switchToGenerarSolicitud() throws IOException {
        Econatura.setRoot("usuarioGenerarSolicitud");
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);
    }
    @FXML
    private TableView RequestTable;
    @FXML
    private TableColumn<Request,String> ColId;
    @FXML
    private TableColumn<Request,String> ColId_cliente;
    @FXML
    private TableColumn<Request,String> ColResource;
    @FXML
    private TableColumn<Request,String> ColDate;
    @FXML
    private TableColumn<Request,String> ColEstimated;
    @FXML
    private TableColumn<Request,String> ColRecovery;
    @FXML
    private TableColumn<Request,String> ColState;



    public UsuarioSolicitudesCtrl(){
        //ColId.setCellValueFactory(new PropertyValueFactory("ID"));

        ObservableList<Request> requests = null;
        //RequestTable.setItems(requests);
    }
}
