/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author emiliowl
 */
@Entity
@Table(name = "employees")
public class Employee implements Serializable, Comparable<Employee>, Person {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "first_name")
    private String firstName = "";
    @Column(name = "last_name")
    private String lastName = "";
    @Column(unique = true)
    private String document = "";
    @Column(name = "registration", unique = true)
    private String register = "";
    private Boolean professor = false;
    private Boolean coordinator = false;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Fingerprint> fingerprint = new HashSet<Fingerprint>();

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
        this.setDocument(document);
        this.register = register;
    }

    //for hibernate usage only
    protected Employee() {
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

    @Override
    public String getDocument() {
        return document;
    }

    public void setDocument(String document) throws InvalidStateException {
        new CPFValidator(new SimpleMessageProducer(), false, false).assertValid(document);
        this.document = document;
    }

    @Override
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

    @Override
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

    public Set<Fingerprint> getFingerprintList() {
        return fingerprint;
    }

    public boolean addFingerprint(Fingerprint fingerprint) {
        return this.fingerprint.add(fingerprint);
    }
}
