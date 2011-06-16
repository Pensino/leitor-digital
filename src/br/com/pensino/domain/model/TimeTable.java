/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

/**
 *
 * @author emiliowl
 */
public class TimeTable {

    Employee professor;
    Grid grid;

    public TimeTable(Employee professor, Grid grid) {
        if (professor == null || grid == null) {
            throw new IllegalArgumentException("Cannot construct TimeTable with null parameters");
        } else if (professor.getFunction() != Employee.Function.PROFESSOR) {
            throw new IllegalArgumentException("Cannot construct TimeTable with Employee not professor.");
        }
        this.professor = professor;
        this.grid = grid;
    }
}
