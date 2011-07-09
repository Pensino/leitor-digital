/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author emiliowl
 */
@Entity
@Table(name = "expedient_time_tables")
public class ExpedientTimeTable implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="time_table_id")
    private TimeTable timeTable;

    //for hibernate usage only
    protected ExpedientTimeTable() {
        super();
    }

    public ExpedientTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }
    
    public Employee getProfessor() {
        return this.timeTable.getProfessor();
    }
    
    public Set<Student> getEnrolled() {
        return timeTable.getEnrolled();
    }
}
