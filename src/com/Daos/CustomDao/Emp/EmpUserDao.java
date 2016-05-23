package com.Daos.CustomDao.Emp;

import com.Daos.BaseDao.BaseDAOImp;
import com.Entites.EmployeesOne2One.EmployeeUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by M.atallah on 5/18/2016.
 */
@Repository

public class EmpUserDao extends BaseDAOImp<EmployeeUser> {
    public EmpUserDao() {

    }

    public List<EmployeeUser> getEmpUser() throws Exception {
        setEntityClass(EmployeeUser.class);
        return executeNativeQuery("SELECT * FROM EmployeeUser");
    }
}
