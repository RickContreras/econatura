package udea.tecnicas.view;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class FuncionarioSolicitudesLicenciasController {
    @FXML
    public WebView ViewMap;
    public WebEngine MapEngine;

    @FXML
    public Button boton_gargar;

    @FXML
    public void cargar_pagina(){
        MapEngine = ViewMap.getEngine();
        //String url = getClass().getResource("map.html").toString();


        String url =  "https://www.google.com/maps/@6.2502784,-75.5764463,16z?entry=ttu";
        MapEngine.setJavaScriptEnabled(true);
        try{
            MapEngine.load(url);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void CargarMapa(){
        cargar_pagina();
    }


}
