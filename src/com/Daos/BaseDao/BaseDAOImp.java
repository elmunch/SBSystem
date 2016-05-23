package com.Daos.BaseDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by M.atallah on 5/18/2016.
 */
public class BaseDAOImp<T> implements BaseDaoI<T>,Serializable {
    @Autowired
    private SessionFactory sessionFactory;
    public static final String SELECT_FROM_NATIVE_SQL = "select * from ";
    Class<T> entityClass;
    Session session;

    public BaseDAOImp() {
    }
    public BaseDAOImp(Class<T> entityClass) {
        this.entityClass=entityClass;

    }


    //    public BaseDAOImp(Class<T> entityClass) {
//        this.entityClass = entityClass;
//    }
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveInstance(T t) throws Exception {
        getSession().save(t);

    }

    @Override
    public void saveAllInstances(List<T> t) throws Exception {
        for (T t1 : t) {
            saveInstance(t1);
        }
    }

    @Override
    public void deleteInstance(T t) throws Exception {
        getSession().delete(getSession().merge(t));
    }

    @Override
    public void updateInstance(T t) throws Exception {
        getSession().merge(t);
    }

    @Override
    public T findByID(int id) throws Exception {
        return (T) getSession().get(entityClass, id);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        return getSession().find(entityClass, (long) id);
    }

    @Override
    public T findByID(Object id) throws Exception {
        return (T) getSession().get(entityClass, (Serializable) id);
//        return getSession().find(entityClass, id);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public List<T> executeQuery(String query) throws Exception {
        return (List<T>) getSession().createQuery(query).list();
    }

    @Override
    public List<T> executeQuery(String query, int start, int limit) throws Exception {
        return (List<T>) getSession().createQuery(query).setFirstResult(start).setMaxResults(limit).list();
    }

    @Override
    public T executeQueryReturnUniqueResult(String query) throws Exception {
        return (T) getSession().createQuery(query).uniqueResult();
    }

    @Override
    public List<T> executeNativeQuery(String query) throws Exception {
        List<T> resultList = getSession().createSQLQuery(query).addEntity(entityClass).list();
        return resultList;
    }

    @Override
    public List<T> executeNativeQuery(String query, int start, int limit) throws Exception {
        return (List<T>) getSession().createSQLQuery(query).addEntity(entityClass).setFirstResult(start).setMaxResults(limit).list();
    }

    @Override
    public void executeUpdateNativeQuery(String query) throws Exception {
        getSession().createSQLQuery(query).addEntity(entityClass).executeUpdate();
    }

    @Override
    public T executeNativeQueryReturnUniqueResult(String query) throws Exception {
        List<T> x = getSession().createSQLQuery(query).addEntity(entityClass).list();
        if (x.isEmpty()) {
            return null;
        } else {
            return (T) x.get(0);
        }

    }

    @Override
    public List<T> executeNativeQueryReturnIntResult(String tableName, String columnName, Object value) throws Exception {
        StringBuilder stringBuilder = new StringBuilder(SELECT_FROM_NATIVE_SQL);
        return (List<T>) getSession().createSQLQuery(stringBuilder.append(tableName).append(" where ").append(columnName).append(" = ?").toString()).addEntity(entityClass).setParameter(0, value).list();
    }

    @Override
    public Integer executeNativeQueryReturnIntResult(String query) throws Exception {
        Object x = getSession().createSQLQuery(query).addEntity(entityClass).list();
        if (x instanceof Integer) {
            return (Integer) x;
        }
        if (x instanceof BigInteger) {
            return ((BigInteger) x).intValue();
        }
        if (x instanceof BigDecimal) {
            return ((BigDecimal) x).intValue();
        }
        return null;
    }

    @Override
    public void updateAllInstances(List<T> t) throws Exception {
        for (T t1 : t) {
            updateInstance(t1);
        }
    }

    @Override
    public Integer executeQueryReturnIntResult(String query) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

}
