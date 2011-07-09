/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class EmployeeTest {

    Employee emilio = new Employee("Emilio", "Resende", "37374688857", "1325", Employee.Function.PROFESSOR);
    Employee jhonny = new Employee("Jonny", "B.Good", "37374688857", "006970594", Employee.Function.COORDENADOR);

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateEmployeeWithoutFirstName() {
        new Employee("", "Resende", "37374688857", "006970594", Employee.Function.PROFESSOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateEmployeeWithoutLastName() {
        new Employee("Emilio", null, "37374688857", "006970594", Employee.Function.PROFESSOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateEmployeeWithoutDocument() {
        new Employee("Emilio", "Resende", "", "006970594", Employee.Function.PROFESSOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateEmployeeWithoutRegister() {
        new Employee("Emilio", "Resende", "37374688857", null, Employee.Function.PROFESSOR);
    }

    @Test
    public void employeesWithSameDocumentAreEquals() {
        assertTrue(emilio.equals(jhonny));
    }

    @Test
    public void employeesCanHaveFingerprint() throws IOException, ClassNotFoundException {
        File file = new File("objeto1.ser");
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        ObjectInputStream ois = new ObjectInputStream(fis);
        byte[] fingerprintData = (byte[]) ois.readObject();
        Fingerprint fingerprintOne = new Fingerprint(fingerprintData);
        emilio.addFingerprint(fingerprintOne);
        assertTrue(emilio.getFingerprintList().size() == 1);
    }
}
