/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Services.EmpOne2One;

import com.Daos.CustomDao.Emp.EmpUserDao;
import com.Entites.EmployeesOne2One.EmployeeUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author M.atallah
 */
@Service
public class EmpUserServ implements EmpUserServLocal {
    
    @Autowired
    EmpUserDao empUserDao;
        
    @Override
    public void createDept(EmployeeUser employeeUser) throws Exception {
        empUserDao.saveInstance(employeeUser);
    }
    
    @Override
    public void updateDept(EmployeeUser employeeUser) throws Exception {
        empUserDao.updateInstance(employeeUser);
    }
    
    @Override
    public void deleteDept(EmployeeUser employeeUser) throws Exception {
        empUserDao.deleteInstance(employeeUser);
    }
    
    @Override
    public List<EmployeeUser> getEmployeeUser() throws Exception {
        return empUserDao.getEmpUser();
    }
    
}
