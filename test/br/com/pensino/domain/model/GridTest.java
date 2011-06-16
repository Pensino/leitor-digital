/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.domain.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class GridTest {

    private Course course = new Course("ingles", "go go go", "bla", 1);
    private Discipline discipline = new Discipline("java", "OO programming language", 10);

    @Test
    public void shouldInstantiateNewGridWithMinimalCourseAndDiscipline() {
        assertNotNull(new Grid(course, discipline));
    }
}
