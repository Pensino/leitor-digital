/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author emiliowl
 */
@Entity
@Table(name="matters")
public class Discipline implements Serializable, Comparable<Discipline> {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private Integer quantityLesson;

    //hibernate usage only
    protected Discipline() {
        super();
    }
    
    public Discipline(String name, String description, int quantityLesson) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Disciplina deve possuir um nome");
        }
        if (quantityLesson <= 0) {
            throw new IllegalArgumentException("Disciplina deve ter número de aulas maior que ZERO");
        }
        this.name = name;
        this.description = description;
        this.quantityLesson = quantityLesson;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Discipline)) {
            return false;
        } else {
            return this.name.equals(((Discipline) obj).name);
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Discipline o) {
        return name.compareTo(o.name);
    }
}
