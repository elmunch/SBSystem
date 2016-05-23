/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Services.EmpOne2One;

import com.Entites.EmployeesOne2One.Employee;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author M.atallah
 */
public interface EmpServLocal {

    @Transactional
    public void createEmp(Employee employee) throws Exception;

    @Transactional
    public void updateEmp(Employee employee) throws Exception;

    @Transactional
    public void deleteEmp(Employee employee) throws Exception;

    @Transactional
    public List<Employee> getEmployee() throws Exception;

}
