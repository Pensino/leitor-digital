/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author emiliowl
 */
public class EmployeeTest {

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
    
     public void employeesWithSameDocumentAreEquals() {
        assertTrue(new Employee("Emilio", "Resende", "37374688857", "1325", Employee.Function.PROFESSOR).equals(new Employee("Jonny", "B.Good", "37374688857", "006970594", Employee.Function.COORDENADOR)));
    }  
     
}
