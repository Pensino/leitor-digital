/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.io.Serializable;

/**
 *
 * @author emiliowl
 */
class Employee implements Serializable, Comparable<Employee> {

    private String firstName = "";
    private String lastName = "";
    private String document = "";
    private String register = "";
    private Function function;

    Employee(String firstName, String lastName, String document, String register, Function function) {
        if (firstName == null || firstName.trim().equals("")) {
            throw new IllegalArgumentException("Empregado precisa ter um nome");
        } else if (lastName == null || lastName.trim().equals("")) {
            throw new IllegalArgumentException("Empregado deve ter um sobrenome");
        } else if (document == null || document.trim().equals("")) {
            throw new IllegalArgumentException("Empregado deve possuir um documento");
        } else if (register == null || register.trim().equals("")) {
            throw new IllegalArgumentException("Empregado deve possuir um registro");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.register = register;
        this.function = function;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (((Employee) obj).getDocument().trim().equals("")) {
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
        return lastName.compareTo(o.getLastName());
    }

    enum Function {

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
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
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
}
