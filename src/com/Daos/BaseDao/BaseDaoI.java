package com.Daos.BaseDao;

import java.util.List;

/**
 * Created by M.atallah on 5/18/2016.
 */
public interface BaseDaoI<T> {
    void saveInstance(T t) throws Exception;

    void saveAllInstances(List<T> t) throws Exception;

    void deleteInstance(T t) throws Exception;

    void updateInstance(T t) throws Exception;

    T findByID(int id) throws Exception;

    T findByID(Object id) throws Exception;

    List<T> executeQuery(String query) throws Exception;

    List<T> executeQuery(String query, int start, int limit) throws Exception;

    T executeQueryReturnUniqueResult(String query) throws Exception;

    Integer executeQueryReturnIntResult(String query) throws Exception;

    List<T> executeNativeQuery(String query) throws Exception;

    List<T> executeNativeQuery(String query, int start, int limit) throws Exception;

    void executeUpdateNativeQuery(String query) throws Exception;

    T executeNativeQueryReturnUniqueResult(String query) throws Exception;

    Integer executeNativeQueryReturnIntResult(String query) throws Exception;

    void updateAllInstances(List<T> t) throws Exception;

    List<T> executeNativeQueryReturnIntResult(String tableName, String columnName, Object value) throws Exception;

}
