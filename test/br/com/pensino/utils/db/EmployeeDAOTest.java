/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.Employee;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class EmployeeDAOTest {

    @Test
    public void shouldRetrieveAllEmployeesFromDataBase() {
        Employee employee = new EmployeeDAO().all().get(0);
        assertNotNull(new EmployeeDAO().all());
    }
}
