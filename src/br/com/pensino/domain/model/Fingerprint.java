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
    @ManyToOne(fetch= FetchType.EAGER)
    private Employee employee;
    @ManyToOne(fetch= FetchType.EAGER)
    private Student student;
    
    public Fingerprint() {
        super();
    }
    
    public Fingerprint(byte[] fingerprintData, Employee employee) {
        this.fingerprintData = fingerprintData;
        this.employee = employee;
    }
    
    public Fingerprint(byte[] fingerprintData, Student student) {
        this.fingerprintData = fingerprintData;
        this.student = student;
    }
    
    public byte[] getFingerprintData() {
        return fingerprintData;
    }
   
}
