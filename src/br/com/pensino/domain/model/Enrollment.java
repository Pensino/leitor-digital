/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author emiliowl
 */
@Entity(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue
    int id;
    @Column(name = "student_id")
    private Student student;
    @Column(name = "time_table_id")
    private TimeTable timeTable;
}
