/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.fingerPrint;

import com.griaule.grfingerjava.FingerprintImage;
import com.griaule.grfingerjava.GrFingerJava;
import com.griaule.grfingerjava.GrFingerJavaException;
import com.griaule.grfingerjava.IFingerEventListener;
import com.griaule.grfingerjava.IImageEventListener;
import com.griaule.grfingerjava.IStatusEventListener;
import com.griaule.grfingerjava.MatchingContext;
import com.griaule.grfingerjava.Template;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author emiliowl
 */
public class FingerprintEngine implements IStatusEventListener, IImageEventListener, IFingerEventListener {

    private static FingerprintEngine instance = null;
    /**Contexto utilizado para a captura, extracao e coincidencia de impressoes digitais */
    private MatchingContext fingerprintSDK;
    /** Contem localmente os dados da impressao digital capturada */
    private ByteArrayInputStream fingerprintData;
    /**Contem a longitude do dado da impressao digital*/
    private int fingerprintDataLength;
    /** A imagen da última impressão digital capturada. */
    private FingerprintImage fingerprintImage = null;
    /** O template da última imagem de impressao digital capturada */
    public Template template;
    // lista de observers desta classe
    private Set<FingerprintEngineObserver> fingerPrintEngineObservers = new HashSet<FingerprintEngineObserver>();

    private FingerprintEngine() {
        super();
        startListenSensor();
    }

    public static FingerprintEngine getInstance() {
        if (instance == null) {
            instance = new FingerprintEngine();
        }
        return instance;
    }

    public Set<FingerprintEngineObserver> getObservers() {
        return fingerPrintEngineObservers;
    }

    public boolean startObserve(FingerprintEngineObserver observer) {
        return fingerPrintEngineObservers.add(observer);
    }

    public boolean stopObserve(FingerprintEngineObserver observer) {
        return fingerPrintEngineObservers.remove(observer);
    }

    /**
     * Inicializa o Fingerprint SDK e habilita a captura de impressoes.
     */
    public final void startListenSensor() {
        try {
            fingerprintSDK = new MatchingContext();
            //Inicializa a captura de impressao digital.
            GrFingerJava.initializeCapture(this);
        } catch (Exception e) {
            //Se ocorrer um erro, encerra a aplicacao.
            e.printStackTrace();
            //System.exit(1);
        }
    }

    public void onSensorPlug(String idSensor) {
        try {
            GrFingerJava.startCapture(idSensor, this, this);
        } catch (GrFingerJavaException e) {
            e.printStackTrace();
        }
    }

    public void onSensorUnplug(String idSensor) {
        try {
            GrFingerJava.stopCapture(idSensor);
        } catch (GrFingerJavaException e) {
            e.printStackTrace();
        }
    }

    public void onImageAcquired(String string, FingerprintImage fingerprintImage) {
        this.fingerprintImage = fingerprintImage;
        sendFingerprint(fingerprintImage);
        try {
            //Extrai a planta da imagem.
            template = fingerprintSDK.extract(fingerprintImage);
            //Mostra a planta na imagem
            sendFingerprintTemplate(GrFingerJava.getBiometricImage(template, fingerprintImage));
        } catch (GrFingerJavaException gre) {
            gre.printStackTrace();
        }
    }

    public void onFingerDown(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void onFingerUp(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean sendFingerprint(FingerprintImage fingerprintImage) {
        for (FingerprintEngineObserver fingerPrintEngineObserver : fingerPrintEngineObservers) {
            fingerPrintEngineObserver.notifyImageAcquired(fingerprintImage);
        }
        return true;
    }

    public boolean sendFingerprintTemplate(BufferedImage templateImage) {
        for (FingerprintEngineObserver fingerPrintEngineObserver : fingerPrintEngineObservers) {
            fingerPrintEngineObserver.notifyTemplateExtracted(templateImage);
        }
        return true;
    }

    public boolean sendSimilarities(BufferedImage fingerprintImage) {
        for (FingerprintEngineObserver fingerprintEngineObserver : fingerPrintEngineObservers) {
            fingerprintEngineObserver.showSimilarities(fingerprintImage);
        }
        return true;
    }

    /**
     * Extrai a planta da imagem da impressao atual.
     */
    private void extract() {

        try {
            //Extrai a planta da imagem.
            template = fingerprintSDK.extract(fingerprintImage);
            //Mostra a planta na imagem
            sendFingerprintTemplate(GrFingerJava.getBiometricImage(template, fingerprintImage));
        } catch (GrFingerJavaException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param pessoa
     * verifica se uma impressao digital e a mesma de um usuário especifico na base de dados
     */
    public boolean checkFingerprint(byte[] fingerprintData) {
        try {

            //Obtem a planta correspondente a pessoa indicada
            Template referenceTemplate = new Template(fingerprintData);

            //compara as plantas (atual vs base de dados)
            boolean areSame = fingerprintSDK.verify(template, referenceTemplate);

            //Se correspondem, desenha o mapa de correspondencia e retorna true
            if (areSame) {
                sendSimilarities(GrFingerJava.getBiometricImage(template, fingerprintImage, fingerprintSDK));
            }
            return areSame;
        } catch (GrFingerJavaException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     * Estabelece o diretorio onde ficam as bibliotecas nativas do SDK da Griaule
     */
    static {
        File directory = new File("/home/emiliowl/Griaule/Fingerprint SDK Java 2009/bin");
        try {
            GrFingerJava.setNativeLibrariesDirectory(directory);
            GrFingerJava.setLicenseDirectory(directory);
        } catch (GrFingerJavaException e) {
            e.printStackTrace();
        }
    }
}
