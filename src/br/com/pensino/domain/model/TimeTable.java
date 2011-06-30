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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author emiliowl
 */
@Entity
@Table(name = "time_tables")
public class TimeTable implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    Employee employee;
    @OneToOne
    Grid grid;
    @OneToOne (mappedBy="timeTable")
    ExpedientTimeTable expedientTimeTable;

    //hibernate usage only
    protected TimeTable() {
        super();
    }

    public TimeTable(Employee professor, Grid grid) {
        if (professor == null || grid == null) {
            throw new IllegalArgumentException("Cannot construct TimeTable with null parameters");
        } else if (professor.getFunction() != Employee.Function.PROFESSOR) {
            throw new IllegalArgumentException("Cannot construct TimeTable with Employee not professor.");
        }
        this.employee = professor;
        this.grid = grid;
    }
}
