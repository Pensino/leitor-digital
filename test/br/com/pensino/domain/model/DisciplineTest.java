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
public class DisciplineTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateDisciplineWithoutName() {
        new Discipline("", "description", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateDisciplineWithoutQuantityLesson() {
        new Discipline("Name", "description", 0);
    }

    @Test
    public void disciplinesWithSameNameMustBeEquals() {
        assertEquals(new Discipline("name", "123", 10), (new Discipline("name", "456", 20)));
    }
}
