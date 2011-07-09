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
        assertNotNull(new Fingerprint(new byte[100]));
    }
    
}
