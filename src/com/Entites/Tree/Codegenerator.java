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
@Table(name = "CODEGENERATOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codegenerator.findAll", query = "SELECT c FROM Codegenerator c"),
    @NamedQuery(name = "Codegenerator.findByCodegeneratorid", query = "SELECT c FROM Codegenerator c WHERE c.codegeneratorid = :codegeneratorid"),
    @NamedQuery(name = "Codegenerator.findByName", query = "SELECT c FROM Codegenerator c WHERE c.name = :name"),
    @NamedQuery(name = "Codegenerator.findByMaxlenght", query = "SELECT c FROM Codegenerator c WHERE c.maxlenght = :maxlenght"),
    @NamedQuery(name = "Codegenerator.findByStartfrom", query = "SELECT c FROM Codegenerator c WHERE c.startfrom = :startfrom")})
public class Codegenerator implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CODEGENERATORID")
    private BigDecimal codegeneratorid;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MAXLENGHT")
    private BigInteger maxlenght;
    @Column(name = "STARTFROM")
    private BigInteger startfrom;
    @OneToMany(mappedBy = "codegeneratorid")
    private Collection<Treenodesequence> springnodesequenceCollection;

    public Codegenerator() {
    }

    public Codegenerator(BigDecimal codegeneratorid) {
        this.codegeneratorid = codegeneratorid;
    }

    public BigDecimal getCodegeneratorid() {
        return codegeneratorid;
    }

    public void setCodegeneratorid(BigDecimal codegeneratorid) {
        this.codegeneratorid = codegeneratorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getMaxlenght() {
        return maxlenght;
    }

    public void setMaxlenght(BigInteger maxlenght) {
        this.maxlenght = maxlenght;
    }

    public BigInteger getStartfrom() {
        return startfrom;
    }

    public void setStartfrom(BigInteger startfrom) {
        this.startfrom = startfrom;
    }

    @XmlTransient
    public Collection<Treenodesequence> getSpringnodesequenceCollection() {
        return springnodesequenceCollection;
    }

    public void setSpringnodesequenceCollection(Collection<Treenodesequence> springnodesequenceCollection) {
        this.springnodesequenceCollection = springnodesequenceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codegeneratorid != null ? codegeneratorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codegenerator)) {
            return false;
        }
        Codegenerator other = (Codegenerator) object;
        if ((this.codegeneratorid == null && other.codegeneratorid != null) || (this.codegeneratorid != null && !this.codegeneratorid.equals(other.codegeneratorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.EN.Codegenerator[ codegeneratorid=" + codegeneratorid + " ]";
    }

}
