/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

/**
 *
 * @author emiliowl
 */
class Student {

    private String name;
    private String lastName;
    private String document;
    private String registration;
    private byte[] fingerprintData;

    Student(String firstName, String lastName, String document, String registration) {
        if (firstName == null || firstName.trim().equals("")) {
            throw new IllegalArgumentException("Estudante deve possuir um nome");
        } else if (lastName == null || lastName.trim().equals("")) {
            throw new IllegalArgumentException("Estudante deve possuir um sobrenome");
        } else if (registration == null || registration.trim().equals("")) {
            throw new IllegalArgumentException("Estudante deve possuir um registro");
        }

        this.name = firstName;
        this.lastName = lastName;
        this.setDocument(document);
        this.registration = registration;
    }

    public String getDocument() {
        return document;
    }

    public final void setDocument(String document) throws InvalidStateException {
        new CPFValidator(new SimpleMessageProducer(), false, false).assertValid(document);
        this.document = document;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public byte[] getFingerprintData() {
        return fingerprintData;
    }

    public void setFingerprintData(byte[] fingerprintData) {
        this.fingerprintData = fingerprintData;
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
    
    
}
