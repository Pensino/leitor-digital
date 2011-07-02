/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.Student;
import br.com.pensino.utils.db.StudentDAO.By;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import br.com.pensino.domain.model.Fingerprint;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class StudentDAOTest {
    public static final String CPF = "60265139490";

    @Test
    public void shouldRetrieveAllStudentsFromDataBase() {
        assertNotNull(new StudentDAO().all());
        assertTrue(new StudentDAO().all().size() > 0);
    }

    @Test
    public void shouldRetrieveStudentById() {
        assertNotNull(new StudentDAO().find(1));
        assertTrue(new StudentDAO().find(1).getFirstName().equals("Joey"));
    }

    @Test
    public void shouldRetrieveStudentByFirstName() {
        assertTrue(new StudentDAO().find("jo").get(0).getFirstName().equals("Joey"));
    }

    @Test
    public void shouldCreateNewStudent() {
        Student student = new Student("Joey", "Ramone", CPF, "0071111");
        assertTrue(new StudentDAO().save(student));
    }
    
    @Test
    public void shouldRetrieveStudentByCriteria() {
        Student student = new StudentDAO().find(By.DOCUMENT, CPF).get(0);
        student.getFirstName().equals("Joey");
    }

    @Test
    public void shouldStoreNewFingeprintToStudent() throws IOException, ClassNotFoundException {
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.find(1);
        File file = new File("objeto1.ser");
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        ObjectInputStream ois = new ObjectInputStream(fis);
        byte[] fingerprintData = (byte[]) ois.readObject();
        Fingerprint fingerprint = new Fingerprint(fingerprintData, student);
        student.addFingerprint(fingerprint);
        assertTrue(new FingerprintDAO().save(fingerprint));        
        assertTrue(studentDAO.save(student));        
    }
}
