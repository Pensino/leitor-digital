/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author emiliowl
 */
@Entity(name = "enrollments")
public class Enrollment implements Serializable, Comparable<Enrollment> {

    @Id
    @GeneratedValue
    int id;
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="student_id")
    private Student student;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="time_table_id")
    TimeTable timeTable;
    
    //hibernate usage only
    protected Enrollment() {
        super();
    }
    
    public Enrollment(Student student) {
        this.student = student;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public int getId() {
        return id;
    }

    public TimeTable getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }
    
    @Override
    public int compareTo(Enrollment enrollment) {
        return this.id - enrollment.getId();
    }
    
}
