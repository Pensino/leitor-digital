/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.com.pensino.domain.model.Employee.Function;
import java.util.TreeSet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class LessonTest {

    public static final String CPF = "37374688857";
    
    private Employee profGiraffales = new Employee("prof", "giraffales", CPF, "006970594", Function.PROFESSOR);
    private Discipline javaDiscipline = new Discipline("java", "OO programming language", 10);
    private Course englishCourse = new Course("ingles", "go go go", Course.Category.BIMESTRAL, 1);
    private Grid grid = new Grid(englishCourse, javaDiscipline);
    private Student zezinho = new Student("Zezinho", "sob_aluno", "37808298867", "09884");
    private Student huguinho = new Student("Huguinho", "sob_aluno2", "62221666283", "09884");
    private Set<Student> enrolledStudents = new TreeSet<Student>();
    private TimeTable timeTable;
    private ExpedientTimeTable expedientTimeTable;
    private Lesson lessonForTests;

    @Before
    public void start() {
        enrolledStudents.add(zezinho);
        enrolledStudents.add(huguinho);
        timeTable = new TimeTable(profGiraffales, grid, enrolledStudents);
        expedientTimeTable = new ExpedientTimeTable(timeTable);
        lessonForTests = new Lesson(expedientTimeTable, new Date(), new Date(), new Date());
    }

    @Test
    public void shouldStartLesson() {        
        lessonForTests.start();
        
        assertTrue(lessonForTests.isStarted());
    }

    @Test
    public void shouldFinishLesson() {        
        lessonForTests.start();
        lessonForTests.finish();
        
        assertTrue(lessonForTests.isFinished());
    }

    @Test
    public void shouldRecordPresence() {
        lessonForTests.start();
        lessonForTests.givePresence(zezinho);

        assertFalse("Aluno não deveria estar com falta.", lessonForTests.isAbsent(zezinho));
    }

    @Test(expected = NotEnrolledStudentException.class)
    public void shouldLaunchExceptionWhenNotEnrolledStudentTryToGetPresenceOnLesson() {
        Student notEnrolledStudent = new Student("Robert", "Downey Jr.", CPF, "091111");
        
        lessonForTests.start();

        lessonForTests.givePresence(notEnrolledStudent);
    }

    @Test
    public void shouldReturnFormatedDataAsHHMM() {
        Date now = new Date();
        
        lessonForTests.setStartTime(now);
        lessonForTests.setEndTime(now);
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM");
        
        assertTrue(sdf.format(now).equals(lessonForTests.getStartTimeFormated()));
        assertTrue(sdf.format(now).equals(lessonForTests.getEndTimeFormated()));
    }

    @Test
    public void shouldReturnLessonsProfessor() {
        assertNotNull(lessonForTests.getProfessor());
        assertTrue(lessonForTests.getProfessor().equals(profGiraffales));
    }

    @Test
    public void shouldInitializeLessonWithAllStudentsAbsent() {
        lessonForTests.start();

        assertFalse("A lista de alunos matriculados não deveria estar vazia", lessonForTests.getEnrolled().isEmpty());
        for (Student enrolledStudent : lessonForTests.getEnrolled()) {
            assertTrue("O aluno matriculado deveria estar ausente", lessonForTests.isAbsent(enrolledStudent));
        }
    }
    
}