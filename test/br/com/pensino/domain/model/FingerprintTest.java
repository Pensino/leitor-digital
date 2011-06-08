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
public class FingerprintTest {
    
    @Test
    public void shouldInstantiateFingerprint() {
        Employee emilio = new Employee("emilio", "resende", "37374688857", "006970594", Employee.Function.PROFESSOR);
        assertNotNull(new Fingerprint(new byte[100], emilio));
    }
    
}
