/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Entites.Tree;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "GROUPTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grouptable.findAll", query = "SELECT g FROM Grouptable g"),
    @NamedQuery(name = "Grouptable.findById", query = "SELECT g FROM Grouptable g WHERE g.id = :id"),
    @NamedQuery(name = "Grouptable.findByName", query = "SELECT g FROM Grouptable g WHERE g.name = :name"),
    @NamedQuery(name = "Grouptable.findByCode", query = "SELECT g FROM Grouptable g WHERE g.code = :code"),
    @NamedQuery(name = "Grouptable.findByFullcode", query = "SELECT g FROM Grouptable g WHERE g.fullcode = :fullcode")})
public class Grouptable implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CODE")
    private String code;
    @Column(name = "FULLCODE")
    private String fullcode;
    @OneToMany(mappedBy = "parentgroupId")
    private Collection<Child> childCollection;
    @JoinColumn(name = "SPRINGNODESEQUENCE", referencedColumnName = "SPRINGNODESEQUENCEID")
    @ManyToOne
    private Treenodesequence springnodesequence;
    @OneToMany(mappedBy = "parentgroup")
    private Collection<Grouptable> grouptableCollection;
    @JoinColumn(name = "PARENTGROUP", referencedColumnName = "ID")
    @ManyToOne
    private Grouptable parentgroup;

    public Grouptable() {
    }

    public Grouptable(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullcode() {
        return fullcode;
    }

    public void setFullcode(String fullcode) {
        this.fullcode = fullcode;
    }

    @XmlTransient
    public Collection<Child> getChildCollection() {
        return childCollection;
    }

    public void setChildCollection(Collection<Child> childCollection) {
        this.childCollection = childCollection;
    }

    public Treenodesequence getSpringnodesequence() {
        return springnodesequence;
    }

    public void setSpringnodesequence(Treenodesequence springnodesequence) {
        this.springnodesequence = springnodesequence;
    }

    @XmlTransient
    public Collection<Grouptable> getGrouptableCollection() {
        return grouptableCollection;
    }

    public void setGrouptableCollection(Collection<Grouptable> grouptableCollection) {
        this.grouptableCollection = grouptableCollection;
    }

    public Grouptable getParentgroup() {
        return parentgroup;
    }

    public void setParentgroup(Grouptable parentgroup) {
        this.parentgroup = parentgroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grouptable)) {
            return false;
        }
        Grouptable other = (Grouptable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.EN.Grouptable[ id=" + id + " ]";
    }

}
