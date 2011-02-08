package uk.co.dailymail.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import uk.co.dailymail.dao.GenericDao;
import uk.co.dailymail.domain.util.DomainObjects;

import java.util.List;

/**
 * User: Karl Bennett
 * Date: 27-Jan-2011
 */

public class HibernateDao implements GenericDao {

    private SessionFactory sessionFactory;

    private Transaction transaction;

    public HibernateDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private void startTransaction() {
        transaction = getSession().beginTransaction();
    }

    private void stopTransaction() {
        transaction.commit();
        transaction = null;
    }

    @Override
    public <D> void creat(D domainObject) {
        startTransaction();
        getSession().save(domainObject);
        stopTransaction();
    }

    @Override
    public <D, I> D retrieve(Class<D> type, I id) {
        startTransaction();
        Criteria criteria = getSession().createCriteria(type);
        criteria.add(Restrictions.eq(DomainObjects.getIdName(type), id));
        criteria.setMaxResults(1);
        D domainObject = (D) criteria.uniqueResult();
        stopTransaction();

        return domainObject;
    }

    @Override
    public <D> List<D> retrieveAll(Class<D> type) {
        startTransaction();
        List<D> domainObjects = getSession().createCriteria(type).list();
        stopTransaction();

        return domainObjects;
    }

    @Override
    public <D> void update(D domainObject) {
        startTransaction();
        getSession().update(domainObject);
        stopTransaction();
    }

    @Override
    public <D> void delete(D domainObject) {
        startTransaction();
        getSession().delete(domainObject);
        stopTransaction();
    }
}
