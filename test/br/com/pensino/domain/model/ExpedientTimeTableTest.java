/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Before;
import br.com.pensino.domain.model.Employee.Function;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class ExpedientTimeTableTest {

    public static final String CPF = "37374688857";
    private Employee professor = new Employee("prof", "giraffales", CPF, "006970594", Function.PROFESSOR);
    Course course = new Course("ingles", "go go go", Course.Category.BIMESTRAL, 1);
    private Discipline discipline = new Discipline("java", "OO programming language", 10);
    private Student zezinho = new Student("Zezinho", "sob_aluno", "37808298867", "09884");
    private Student huguinho = new Student("Huguinho", "sob_aluno2", "62221666283", "09884");
    Enrollment zezinhoEnrollment = new Enrollment(zezinho);
    Enrollment huguinhoEnrollment = new Enrollment(huguinho);
    Grid grid = new Grid(course, discipline);
    Set<Enrollment> enrolledStudents = new TreeSet<Enrollment>();
    private TimeTable timeTable;
    
    @Before
    public void start() {
        enrolledStudents.add(zezinhoEnrollment);
        enrolledStudents.add(huguinhoEnrollment);
        timeTable = new TimeTable(professor, grid, enrolledStudents);
    }

    @Test
    public void shouldInstantiateNewExpedientTimeTable() {
        assertNotNull(new ExpedientTimeTable(timeTable));
    }
}
