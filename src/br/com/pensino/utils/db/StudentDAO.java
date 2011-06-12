/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.Student;
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
public class StudentDAO implements DataAccessObject<Student> {

    PensinoDAO pensinoDAO = PensinoDAO.getInstance();
    Session session;

    public StudentDAO() {
        super();
        session = pensinoDAO.openSession();
    }

    @Override
    public List<Student> all() {
        try {
            Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Student.class);
            List<Student> studentList = criteria.list();
            clearCollection(studentList);
            tx.commit();
            return studentList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Student find(Integer id) {
        try {
            Transaction tx = session.beginTransaction();
            Student student = (Student) session.load(Student.class, id);
            tx.commit();
            return student;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Student> find(String partOfName) {
        try {
            Transaction tx = session.beginTransaction();
            List<Student> studentList = session.createCriteria(Student.class).add(Restrictions.like("firstName", partOfName, MatchMode.ANYWHERE)).list();
            studentList.addAll(session.createCriteria(Student.class).add(Restrictions.like("lastName", partOfName, MatchMode.ANYWHERE)).list());
            tx.commit();
            clearCollection(studentList);
            return studentList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Student> find(By criteria, String value){
        try {
            Transaction tx = session.beginTransaction();
            List<Student> studentList = session.createCriteria(Student.class).add(Restrictions.like(criteria.getValue(), value, MatchMode.ANYWHERE)).list();
            tx.commit();
            clearCollection(studentList);
            return studentList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Student student) {
        try {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(student);
            tx.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public void clearCollection(Collection<Student> collection) {
        Set<Student> cleanerSet = new TreeSet<Student>();
        cleanerSet.addAll(collection);
        collection.clear();
        collection.addAll(cleanerSet);
    }

    public enum By {
        ID("id"), FIRST_NAME("first_name"), DOCUMENT("document");
        
        private final String value;
        
        public String getValue() {
            return this.value;
        }
        
        By(String value) {
            this.value = value;
        }
    }
}
