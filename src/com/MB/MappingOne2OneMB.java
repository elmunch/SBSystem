/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MB;

import com.Entites.EmployeesOne2One.Employee;
import com.Manager.cust.EmpManager;
import com.Reporting.BaseReportingLocal;
import com.Services.EmpOne2One.EmpServLocal;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author M.atallah
 */
@Component("mappingMB")
@Scope("view")
public class MappingOne2OneMB implements Serializable {

    private EmpManager instance;
    private Employee selected;
    private List<Employee> empes = null;
    
    @Autowired
    EmpServLocal empServLocal;
    
    @Autowired
    BaseReportingLocal baseReportingLocal;

    public MappingOne2OneMB() {
      
    }

    @PostConstruct
    public  void init(){
          instance = new EmpManager(null, baseReportingLocal, empServLocal);
    }
    public void createEmp() {
        try {
            ///////TO set Same ID from Emp TO EmpUser
                    empServLocal.createEmp(instance.getObject());
            /* dE 3ASHAN A2OLO E3ML SYNCRONIZED M3A EL LISTA
             3ASHAN ANA 3AYEZ A3ML UPDATE LL FORMA WANA BAD5L ELDATA MN EL INPUT TEXT WE TEZHAR FE EL DATA TABLE */
            empes.add(instance.getObject());
            reset();
        } catch (Exception ex) {
            Logger.getLogger(MappingOne2OneMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEmp1() {
        try {
            empServLocal.updateEmp(instance.getObject());
        } catch (Exception ex) {
            Logger.getLogger(MappingOne2OneMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEmp(Employee employee) {
        try {
            empServLocal.updateEmp(employee);
        } catch (Exception ex) {
            Logger.getLogger(MappingOne2OneMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Employee employee) {
        try {
            empServLocal.deleteEmp(employee);
            /*
            
             */
            empes = empServLocal.getEmployee();
            addMessage("System Error", "Please try again later.");
        } catch (Exception ex) {
            Logger.getLogger(MappingOne2OneMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     public void onCellEdit(CellEditEvent event) {
     Object oldValue = event.getOldValue();
     Object newValue = event.getNewValue();

     DataTable dataTable = (DataTable) event.getSource();
     Employee employee = (Employee) dataTable.getRowData();
     try {
     empServLocal.updateEmp(employee);
     } catch (Exception ex) {
     Logger.getLogger(MappingOne2OneMB.class.getName()).log(Level.SEVERE, null, ex);
     }
     if (newValue != null && !newValue.equals(oldValue)) {
     FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
     FacesContext.getCurrentInstance().addMessage(null, msg);
     }
     }*/
    public void destroyWorld() {
        addMessage("System Error", "Please try again later.");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void reset() {
        instance = new EmpManager(null, baseReportingLocal, empServLocal);
        RequestContext.getCurrentInstance().reset("formr");
    }

//    public void show() {
//        setInstance(selected);
//    }
//
//    public void addEmpUser() {
//        instance.getEmployeeUser();
//        Employee employee = new Employee();
//    }
    public void setInstance(EmpManager instance) {
        this.instance = instance;
    }

    public EmpManager getInstance() {
        return instance;
    }

    public Employee getSelected() {
        return selected;
    }

    public void setSelected(Employee selected) {
        this.selected = selected;
    }

    public List<Employee> getEmpes() {
        try {
            if (empes == null) {
                empes = empServLocal.getEmployee();
            }
        } catch (Exception ex) {
            Logger.getLogger(MappingOne2OneMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empes;
    }

    public void setEmpes(List<Employee> empes) {
        this.empes = empes;
    }

}
