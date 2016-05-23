/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Entites.Tree;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "SPRINGNODESEQUENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Springnodesequence.findAll", query = "SELECT s FROM Treenodesequence s"),
    @NamedQuery(name = "Springnodesequence.findBySpringnodesequenceid", query = "SELECT s FROM Treenodesequence s WHERE s.springnodesequenceid = :springnodesequenceid"),
    @NamedQuery(name = "Springnodesequence.findByCurrentvalue", query = "SELECT s FROM Treenodesequence s WHERE s.currentvalue = :currentvalue")})
public class Treenodesequence implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)

    @Column(name = "SPRINGNODESEQUENCEID")
    private BigDecimal springnodesequenceid;
    @Column(name = "CURRENTVALUE")
    private BigInteger currentvalue;
    @JoinColumn(name = "CODEGENERATORID", referencedColumnName = "CODEGENERATORID")
    @ManyToOne
    private Codegenerator codegeneratorid;
    @OneToMany(mappedBy = "springnodesequence")
    private Collection<Grouptable> grouptableCollection;

    public Treenodesequence() {
    }

    public Treenodesequence(BigDecimal springnodesequenceid) {
        this.springnodesequenceid = springnodesequenceid;
    }

    public BigDecimal getSpringnodesequenceid() {
        return springnodesequenceid;
    }

    public void setSpringnodesequenceid(BigDecimal springnodesequenceid) {
        this.springnodesequenceid = springnodesequenceid;
    }

    public BigInteger getCurrentvalue() {
        return currentvalue;
    }

    public void setCurrentvalue(BigInteger currentvalue) {
        this.currentvalue = currentvalue;
    }

    public Codegenerator getCodegeneratorid() {
        return codegeneratorid;
    }

    public void setCodegeneratorid(Codegenerator codegeneratorid) {
        this.codegeneratorid = codegeneratorid;
    }

    @XmlTransient
    public Collection<Grouptable> getGrouptableCollection() {
        return grouptableCollection;
    }

    public void setGrouptableCollection(Collection<Grouptable> grouptableCollection) {
        this.grouptableCollection = grouptableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (springnodesequenceid != null ? springnodesequenceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treenodesequence)) {
            return false;
        }
        Treenodesequence other = (Treenodesequence) object;
        if ((this.springnodesequenceid == null && other.springnodesequenceid != null) || (this.springnodesequenceid != null && !this.springnodesequenceid.equals(other.springnodesequenceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.EN.Treenodesequence[ springnodesequenceid=" + springnodesequenceid + " ]";
    }

}
