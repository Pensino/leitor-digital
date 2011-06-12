/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import br.com.pensino.domain.model.Employee.Function;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class LessonTest {
    public static final String CPF = "37374688857";

    private Employee professor = new Employee("prof", "giraffales", CPF, "006970594", Function.PROFESSOR);
    private Discipline discipline = new Discipline("java", "OO programming language", 10);
    private Employee coordinator = new Employee("Jhon", "Rambo", CPF, "007111", Function.COORDENADOR);

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotStartClassWithEmployeeNotProfessor() {
        new Lesson(coordinator, discipline);
    }

    @Test
    public void shouldStartKlass() {
        //TODO: review english words and sentences
        Lesson lesson = new Lesson(professor, discipline);
        lesson.start();
        assertTrue(lesson.isStarted());
    }

    @Test
    public void shouldFinishKlass() {
        Lesson lesson = new Lesson(professor, discipline);
        lesson.start();
        lesson.finish();
        assertFalse(lesson.isStarted());
    }

    @Test
    public void shouldRecordPresence() {
        Lesson lesson = new Lesson(professor, discipline);
        lesson.start();

        Student student = new Student("Robert", "Downey Jr.", CPF, "091111");
        lesson.givePresence(student);

        assertTrue(lesson.isPresent(student));
    }

    @Test
    public void shouldReturnFormatedDataAsHHMM() {
        Lesson lesson = new Lesson(professor, discipline);
        Date now = new Date();
        lesson.setStartTime(now);
        lesson.setEndTime(now);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM");
        assertTrue(sdf.format(now).equals(lesson.getStartTimeFormated()));
        assertTrue(sdf.format(now).equals(lesson.getEndTimeFormated()));
    }
}