/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Manager.cust;

import com.Manager.Behaviors.EmployeeCellEditBehavior;
import com.Entites.EmployeesOne2One.Employee;
import com.Entites.EmployeesOne2One.EmployeeUser;
import com.Manager.BaseManager;
import com.Reporting.BaseReportingLocal;
import com.Manager.Behaviors.EmployeePrintBehavior;
import com.Services.EmpOne2One.EmpServLocal;

/**
 *
 * @author M.atallah
 */
public class EmpManager extends BaseManager<Employee> {

    private EmpServLocal empServLocal;
    
    /**
     *
     * @param employee
     * @param baseReportingLocal
     */
    public EmpManager(Employee employee, BaseReportingLocal baseReportingLocal, EmpServLocal empServLocal) {
        super(employee, Employee.class);
        this.empServLocal = empServLocal;
        /*
         DE 3ashan a3rf anade elInterface we adelo new LL behavior bta3 el IMP
         we 3ashan Lama anade el view anade el Interface 3alatool
         */

        /*
         zay refrance mn el current object mn el class ele ana feha 
         */
        setiReport(new EmployeePrintBehavior(this, baseReportingLocal));
        getObject().setEmployeeUser(new EmployeeUser());
        setCellEdit(new EmployeeCellEditBehavior(empServLocal, this));
        
    }

    /**
     * @return the empServLocal
     */
    public EmpServLocal getEmpServLocal() {
        return empServLocal;
    }

    /**
     * @param empServLocal the empServLocal to set
     */
    public void setEmpServLocal(EmpServLocal empServLocal) {
        this.empServLocal = empServLocal;
    }

}
