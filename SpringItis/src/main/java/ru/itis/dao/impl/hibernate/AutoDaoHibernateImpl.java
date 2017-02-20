package ru.itis.dao.impl.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.dao.AutoDao;
import ru.itis.model.Auto;

import java.util.List;

/**
 * 20.02.2017
 * AutoDaoHibernateImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component("hibernate.auto.dao")
public class AutoDaoHibernateImpl implements AutoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long save(Auto auto) {
        return null;
    }

    @Override
    public void update(Auto auto) {

    }

    @Override
    public Auto find(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Auto> findAll() {
        Session currentSession = getSession();
        currentSession.beginTransaction();
        List<Auto> autoList = currentSession.createQuery("from Auto", Auto.class).list();
        return autoList;
    }

    @Override
    public List<Auto> findAllByUserId(Long userId) {
        return null;
    }

    private Session getSession() {
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        return session;
    }
}
