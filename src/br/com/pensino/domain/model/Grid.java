/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

/**
 *
 * @author emiliowl
 */
public class Grid {

    private Course course;
    private Discipline discipline;

    public Grid(Course course, Discipline discipline) {
        this.course = course;
        this.discipline = discipline;
    }
}
