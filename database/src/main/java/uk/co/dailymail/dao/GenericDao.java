package uk.co.dailymail.dao;

import java.util.List;

/**
 * User: Karl Bennett
 * Date: 27-Jan-2011
 */
public interface GenericDao {

    public <D> void creat(D domainObject);

    public <D, I> D retrieve(Class<D> type, I id);

    public <D> List<D> retrieveAll(Class<D> type);

    public <D> void update(D domainObject);

    public <D> void delete(D domainObject);
}
