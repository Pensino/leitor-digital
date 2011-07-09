/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.Employee;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author emiliowl
 */
public class EmployeeDAO implements DataAccessObject<Employee> {

    PensinoDAO pensinoDAO = PensinoDAO.getInstance();
    Session session;

    public EmployeeDAO() {
        super();
        session = pensinoDAO.openSession();
    }

    public boolean destroy() {
        session.clear();
        session.close();
        return true;
    }

    @Override
    public List<Employee> all() {
        try {
            Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class);
            List<Employee> employeeList = criteria.list();
            clearCollection(employeeList);
            tx.commit();
            return employeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee find(Integer id) {
        try {
            Transaction tx = session.beginTransaction();
            Employee employee = (Employee) session.load(Employee.class, id);
            tx.commit();
            return employee;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Employee> find(String partOfName) {
        try {
            Transaction tx = session.beginTransaction();
            List<Employee> employeeList = session.createCriteria(Employee.class).add(Restrictions.like("firstName", partOfName, MatchMode.ANYWHERE)).list();
            employeeList.addAll(session.createCriteria(Employee.class).add(Restrictions.like("lastName", partOfName, MatchMode.ANYWHERE)).list());
            tx.commit();
            clearCollection(employeeList);
            return employeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Employee> find(By criteria, String value) {
        try {
            Transaction tx = session.beginTransaction();
            List<Employee> employeeList = session.createCriteria(Employee.class).add(Restrictions.like(criteria.getValue(), value, MatchMode.ANYWHERE)).list();
            tx.commit();
            clearCollection(employeeList);
            return employeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Employee employee) {
        try {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(employee);
            tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void clearCollection(Collection<Employee> collection) {
        Set<Employee> cleanerSet = new TreeSet<Employee>();
        cleanerSet.addAll(collection);
        collection.clear();
        collection.addAll(cleanerSet);
    }

    public enum By {

        ID("id"), FIRST_NAME("firstName"), DOCUMENT("document");
        private final String value;

        public String getValue() {
            return this.value;
        }

        By(String value) {
            this.value = value;
        }
    }
}
