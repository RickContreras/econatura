package udea.tecnicas.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import udea.tecnicas.controller.Database;
import udea.tecnicas.model.Client;
import udea.tecnicas.model.Type;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Econatura extends Application {
    private static Stage stage;
    private static Scene scene;

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        scene = new Scene(loadFXML("login"), 800, 400);
        stage.setTitle("CorAntioquia!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        Database.createTablesIfNotExist();
        //Database.add_Client(new Client("123","Juan","11282342344", Type.PersonType.NATURAL));//prueba
       // System.out.println(Database.GetClients());
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Econatura.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}