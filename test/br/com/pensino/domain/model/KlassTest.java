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
public class KlassTest {

    private Professor professor = new Professor("zé");
    private Discipline discipline = new Discipline("java");

    @Test
    public void shouldStartKlass() {
        //TODO: review english words and sentences
        Klass klass = new Klass(professor, discipline);
        klass.start();
        assertTrue(klass.isStarted());
    }

    @Test
    public void shouldFinishKlass() {
        Klass klass = new Klass(professor, discipline);
        klass.start();
        klass.finish();
        assertFalse(klass.isStarted());
    }

    @Test
    public void shouldAferePresenca() {
        Klass klass = new Klass(professor, discipline);
        klass.start();

        Student student = new Student("Pedro");

        klass.givePresence(student);

        assertTrue(klass.isPresent(student));
    }
}
