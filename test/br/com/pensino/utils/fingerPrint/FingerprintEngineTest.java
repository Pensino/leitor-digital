/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.fingerPrint;

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
            public boolean notifyImageAcquired(BufferedImage fingerprintImage) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public boolean notifyTemplateExtracted(BufferedImage templateImage, byte[] templateData) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public boolean showSimilarities(BufferedImage fingerprintImage) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void notifyFingerDown() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void notifyFingerUp() {
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
            public boolean notifyImageAcquired(BufferedImage fingerprintImage) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public boolean notifyTemplateExtracted(BufferedImage templateImage, byte[] templateData) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public boolean showSimilarities(BufferedImage fingerprintImage) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void notifyFingerDown() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void notifyFingerUp() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };

        FingerprintEngine.getInstance().startObserve(observer);
        assertTrue(FingerprintEngine.getInstance().getObservers().contains(observer));
        FingerprintEngine.getInstance().stopObserve(observer);
        assertFalse(FingerprintEngine.getInstance().getObservers().contains(observer));
    }
    
}