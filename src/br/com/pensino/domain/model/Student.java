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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author emiliowl
 */
@Entity
@Table(name = "students")
public class Student implements Person, Comparable<Student>, Serializable, Cloneable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "first_name")
    private String firstName = "";
    @Column(name = "last_name")
    private String lastName = "";
    @Column(unique=true)
    private String document = "";
    @Column(name = "registration", unique=true)
    private String register = "";
    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
    private Set<Fingerprint> fingerprint = new HashSet<Fingerprint>();
    
    //for hibernate usage only
    protected Student() {
        super();
    }
    
    public Student(Integer id, Set<Fingerprint> fingerprint, String firstName, String lastName, String document, String registration) {
        this(firstName, lastName, document, registration);
        this.id = id;
        this.fingerprint = fingerprint;
    }

    public Student(String firstName, String lastName, String document, String registration) {
        if (firstName == null || firstName.trim().equals("")) {
            throw new IllegalArgumentException("Estudante deve possuir um nome");
        } else if (lastName == null || lastName.trim().equals("")) {
            throw new IllegalArgumentException("Estudante deve possuir um sobrenome");
        } else if (registration == null || registration.trim().equals("")) {
            throw new IllegalArgumentException("Estudante deve possuir um registro");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.setDocument(document);
        this.register = registration;
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
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRegistration() {
        return register;
    }

    public void setRegistration(String registration) {
        this.register = registration;
    }
    
    public Set<Fingerprint> getFingerprintList() {
        return fingerprint;
    }

    public boolean addFingerprint(Fingerprint fingerprint) {
        return this.fingerprint.add(fingerprint);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj == null) {
            result = false;
        } else if (!(obj instanceof Student)) {
            result = false;
        } else if (((Student) obj).getDocument().equals(this.document)) {
            result = true;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return document.hashCode();
    }

    @Override
    public int compareTo(Student otherStudent) {
        return this.document.compareTo(otherStudent.getDocument());
    }

    @Override
    public Student clone() {
        Student clone = new Student(id, fingerprint, firstName, lastName, document, register);
        return clone;
    }
        
}
