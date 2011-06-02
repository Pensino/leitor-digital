/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.message;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emiliowl
 */
public class MessageServiceTest {

    public MessageServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldGetMessageByName() {
        assertNotNull(MessageService.getMessage(By.name("msg001")));
    }
}