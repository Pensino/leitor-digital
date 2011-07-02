/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import java.util.Date;
import br.com.pensino.domain.model.Course;
import br.com.pensino.domain.model.Discipline;
import br.com.pensino.domain.model.Employee;
import br.com.pensino.domain.model.ExpedientTimeTable;
import br.com.pensino.domain.model.Grid;
import br.com.pensino.domain.model.Lesson;
import br.com.pensino.domain.model.Student;
import br.com.pensino.domain.model.TimeTable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class LessonDAOTest {

    public static final String CPF = "37374688857";
    private LessonDAO lessonDAO = new LessonDAO();
    private Employee professor = new Employee("lucas", "angelino", "58435348393", "00998877", Employee.Function.PROFESSOR);
    private Discipline discipline = new Discipline("java", "OO programming language", 10);
    private Course course = new Course("ingles", "go go go", Course.Category.BIMESTRAL, 1);
    private Grid grid = new Grid(course, discipline);
    private TimeTable timeTable = new TimeTable(professor, grid);
    private ExpedientTimeTable expedientTimeTable = new ExpedientTimeTable(timeTable);
    private Student emilio = new Student("emilio", "sob_aluno", "37374688857", "09884");
    private Student paulo = new Student("paulo", "sob_aluno2", "33166403809", "09884");

    @Test
    public void shouldSaveLessonToDB() {
        Lesson lesson = new Lesson(expedientTimeTable, new Date(), new Date(), new Date());
        assertTrue(lessonDAO.save(lesson));
    }

    @Test
    public void shouldRetrieveLessonFromDB() {
        Lesson lesson = lessonDAO.find(11);
        assertNotNull(lesson);
        assertTrue(lesson.getProfessor().equals(professor));
    }

    @Test
    public void shouldRetrieveCurrentLessons() {
        assertTrue(lessonDAO.findCurrentLessons().size() > 0);
    }

    @Test
    public void shouldInitializeLesson() {
        Lesson lesson = lessonDAO.find(11);
        lesson.start();
        lessonDAO.save(lesson);
        assertTrue(lesson.isStarted());
    }

    @Test
    public void shouldRetrieveCurrentLessonsByProfessor() {
        Lesson lesson = lessonDAO.findCurrentLesson(professor);
        assertTrue(lesson.getProfessor().equals(professor));
    }
}