/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import br.com.caelum.stella.validation.InvalidStateException;
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
}
