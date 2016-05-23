/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Manager.Behaviors;

import com.Beans.EmpBean;
import com.Entites.EmployeesOne2One.Employee;
import com.Manager.cust.EmpManager;
import com.Reporting.BaseReportingLocal;
import com.Reporting.SampleReporting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;

/**
 *
 * @author M.atallah
 */
public class EmployeePrintBehavior extends SampleReporting{

    List<EmpBean> empBeans ;
    EmpManager empManager;
    Map parameters = new HashMap();
    
    @Override
    public void printReport() {
        this.fillDataFileds();
    }

    /**
     * elBehavior dh bymasel el report behavior beta3 el IMP manager
     * @param empManager
     * @param baseReportingLocal
     */
    public EmployeePrintBehavior(EmpManager empManager,BaseReportingLocal baseReportingLocal) {
        super(baseReportingLocal);
        this.empManager=empManager;
        this.empBeans=new ArrayList<>();
    }
    

    private void fillDataFileds () {
        EmpBean empBean = new EmpBean();
        Employee employee = empManager.getObject();
        empBean.setName(employee.getName());
        empBean.setAddrees(employee.getEmployeeUser().getAddrees());
        this.empBeans.add(empBean);
        super.generateEmployeesReport(null, empBeans, FacesContext.getCurrentInstance());
    }
}
