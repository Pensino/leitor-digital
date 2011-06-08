/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.Fingerprint;
import org.hibernate.Transaction;
import org.hibernate.Session;


/**
 *
 * @author emiliowl
 */
public class FingerprintDAO {
    
    PensinoDAO pensinoDAO = PensinoDAO.getInstance();
    Session session;
    
    public FingerprintDAO() {
        super();
        session = pensinoDAO.openSession();
    }
    
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
}
