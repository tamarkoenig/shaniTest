package com.mycompany.test.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Base class for DAO.
 */
@SuppressWarnings("unchecked")
@Repository
public class BaseDaoImpl implements BaseDao {
  @Autowired
  @Qualifier("sessionFactory")
  protected SessionFactory sessionFactory;

  /**
   * Find all entities of given class.
   * @param clazz required class
   * @return list of all entitites
   */
  public <T> List<T> findAll(Class<T> clazz) {
    return sessionFactory.getCurrentSession().createCriteria(clazz).list();
  }

  /**
   * Return entity by given class and UUID.
   * @param clazz required class
   * @param id unique identificator
   * @return entity with given class and UUID.
   */
  public <T extends BaseEntity> T findObject(Class<T> clazz, Serializable id) {
    return (T) sessionFactory.getCurrentSession().get(clazz, id);
  }

  /**
   * Delete entity with given class and UUID from DB
   * @param clazz required class
   * @param id unique identificator
   */
	@SuppressWarnings("rawtypes")
	public void deleteObject(Class clazz, Serializable id) {
    deleteObject(findObject(clazz, id));
	}

  /**
   * Delete entity from DB.
   * @param object entity for removing.
   */
	public void deleteObject(Object object) {
    if (null != object) {
      sessionFactory.getCurrentSession().delete(object);
    }
	}

  /**
   * {@inheritDoc}
   */
  @Override
	public <T extends BaseEntity> T saveOrUpdate(T object) {
    sessionFactory.getCurrentSession().saveOrUpdate(object);
    return object;
	}

  /**
   * {@inheritDoc}
   */
  @Override
  public void flush() {
    sessionFactory.getCurrentSession().flush();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void clear() {
    sessionFactory.getCurrentSession().clear();
  }
  
  /**
   * Set start and limit to criteria if it is given
   * @param criteria target criteria
   * @param start first result starting from 0
   * @param limit maximum of selected items
   */
  protected void setBoundaries(Criteria criteria, Integer start, Integer limit) {
    if (null != start) {
      criteria.setFirstResult(start);
    }

    if (null != limit) {
      criteria.setMaxResults(limit);
    }
  }
  
  /**
   * Set start and limit to query if it is given
   * @param query target query
   * @param start first result starting from 0
   * @param limit maximum of selected items
   */
  protected void setBoundaries(Query query, Integer start, Integer limit) {
    if (null != start) {
    	query.setFirstResult(start);
    }

    if (null != limit) {
    	query.setMaxResults(limit);
    }
  }

  /**
   * Add order by entity create date (from newest to oldest) to criteria
   * @param criteria target criteria
   */
  protected void setOrderByCreationTime(Criteria criteria) {
    criteria.addOrder(Order.desc("creationTime"));
  }

  /**
   * Add order by entity last update date date (from most updated to least updated) to criteria
   * @param criteria target criteria
   */
  protected void setOrderByLastUpdateTime(Criteria criteria) {
      criteria.addOrder(Order.desc("lastUpdateTime"));
  }
}
