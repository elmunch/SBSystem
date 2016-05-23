/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Services.EmpOne2One;

import com.Daos.CustomDao.Emp.EmpDao;
import com.Daos.CustomDao.Emp.EmpUserDao;
import com.Entites.EmployeesOne2One.Employee;
import com.Entites.EmployeesOne2One.EmployeeUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author M.atallah
 */
@Service
public class EmpServ implements EmpServLocal {

    @Autowired
    EmpDao empDao;
    @Autowired
    EmpUserDao empUserDao;

    @Override
    public void createEmp(Employee employee) throws Exception {
        //de 3ashan atal3 el object EmpUser mn el Emp we asetha be null we sayefto
        EmployeeUser employeeUser = employee.getEmployeeUser();
        employee.setEmployeeUser(null);
        // we ba3deen a5adet el opject el kepper aseto fe el object el so8ayer 
        empDao.saveInstance(employee);

        employeeUser.setEmployee(employee);
        employeeUser.setId(employee.getId());
        empUserDao.saveInstance(employeeUser);
    }

    @Override
    public void updateEmp(Employee employee) throws Exception {
//        for (EmployeeUser employeeUser : employeeUser) {
//            
//        }
        empUserDao.updateInstance(employee.getEmployeeUser());
        empDao.updateInstance(employee);
    }

    @Override
    public void deleteEmp(Employee employee) throws Exception {
        empDao.deleteInstance(employee);
    }

    @Override
    public List<Employee> getEmployee() throws Exception {
        return empDao.getEmployee();
    }

}
