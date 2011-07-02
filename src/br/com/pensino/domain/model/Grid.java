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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author emiliowl
 */
@Entity
@Table(name = "grids")
public class Grid implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Cascade(CascadeType.ALL)
    @ManyToOne
    private Course course;
    @Cascade(CascadeType.ALL)
    @ManyToOne
    private Discipline discipline;

    //for hibernate usage only
    protected Grid() {
        super();
    }

    public Grid(Course course, Discipline discipline) {
        this.course = course;
        this.discipline = discipline;
    }

    public Course getCourse() {
        return course;
    }

    public Discipline getDiscipline() {
        return discipline;
    }
}
