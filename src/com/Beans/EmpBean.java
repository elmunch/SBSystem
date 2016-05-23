/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Beans;

import java.io.Serializable;

/**
 *
 * @m.ATALLAH
 */
public class EmpBean implements Serializable {

    private String Name;
    private String Addrees;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddrees() {
        return Addrees;
    }

    public void setAddrees(String Addrees) {
        this.Addrees = Addrees;
    }

}
