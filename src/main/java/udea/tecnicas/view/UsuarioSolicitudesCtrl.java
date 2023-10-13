package udea.tecnicas.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDateTime;

public class UsuarioSolicitudesCtrl {
    @FXML
    private void switchToGenerarSolicitud() throws IOException {
        Econatura.setRoot("usuarioGenerarSolicitud");
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);

    }
    @FXML
    public void initialize() {
        ColId= new TableColumn<>("id");
        ColId.setCellValueFactory(new PropertyValueFactory<>("id"));

        ColId_cliente= new TableColumn<>("id_Cliente");
        ColId_cliente.setCellValueFactory(new PropertyValueFactory<>("id_Cliente"));

        ColResource= new TableColumn<>("resource");
        ColResource.setCellValueFactory(new PropertyValueFactory<>("resource"));

        ColDate= new TableColumn<>("date");
        ColDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        ColEstimated= new TableColumn<>("state");
        ColEstimated.setCellValueFactory(new PropertyValueFactory<>("state"));

        ColRecovery = new TableColumn<>("estimated_impact");
        ColRecovery.setCellValueFactory(new PropertyValueFactory<>("estimated_impact"));

        ColState = new TableColumn<>("necessary_recovery");
        ColState.setCellValueFactory(new PropertyValueFactory<>("necessary_recovery"));

        RequestTable.getColumns().add(ColId);
        RequestTable.getColumns().add(ColId_cliente);
        RequestTable.getColumns().add(ColResource);
        RequestTable.getColumns().add(ColDate);
        RequestTable.getColumns().add(ColEstimated);
        RequestTable.getColumns().add(ColRecovery);
        RequestTable.getColumns().add(ColState);


        RequestTable.getItems().add(new RequestString("2032d","1128457944","Arbol xys",LocalDateTime.now(),"Activo",200234.0f,2343212.0f));
        RequestTable.getItems().add(new RequestString("2032d","1128457944","Arbol xys",LocalDateTime.now(),"Activo",200234.0f,2343212.0f));
        RequestTable.getItems().add(new RequestString("2032d","1128457944","Arbol xys",LocalDateTime.now(),"Activo",200234.0f,2343212.0f));

        //tableView.getItems().addAll(getDataFromSource()); // Perfectly Ok here, as FXMLLoader already populated all @FXML annotated members.
    }
    private void loadtable(){

    }

    @FXML
    private TableView RequestTable;

    private TableColumn<RequestString,String> ColId;

    private TableColumn<RequestString,String> ColId_cliente;

    private TableColumn<RequestString,String> ColResource;

    private TableColumn<RequestString, LocalDateTime> ColDate;

    private TableColumn<RequestString,String> ColEstimated;

    private TableColumn<RequestString,Float> ColRecovery;

    private TableColumn<RequestString, Float> ColState;



    public UsuarioSolicitudesCtrl(){




    }

}
