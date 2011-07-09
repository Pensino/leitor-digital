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
import javax.persistence.CascadeType;
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
    @ManyToOne(cascade= CascadeType.ALL)
    private ExpedientTimeTable expedientTimeTable;
    private Boolean started = false;
    private Boolean finished = false;
    @Temporal(TemporalType.DATE)
    private Date lessonDate;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    private Set<Student> absent = new TreeSet<Student>();
    

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
        this.absent = getEnrolled();
    }

    public void finish() {
        this.finished = true;
    }

    public void givePresence(Student student) {
        if (getEnrolled().contains(student)) {
            this.absent.remove(student);
        } else {
            throw new NotEnrolledStudentException();
        }
    }

    public Boolean isAbsent(Student student) {
        return this.absent.contains(student);
    }

    public Date getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(Date lessonDate) {
        this.lessonDate = lessonDate;
    }

    public Set<Student> getAbsent() {
        return absent;
    }

    public Boolean isStarted() {
        return started;
    }
    
    public Boolean isFinished() {
        return finished;
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
    
    public Employee getProfessor() {
        return this.expedientTimeTable.getProfessor();
    }

    public String formatDateTime(Date dateToFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM");
        return sdf.format(dateToFormat);
    }
    
    public Set<Student> getEnrolled() {       
        return expedientTimeTable.getEnrolled();
    }
}