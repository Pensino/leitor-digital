/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author emiliowl
 */
@Entity
@Table(name = "courses")
public class Course implements Serializable, Comparable<Course> {

    public static class Category {
        public static final int SEMANAL = 1;
        public static final int BIMESTRAL = 2;
        public static final int SEMESTRAL = 3;
    }
    
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private Integer category;
    private int steps;
    @ManyToOne
    private Employee employee;
    
    protected Course() {
        super();
    }

    public Course(String name, String description, Integer category, int steps) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Curso precisa ter um nome");
        } else if (category == null) {
            throw new IllegalArgumentException("Curso deve ter uma categoria");
        } else if (steps <= 0) {
            throw new IllegalArgumentException("Curso deve possuir uma grade");
        }
        this.name = name;
        this.description = description;
        this.category = category;
        this.steps = steps;
    }

    @Override
    public int compareTo(Course o) {
        return name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Course)) {
            return false;
        }
        return name.equals(((Course) obj).getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getCategory() {
        return category.toString();
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getSteps() {
        return steps;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
