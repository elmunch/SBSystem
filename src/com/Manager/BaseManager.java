/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Manager;

import com.Manager.Interfaces.ICellEdit;
import com.Manager.Interfaces.IReport;
import java.io.Serializable;

/**
 *
 * @author M.atallah
 */
public abstract class BaseManager<T> implements Serializable {

    /*
     de 3ashan a3ml get llObject we 3ashan a2olo dh no3o eh
     */
    T object;
    private IReport iReport;
    Class<T> clazz;
    private ICellEdit cellEdit;

    public BaseManager(T object, Class<T> clazz) {
        this.clazz = clazz;
        if (object == null) {
            // suppose that clazz is Employee.class 
            // create object method will set our object=new Employee();
            this.object = createObject(clazz);
        } else {
            // if object not null - suppose its form db- set object from passed object
            this.object = object;
        }
    }

    T createObject(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    

    public IReport getiReport() {
        return iReport;
    }
    public void setiReport(IReport iReport) {
        this.iReport = iReport;
    }
    public void setObject(T object) {
        this.object = object;
    }
    public T getObject() {
        return object;
    }

    /**
     * @return the cellEdit
     */
    public ICellEdit getCellEdit() {
        return cellEdit;
    }

    /**
     * @param cellEdit the cellEdit to set
     */
    public void setCellEdit(ICellEdit cellEdit) {
        this.cellEdit = cellEdit;
    }

}
