/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wrappers;


import com.Entites.Tree.Treenodesequence;

/**
 * Created by M.atallah on 5/18/2016.
 */
public class NodeData {
    
    private String name;
    private long id;
    private Treenodesequence treenodesequence;
    private String fullcode;

    public NodeData(String name, long id, Treenodesequence treenodesequence, String fullcode) {
        this.name = name;
        this.id = id;
        this.treenodesequence = treenodesequence;
        this.fullcode = fullcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Treenodesequence getTreenodesequence() {
        return treenodesequence;
    }

    public void setTreenodesequence(Treenodesequence treenodesequence) {
        this.treenodesequence = treenodesequence;
    }
    
    public String toString(){
        if(treenodesequence==null)
            return name;
        return fullcode + name;
    }
}
