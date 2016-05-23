/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Manager.Behaviors;

import com.Manager.Interfaces.ICellEdit;
import com.Entites.EmployeesOne2One.Employee;
import com.Manager.cust.EmpManager;
import com.Services.EmpOne2One.EmpServLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author M.atallah
 */
public class EmployeeCellEditBehavior implements ICellEdit {

    private EmpServLocal empServLocal;
    EmpManager empManager;

    public EmployeeCellEditBehavior(EmpServLocal empServLocal, EmpManager empManager) {
        this.empServLocal = empServLocal;
        this.empManager = empManager;
    }

    @Override
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        DataTable dataTable = (DataTable) event.getSource();
        Employee employee = (Employee) dataTable.getRowData();
        try {
            empServLocal.updateEmp(employee);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeCellEditBehavior.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
