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
    private Course course = new Course("ingles", "go go go", Course.Category.BIMESTRAL, 1);
    private Grid grid = new Grid(course, discipline);
    private TimeTable timeTable = new TimeTable(professor, grid);
    private ExpedientTimeTable expedientTimeTable = new ExpedientTimeTable(timeTable);
    private Student student1 = new Student("aluno", "sob_aluno", "37374688857", "09884");
    private Student student2 = new Student("aluno2", "sob_aluno2", "62221666283", "09884");

    @Test
    public void shouldStartKlass() {
        Lesson lesson = new Lesson(expedientTimeTable, new Date(), new Date(), new Date());
        lesson.start();
        assertTrue(lesson.isStarted());
    }

    @Test
    public void shouldFinishKlass() {
        Lesson lesson = new Lesson(expedientTimeTable, new Date(), new Date(), new Date());
        lesson.start();
        lesson.finish();
        assertTrue(lesson.isFinished());
    }

    @Test
    public void shouldRecordPresence() {
        Lesson lesson = new Lesson(expedientTimeTable, new Date(), new Date(), new Date());
        lesson.start();

        Student student = new Student("Robert", "Downey Jr.", CPF, "091111");
        lesson.givePresence(student);

        assertTrue(lesson.isPresent(student));
    }

    @Test
    public void shouldReturnFormatedDataAsHHMM() {
        Lesson lesson = new Lesson(expedientTimeTable, new Date(), new Date(), new Date());
        Date now = new Date();
        lesson.setStartTime(now);
        lesson.setEndTime(now);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM");
        assertTrue(sdf.format(now).equals(lesson.getStartTimeFormated()));
        assertTrue(sdf.format(now).equals(lesson.getEndTimeFormated()));
    }

    @Test
    public void shouldReturnLessonsProfessor() {
        Lesson lesson = new Lesson(expedientTimeTable, new Date(), new Date(), new Date());
        assertNotNull(lesson.getProfessor());
        assertTrue(expedientTimeTable.getProfessor().equals(professor));
    }
}