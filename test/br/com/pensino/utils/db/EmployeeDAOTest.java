/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.Employee;
import br.com.pensino.utils.db.EmployeeDAO.By;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class EmployeeDAOTest {

    @Test
    public void shouldRetrieveAllEmployeesFromDataBase() {
        assertNotNull(new EmployeeDAO().all());
        assertTrue(new EmployeeDAO().all().size() > 0);
    }

    @Test
    public void shouldRetrieveEmployeeById() {
        assertNotNull(new EmployeeDAO().find(By.id(1)));
        assertTrue(new EmployeeDAO().find(By.id(1)).getFirstName().equals("Emilio"));
    }

    @Test
    public void shouldRetrieveEmployeeByFirstName() {
        assertTrue(new EmployeeDAO().find(By.partOfName("Emi")).get(0).getFirstName().equals("Emilio"));
    }

    @Test
    public void shouldCreateNewEmployee() {
        Employee employee = new Employee("John", "Rambo", "123456789", "006680594", Employee.Function.PROFESSOR);
        assertTrue(new EmployeeDAO().save(employee));
    }
}
