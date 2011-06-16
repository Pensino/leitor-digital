/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.Lesson;
import java.util.Collection;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author emiliowl
 */
class LessonDAO implements DataAccessObject<Lesson> {
    
    PensinoDAO pensinoDAO = PensinoDAO.getInstance();
    Session session;
    
    public LessonDAO() {
        super();
        session = pensinoDAO.openSession();
    }
    

    @Override
    public Collection<Lesson> all() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Lesson find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean save(Lesson lesson) {
        try {
            boolean result;
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(lesson);
            tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
