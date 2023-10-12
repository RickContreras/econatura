package udea.tecnicas.view;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;

import java.net.URL;

public class FuncionarioSolicitudesLicenciasController {
    @FXML
    public WebView ViewMap;
    public WebEngine MapEngine = null;

    @FXML
    public Button boton_gargar;

    @FXML
    public void cargar_pagina(){
        URL url = this.getClass().getResource("map.html");

        System.out.println(url.toString());
        String content = "<html>\n" +
                "    <body>\n" +
                "        <h1>Mapa de los factores</h1>\n" +
                "    </body>\n" +
                "</html>";
        MapEngine.loadContent(content);
    }

    public FuncionarioSolicitudesLicenciasController(){
        MapEngine = ViewMap.getEngine();
    }


}
