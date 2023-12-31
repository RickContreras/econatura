package udea.tecnicas.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Header;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import udea.tecnicas.database.ClientDAO;
import udea.tecnicas.database.LicenseDAO;
import udea.tecnicas.database.PenaltyFeeDAO;
import udea.tecnicas.database.RequestDAO;
import udea.tecnicas.model.Client;
import udea.tecnicas.model.License;
import udea.tecnicas.model.PenaltyFee;
import udea.tecnicas.model.Request;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class FuncionarioInformesController {
    @FXML
    Button boton_generar;
    @FXML
    ProgressBar progreso;

    public void initialize() {
        boton_generar.onMouseClickedProperty().set(mouseEvent -> generar_pdf(mouseEvent));
    }
    public void generar_pdf(MouseEvent event){
        Document document = new Document();
        try {
            AtomicReference<Float> Total = new AtomicReference<>((float) 0);
            float ValorSolicitud=3000000,ValorMulta=30000,ValorLicencia = 30000;
            // Especifica la ubicación del archivo PDF que deseas crear
            PdfWriter.getInstance(document, new FileOutputStream("miarchivo.pdf"));
            document.open();
            document.add(new Paragraph("Reporte general\n\n\n"));

            // Agrega un título
            Paragraph titulo = new Paragraph("Reporte de Licencias");
            document.add(titulo);

            RequestDAO rd = new RequestDAO();
            LicenseDAO ld = new LicenseDAO();
            ClientDAO cd = new ClientDAO();
            /*PenaltyFeeDAO pfd = new PenaltyFeeDAO();*/

            List<Request> requests = rd.findAll();
            com.itextpdf.text.List request_list = new com.itextpdf.text.List();
            requests.forEach(r->{
                Total.updateAndGet(v -> new Float((float) (v + ValorSolicitud)));
                Client client = cd.findByDocument(r.getIdClient()).get(0);
                request_list.add("Solicitud n"+r.getId()+" del cliente "+client.getType().toString()+" "+client.getFullName()+" con numero de documento "+ client.getCC()+" sobre el recurso :"+r.getNombreRecurso());
            });
            document.add(request_list);

            document.add(new Paragraph("\n\n"));
            document.add(new com.itextpdf.text.Paragraph("Licencias"));
            progreso.setProgress(0.5f);
            List<License> licenses = ld.findAll();
            com.itextpdf.text.List licence_list = new com.itextpdf.text.List();
            licenses.forEach(l->{
                Total.updateAndGet(v -> new Float((float) (v + ValorLicencia)));

                licence_list.add("Licencia n"+l.getId()+" con vigencia hasta :"+l.getEnd());
            });
            document.add(licence_list);

            //List<PenaltyFee> penalty = pfd.findByDocument("");
            //com.itextpdf.text.List penalty_list = new com.itextpdf.text.List();
        /*penalty.forEach(p->{
            Total.updateAndGet(v -> new Float((float) (v + ValorMulta)));
            Client client = cd.findByDocument("").get(0);
            penalty_list.add("Multa n"+p.getId()+" por razon "+p.getReason()+"Con valor de "+p.getValue()+p+" asociada a la licencia "+ p.getIdLicense());
        });
        document.add(penalty_list);*/

            Paragraph cantidad_total = new Paragraph("Cantidad total"+Total);
            document.add(cantidad_total);

            document.close();
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Reporte Generado");
            a.show();
            progreso.setProgress(1f);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
