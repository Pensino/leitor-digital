/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.utils.db.EmployeeDAO.By;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import br.com.pensino.domain.model.Employee;
import br.com.pensino.domain.model.Fingerprint;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class TimeTableDAOTest {
    public static final String CPF = "37374688857";

    @Test
    public void shouldRetrieveAllEmployeesFromDataBase() {
        assertNotNull(new EmployeeDAO().all());
        assertTrue(new EmployeeDAO().all().size() > 0);
    }

    @Test
    public void shouldRetrieveEmployeeById() {
        assertNotNull(new EmployeeDAO().find(1));
        assertTrue(new EmployeeDAO().find(1).getFirstName().equals("John"));
    }

    @Test
    public void shouldRetrieveEmployeeByFirstName() {
        assertTrue(new EmployeeDAO().find("jo").get(0).getFirstName().equals("John"));
    }

    @Test
    public void shouldCreateNewEmployee() {
        Employee employee = new Employee("John", "Rambo", CPF, "006680594", Employee.Function.PROFESSOR);
        assertTrue(new EmployeeDAO().save(employee));
    }
    
    @Test
    public void shouldRetrieveEmployeeByCriteria() {
        Employee employee = new EmployeeDAO().find(By.DOCUMENT, CPF).get(0);
        employee.getFirstName().equals("John");
    }

    @Test
    public void shouldStoreNewFingeprintToEmployee() throws IOException, ClassNotFoundException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.find(1);
        File file = new File("objeto1.ser");
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        ObjectInputStream ois = new ObjectInputStream(fis);
        byte[] fingerprintData = (byte[]) ois.readObject();
        Fingerprint fingerprint = new Fingerprint(fingerprintData, employee);
        employee.addFingerprint(fingerprint);
        assertTrue(new FingerprintDAO().save(fingerprint));        
        assertTrue(employeeDAO.save(employee));        
    }
}
