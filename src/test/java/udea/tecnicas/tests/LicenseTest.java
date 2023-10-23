package udea.tecnicas.tests;

import org.junit.jupiter.api.Test;
import udea.tecnicas.database.LicenseDAO;
import udea.tecnicas.database.PenaltyFeeDAO;
import udea.tecnicas.model.License;
import udea.tecnicas.model.Request;
import udea.tecnicas.model.State;

import java.time.LocalDate;

public class LicenseTest {
    @Test
    public void testLicense() {
        License license = new License();
        Request request = new Request();
        request.setId("1");
        license.setRequest(request);
        license.setState(State.stateLicense.ACTIVE);
        license.setStart(LocalDate.of(2020, 10, 15));
        license.setEnd(LocalDate.of(2024, 12, 31));
        new LicenseDAO().insert(license);
    }

    @Test
    public void testListLicense() {
        System.out.println(new LicenseDAO().findAll());
    }

    @Test
    public void testListByDocumentLicense() {
        System.out.println(new LicenseDAO().findByDocument("3"));
    }

    @Test
    public void testListPaymentFee() {
        System.out.println(new PenaltyFeeDAO().findByDocument("1"));
    }
}
