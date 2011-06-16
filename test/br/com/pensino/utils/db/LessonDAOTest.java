/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import java.util.Date;
import br.com.pensino.domain.model.Course;
import br.com.pensino.domain.model.Discipline;
import br.com.pensino.domain.model.Employee;
import br.com.pensino.domain.model.Employee.Function;
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
    
    private Employee professor = new Employee("prof", "giraffales", CPF, "006970594", Function.PROFESSOR);
    private Discipline discipline = new Discipline("java", "OO programming language", 10);
    private Employee coordinator = new Employee("Jhon", "Rambo", CPF, "007111", Function.COORDENADOR);
    private Course course = new Course("ingles", "go go go", "bla", 1);
    private Grid grid = new Grid(course, discipline);
    private TimeTable timeTable = new TimeTable(professor, grid);
    private ExpedientTimeTable expedientTimeTable = new ExpedientTimeTable(timeTable);
    private Student student1 = new Student("aluno", "sob_aluno", "37374688857", "09884");
    private Student student2 = new Student("aluno2", "sob_aluno2", "62221666283", "09884");

    @Test
    public void shouldSaveLessonToDB() {
        Lesson lesson = new Lesson(expedientTimeTable, new Date(), new Date(), new Date());
        assertTrue(lessonDAO.save(lesson));
    }
}