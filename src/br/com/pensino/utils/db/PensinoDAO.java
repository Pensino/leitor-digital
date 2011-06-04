/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author emiliowl
 */
public class PensinoDAO {
    
    private static PensinoDAO instance;
    private SessionFactory sessionFactory;
    
    public static PensinoDAO getInstance() {
        if (instance == null) {
            instance = new PensinoDAO();
        }
        return instance;    
    }
    
    private PensinoDAO() {
        super();
        configure();
    }
    
    private void configure() {
        AnnotationConfiguration cfg = new AnnotationConfiguration();
        cfg.configure("/config/hibernate.cfg.xml");
                
        sessionFactory = cfg.buildSessionFactory();
    }
    
    public Session openSession() {
        return sessionFactory.openSession();
    }
    
}
