/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.fingerPrint;

import com.griaule.grfingerjava.FingerprintImage;
import java.awt.image.BufferedImage;

/**
 *
 * @author emiliowl
 */
public interface FingerprintEngineObserver {
    
    boolean notifyImageAcquired(FingerprintImage fingerprintImage);
    boolean notifyTemplateExtracted(BufferedImage templateImage);
    
}
