/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Services.EmpOne2One;

import com.Entites.EmployeesOne2One.EmployeeUser;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author M.atallah
 */
public interface EmpUserServLocal {
    
     @Transactional
    public void createDept(EmployeeUser employeeUser) throws Exception;

    @Transactional
    public void updateDept(EmployeeUser employeeUser) throws Exception;

    @Transactional
    public void deleteDept(EmployeeUser employeeUser) throws Exception;

    @Transactional
    public List<EmployeeUser> getEmployeeUser() throws Exception;
    
}
