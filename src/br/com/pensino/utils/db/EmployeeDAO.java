/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.Employee;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author emiliowl
 */
public class EmployeeDAO {

    PensinoDAO pensinoDAO = PensinoDAO.getInstance();
    Session session;

    public EmployeeDAO() {
        super();
        session = pensinoDAO.openSession();
    }

    public List<Employee> all() {
        try {
            Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class);
            List<Employee> employeeList = criteria.list();
            System.out.print(employeeList);
            tx.commit();
            return employeeList;
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
