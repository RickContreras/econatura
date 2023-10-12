package udea.tecnicas.view;

import javafx.fxml.FXML;

import java.io.IOException;

public class UsuarioSolicitudesCtrl {
    @FXML
    private void switchToGenerarSolicitud() throws IOException {
        Econatura.setRoot("usuarioGenerarSolicitud");
        Econatura.getStage().setHeight(600);
        Econatura.getStage().setWidth(1200);
    }
}
