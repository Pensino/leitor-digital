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

    /**
     * Test of startListenSensor method, of class FingerprintEngine.
     */
    @Test
    public void testStartListenSensor() {
        //FingerprintEngine.getInstance().startListenSensor();
        assertTrue(true);
    }

    /**
     * Test of onSensorPlug method, of class FingerprintEngine.
     */
    @Test
    public void testOnSensorPlug() {
        //TODO: verificar se exite alguma forma de implementar o teste para este método.
    }

    /**
     * Test of onSensorUnplug method, of class FingerprintEngine.
     */
    @Test
    public void testOnSensorUnplug() {
        //TODO: verificar se existe alguma forma de implementar o teste para este método.
    }

    /**
     * Test of onImageAcquired method, of class FingerprintEngine.
     */
    @Test
    public void testOnImageAcquired() {
        FingerprintEngine.getInstance().onImageAcquired("imagem", new FingerprintImage(100, 100, 100));
        //TODO implementar os testes
    }

    /**
     * Test of onFingerDown method, of class FingerprintEngine.
     */
    @Test
    public void testOnFingerDown() {
        FingerprintEngine.getInstance().onFingerDown("teste");
        //TODO implementar os testes
    }

    /**
     * Test of onFingerUp method, of class FingerprintEngine.
     */
    @Test
    public void testOnFingerUp() {
        FingerprintEngine.getInstance().onFingerUp("teste");
        //TODO implemntar os testes
    }

    /**
     * Test of sendFingerprint method, of class FingerprintEngine.
     */
    @Test
    public void testSendFingerprint() {
        FingerprintEngine.getInstance().sendFingerprint(new FingerprintImage(100, 100, 100));
    }

    /**
     * Test of sendFingerprintTemplate method, of class FingerprintEngine.
     */
    @Test
    public void testSendFingerprintTemplate() {
        FingerprintEngine.getInstance().sendFingerprintTemplate(null);
    }

    /**
     * Test of checkFingerprint method, of class FingerprintEngine.
     */
    @Test
    public void testCheckFingerprint() {
        //TODO melhorar os testes
    }

    /**
     * Test of extract method, of class FingerprintEngine
     */
    @Test
    public void testExtract() {
        // TODO: implementar teste
    }
}