/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author emiliowl
 */
@Entity
@Table(name = "lessons")
public class Lesson implements Serializable {

    @Id
    @GeneratedValue
    Integer id;
    @ManyToOne
    @Column(name = "expedient_time_tables")
    private ExpedientTimeTable expedientTimeTable;
    private Boolean started;
    @Temporal(TemporalType.DATE)
    private Date lessonDate;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Student> presents = new TreeSet<Student>();

    public Lesson(ExpedientTimeTable expedientTimeTable, Date lessonDate, Date startTime, Date endTime) {
        this.expedientTimeTable = expedientTimeTable;
        this.lessonDate = lessonDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //for hibernate usage only
    protected Lesson() {
    }

    public void start() {
        this.started = true;
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

    public Date getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(Date lessonDate) {
        this.lessonDate = lessonDate;
    }

    public Set<Student> getPresents() {
        return presents;
    }

    public void setPresents(Set<Student> presents) {
        this.presents = presents;
    }

    public Boolean isStarted() {
        return started;
    }

    public String getEndTimeFormated() {
        return formatDateTime(endTime);
    }

    public String getStartTimeFormated() {
        return formatDateTime(startTime);
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String formatDateTime(Date dateToFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM");
        return sdf.format(dateToFormat);
    }
}