/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author emiliowl
 */
@Entity
@Table(name = "employees")
public class Employee implements Serializable, Comparable<Employee> {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "first_name")
    private String firstName = "";
    @Column(name = "last_name")
    private String lastName = "";
    private String document = "";
    @Column(name = "registration")
    private String register = "";
    private Boolean professor = false;
    private Boolean coordinator = false;
    @OneToMany(cascade= CascadeType.REMOVE, fetch= FetchType.EAGER)
    private Collection<Fingerprint> fingerprint = new ArrayList<Fingerprint>();

    public Employee(String firstName, String lastName, String document, String register, Function function) {
        if (firstName == null || firstName.trim().equals("")) {
            throw new IllegalArgumentException("Empregado precisa ter um nome");
        } else if (lastName == null || lastName.trim().equals("")) {
            throw new IllegalArgumentException("Empregado deve ter um sobrenome");
        } else if (document == null || document.trim().equals("")) {
            throw new IllegalArgumentException("Empregado deve possuir um documento");
        } else if (register == null || register.trim().equals("")) {
            throw new IllegalArgumentException("Empregado deve possuir um registro");
        } else if (function.equals(Function.COORDENADOR)) {
            coordinator = true;
        } else if (function.equals(Function.PROFESSOR)) {
            professor = true;
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.register = register;
    }

    public Employee() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Employee)) {
            return false;
        } else if (((Employee) obj).getDocument().trim().equals("")) {
            return false;
        }
        return document.equals(((Employee) obj).getDocument());
    }

    @Override
    public int hashCode() {
        return document.hashCode();
    }

    @Override
    public int compareTo(Employee o) {
        return document.compareTo(o.getDocument());
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName + " [" + document + "]"; 
    }

    public enum Function {

        COORDENADOR,
        PROFESSOR;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Function getFunction() {
        if (professor) {
            return Function.PROFESSOR;
        } else if (coordinator) {
            return Function.COORDENADOR;
        } else {
            throw new IllegalStateException("O empregado possui função desconhecida.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Collection<Fingerprint> getFingerprintList() {
        return fingerprint;
    }

    public boolean addFingerprint(Fingerprint fingerprint) {
        return this.fingerprint.add(fingerprint);
    }
}
