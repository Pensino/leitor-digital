/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.Fingerprint;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.Session;


/**
 *
 * @author emiliowl
 */
public class FingerprintDAO implements DataAccessObject<Fingerprint> {
    
    PensinoDAO pensinoDAO = PensinoDAO.getInstance();
    Session session;
    
    public FingerprintDAO() {
        super();
        session = pensinoDAO.openSession();
    }
    
    @Override
    public boolean save(Fingerprint fingerprint) {
        try {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(fingerprint);
            tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<Fingerprint> all() {
        try {
            Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Fingerprint.class);
            List<Fingerprint> fingerprintList = criteria.list();
            tx.commit();
            return fingerprintList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Fingerprint find(Integer id) {
        try {
            Transaction tx = session.beginTransaction();
            Fingerprint fingerprint = (Fingerprint)session.load(Fingerprint.class, id);
            tx.commit();
            return fingerprint;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    protected void finalize() throws Throwable {
        session.close();
        super.finalize();
    }
    
}
