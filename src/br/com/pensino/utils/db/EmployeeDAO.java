/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.Employee;
import java.util.List;
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
            tx.commit();
            return employeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

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
            TreeSet<Employee> employeeSet = new TreeSet<Employee>();
            List<Employee> employeeList = session.createCriteria(Employee.class).add(Restrictions.like("firstName", partOfName, MatchMode.ANYWHERE)).list();
            employeeList.addAll(session.createCriteria(Employee.class).add(Restrictions.like("lastName", partOfName, MatchMode.ANYWHERE)).list());
            for (Employee employee : employeeList) {
                employeeSet.add(employee);
            }

            employeeList.clear();
            employeeList.addAll(employeeSet);
            tx.commit();
            return employeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

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

    @Override
    protected void finalize() throws Throwable {
        session.close();
        super.finalize();
    }

    public static class By {

        public static Integer id(Integer id) {
            return id;
        }

        public static String partOfName(String partOfName) {
            return partOfName;
        }
    }
}
