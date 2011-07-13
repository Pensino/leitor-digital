/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    @ManyToOne(cascade= CascadeType.ALL)
    Employee employee;
    @OneToOne(cascade= CascadeType.ALL)
    Grid grid;
    @OneToOne (mappedBy="timeTable")
    ExpedientTimeTable expedientTimeTable;
    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    Set<Student> enrollments = new TreeSet<Student>();
    
    //hibernate usage only
    protected TimeTable() {
        super();
    }

    public TimeTable(Employee professor, Grid grid, Set<Student> enrolledStudents) {
        if (professor == null || grid == null) {
            throw new IllegalArgumentException("Cannot construct TimeTable with null parameters");
        } else if (professor.getFunction() != Employee.Function.PROFESSOR) {
            throw new IllegalArgumentException("Cannot construct TimeTable with Employee not professor.");
        } else if (enrolledStudents == null || enrolledStudents.size() == 0) {
            throw new IllegalArgumentException("Cannot construct TimeTable without enrolled students..");
        }
        this.employee = professor;
        this.grid = grid;
        this.enrollments = enrolledStudents;
    }
    
    public Employee getProfessor() {
        return this.employee;
    }
    
    public Set<Student> getEnrolled() {
        return enrollments;
    }
}
