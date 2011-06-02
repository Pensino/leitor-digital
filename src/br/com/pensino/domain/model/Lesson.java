/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emiliowl
 */
class Klass {

    private final Professor professor;
    private final Discipline discipline;
    private Boolean started;
    private List<Student> presents = new ArrayList<Student>();

    public Klass(Professor professor, Discipline discipline) {
        this.professor = professor;
        this.discipline = discipline;
    }

    public void start() {
        this.started = true;
    }

    public Boolean isStarted() {
        return started;
    }

    public void finish() {
        this.started = false;
    }

    public void givePresence(Student student) {
        this.presents.add(student);
    }

    public Boolean isPresent(Student student) {
        return this.presents.contains(student);
    }
}
