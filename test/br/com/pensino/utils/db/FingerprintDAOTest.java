/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.utils.db.DataAccessObject.By;
import br.com.pensino.domain.model.Employee;
import br.com.pensino.domain.model.Fingerprint;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class FingerprintDAOTest {

    @Test
    public void shouldSaveFingerprint() {
        Employee emilio = new EmployeeDAO().find(1);
        Fingerprint fingerprint = new Fingerprint(new byte[100], emilio);
        emilio.addFingerprint(fingerprint);
        FingerprintDAO dao = new FingerprintDAO();
        assertTrue(dao.save(fingerprint));
    }

    @Test
    public void shouldLoadFingerprintWithId1() {
        assertNotNull(new FingerprintDAO().find(By.id(1)));
    }
}
