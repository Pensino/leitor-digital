/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import br.com.pensino.domain.model.Employee.Function;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author emiliowl
 */
class Lesson {

    private Employee professor;
    private Discipline discipline;
    private Boolean started;
    private Date lessonDate;
    private Date startTime;
    private Date endTime;
    private List<Student> presents = new ArrayList<Student>();

    public Lesson(Employee professor, Discipline discipline) {
        if (!professor.getFunction().equals(Function.PROFESSOR)) {
            throw new IllegalArgumentException("Somente um professor pode criar uma aula.");
        }
        this.professor = professor;
        this.discipline = discipline;
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

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Date getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(Date lessonDate) {
        this.lessonDate = lessonDate;
    }

    public List<Student> getPresents() {
        return presents;
    }

    public void setPresents(List<Student> presents) {
        this.presents = presents;
    }

    public Employee getProfessor() {
        return professor;
    }

    public void setProfessor(Employee professor) {
        this.professor = professor;
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