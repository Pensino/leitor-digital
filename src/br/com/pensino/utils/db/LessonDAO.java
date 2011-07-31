/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pensino.utils.db;

import br.com.pensino.domain.model.Employee;
import br.com.pensino.domain.model.Lesson;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author emiliowl
 */
public class LessonDAO implements DataAccessObject<Lesson> {

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
        try {
            Transaction tx = session.beginTransaction();
            Lesson lesson = (Lesson) session.load(Lesson.class, id);
            tx.commit();
            return lesson;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Lesson> findCurrentLessons() {
        try {
            Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Lesson.class);
            criteria.add(Restrictions.le("startTime", new Date())).add(Restrictions.ge("endTime", new Date()));
            List<Lesson> lessonsList = criteria.list();
            tx.commit();
            return lessonsList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Lesson findCurrentLesson(Employee employee) {
        List<Lesson> lessonList = this.findCurrentLessons();
        for (Lesson lesson : lessonList) {
            if (lesson.getProfessor().equals(employee)) {
                return lesson;
            }
        }
        return null;
    }

    @Override
    public boolean save(Lesson lesson) {
        try {
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
