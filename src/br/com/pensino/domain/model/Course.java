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
class Course implements Serializable, Comparable<Course> {

    private String name;
    private String description;
    private String category;
    private int step;

    public Course(String name, String description, String category, int step) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Curso precisa ter um nome");
        } else if (category == null || category.equals("")) {
            throw new IllegalArgumentException("Curso deve ter uma categoria");
        } else if (step <= 0) {
            throw new IllegalArgumentException("Curso deve possuir uma grade");
        }
        this.name = name;
        this.description = description;
        this.category = category;
        this.step = step;
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
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
