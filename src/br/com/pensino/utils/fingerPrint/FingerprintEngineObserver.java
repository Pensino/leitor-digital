/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.fingerPrint;

import java.awt.image.BufferedImage;

/**
 *
 * @author emiliowl
 */
public interface FingerprintEngineObserver {
    
    boolean notifyImageAcquired(BufferedImage fingerprintImage);
    boolean notifyTemplateExtracted(BufferedImage templateImage, byte[] templateData);
    boolean showSimilarities(BufferedImage fingerprintImage);

    public void notifyFingerDown();

    public void notifyFingerUp();
    
}
