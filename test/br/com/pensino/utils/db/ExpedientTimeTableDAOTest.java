/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.Course;
import br.com.pensino.domain.model.Discipline;
import br.com.pensino.domain.model.Employee;
import br.com.pensino.domain.model.Employee.Function;
import br.com.pensino.domain.model.ExpedientTimeTable;
import br.com.pensino.domain.model.Grid;
import br.com.pensino.domain.model.TimeTable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class ExpedientTimeTableDAOTest {

    public static final String CPF = "37374688857";
    private Employee professor = new Employee("John", "Rambo", CPF, "006680594", Employee.Function.PROFESSOR);;
    Course course = new Course("ingles", "go go go", "bla", 1);
    private Discipline discipline = new Discipline("java", "OO programming language", 10);
    Grid grid = new Grid(course, discipline);
    private TimeTable timeTable = new TimeTable(professor, grid);

    @Test
    public void shouldSaveExpedientTimeTableToDB() {
        ExpedientTimeTableDAO expedientTimeTableDAO = new ExpedientTimeTableDAO();
        ExpedientTimeTable expedientTimeTable = new ExpedientTimeTable(timeTable);
        EmployeeDAO dao = new EmployeeDAO();
        GridDAO gridDAO = new GridDAO();
        dao.save(professor);
        assertTrue(expedientTimeTableDAO.save(expedientTimeTable));
    }
}
