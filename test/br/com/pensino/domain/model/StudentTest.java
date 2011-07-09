/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.io.File;
import br.com.caelum.stella.validation.InvalidStateException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class StudentTest {

    @Test
    public void studentWithSameDocumentAreEquals() {
        Student student1 = new Student("Jhonny", "B.Good", "37374688857", "071111");
        Student student2 = new Student("Edward", "Norton", "37374688857", "072222");
        assertTrue(student1.equals(student2));
    }

    @Test(expected = InvalidStateException.class)
    public void studentCantBeCreatedWithInvalidCPF() {
        new Student("Bob", "Marley", "11111111111", "091111");
    }
    
    @Test
    public void studentCanHaveMultipleFingerprints() throws Exception {
    Student jow = new Student("JOW", "Drungo", "37374688857", "071111");
    File file = new File("objeto1.ser");
    FileInputStream fis = new FileInputStream(file.getAbsolutePath());
    ObjectInputStream ois = new ObjectInputStream(fis);
    byte[] fingerprintData = (byte[])ois.readObject();
    Fingerprint fingerprint = new Fingerprint(fingerprintData);
    jow.addFingerprint(fingerprint);
    Fingerprint fingerprint2 = new Fingerprint(fingerprintData);
    jow.addFingerprint(fingerprint2);
    assertTrue(jow.getFingerprintList().contains(fingerprint));
    assertTrue(jow.getFingerprintList().contains(fingerprint2));
    }
}
