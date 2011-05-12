/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.fingerPrint;

import java.util.Set;
import com.griaule.grfingerjava.FingerprintImage;
import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class FingerprintEngineTest {
    
    public FingerprintEngineTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class FingerprintEngine.
     */
    @Test
    public void testGetInstance() {
        assertNotNull(FingerprintEngine.getInstance());
    }

    /**
     * Test of startObserve method, of class FingerprintEngine.
     */
    @Test
    public void testStartObserve() {
        FingerprintEngineObserver observer = new FingerprintEngineObserver() {

            @Override
            public boolean notifyImageAcquired(FingerprintImage fingerprintImage) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public boolean notifyTemplateExtracted(BufferedImage templateImage) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
        FingerprintEngine.getInstance().startObserve(observer);
        assertTrue(FingerprintEngine.getInstance().getObservers().contains(observer));
    }

    /**
     * Test of stopObserve method, of class FingerprintEngine.
     */
    @Test
    public void testStopObserve() {
        FingerprintEngineObserver observer = new FingerprintEngineObserver() {

            @Override
            public boolean notifyImageAcquired(FingerprintImage fingerprintImage) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public boolean notifyTemplateExtracted(BufferedImage templateImage) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
        FingerprintEngine.getInstance().startObserve(observer);
        assertFalse(FingerprintEngine.getInstance().getObservers().contains(observer));
    }

    /**
     * Test of startListenSensor method, of class FingerprintEngine.
     */
    @Test
    public void testStartListenSensor() {
        System.out.println("startListenSensor");
        FingerprintEngine instance = null;
        instance.startListenSensor();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onSensorPlug method, of class FingerprintEngine.
     */
    @Test
    public void testOnSensorPlug() {
        System.out.println("onSensorPlug");
        String idSensor = "";
        FingerprintEngine instance = null;
        instance.onSensorPlug(idSensor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onSensorUnplug method, of class FingerprintEngine.
     */
    @Test
    public void testOnSensorUnplug() {
        System.out.println("onSensorUnplug");
        String idSensor = "";
        FingerprintEngine instance = null;
        instance.onSensorUnplug(idSensor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onImageAcquired method, of class FingerprintEngine.
     */
    @Test
    public void testOnImageAcquired() {
        System.out.println("onImageAcquired");
        String string = "";
        FingerprintImage fingerprintImage = null;
        FingerprintEngine instance = null;
        instance.onImageAcquired(string, fingerprintImage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onFingerDown method, of class FingerprintEngine.
     */
    @Test
    public void testOnFingerDown() {
        System.out.println("onFingerDown");
        String string = "";
        FingerprintEngine instance = null;
        instance.onFingerDown(string);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onFingerUp method, of class FingerprintEngine.
     */
    @Test
    public void testOnFingerUp() {
        System.out.println("onFingerUp");
        String string = "";
        FingerprintEngine instance = null;
        instance.onFingerUp(string);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendFingerprint method, of class FingerprintEngine.
     */
    @Test
    public void testSendFingerprint() {
        System.out.println("sendFingerprint");
        FingerprintImage fingerprintImage = null;
        FingerprintEngine instance = null;
        boolean expResult = false;
        boolean result = instance.sendFingerprint(fingerprintImage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendFingerprintTemplate method, of class FingerprintEngine.
     */
    @Test
    public void testSendFingerprintTemplate() {
        System.out.println("sendFingerprintTemplate");
        BufferedImage templateImage = null;
        FingerprintEngine instance = null;
        boolean expResult = false;
        boolean result = instance.sendFingerprintTemplate(templateImage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkFingerprint method, of class FingerprintEngine.
     */
    @Test
    public void testCheckFingerprint() {
        System.out.println("checkFingerprint");
        byte[] fingerprintData = null;
        FingerprintEngine instance = null;
        BufferedImage expResult = null;
        BufferedImage result = instance.checkFingerprint(fingerprintData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
