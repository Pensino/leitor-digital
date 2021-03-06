/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author emiliowl
 */
@Entity
@Table(name="fingerprints")
public class Fingerprint implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "fingerprint_data")
    private byte[] fingerprintData;
    
    public Fingerprint() {
        super();
    }
    
    public Fingerprint(byte[] fingerprintData) {
        this.fingerprintData = fingerprintData;
    }
    
    public byte[] getFingerprintData() {
        return fingerprintData;
    }
   
}
