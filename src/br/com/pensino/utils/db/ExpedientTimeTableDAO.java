/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.ExpedientTimeTable;
import java.util.Collection;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 *
 * @author emiliowl
 */
class ExpedientTimeTableDAO implements DataAccessObject<ExpedientTimeTable> {

    PensinoDAO pensinoDAO = PensinoDAO.getInstance();
    Session session;
    
    public ExpedientTimeTableDAO() {
        super();
        session = pensinoDAO.openSession();
    }
    
    @Override
    public Collection<ExpedientTimeTable> all() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ExpedientTimeTable find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean save(ExpedientTimeTable expedientTimeTable) {
        try {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(expedientTimeTable);
            tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
