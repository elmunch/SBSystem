package com.Daos.CustomDao.Emp;

import com.Daos.BaseDao.BaseDAOImp;
import com.Entites.EmployeesOne2One.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by M.atallah on 5/18/2016.
 */
@Repository

public class EmpDao extends BaseDAOImp<Employee> {
    public EmpDao() {
    }

    public List<Employee> getEmployee  () throws Exception {
        setEntityClass(Employee.class);
        return executeNativeQuery("select * from Employee");
    }
}
