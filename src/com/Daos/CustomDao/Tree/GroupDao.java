/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Daos.CustomDao.Tree;

import com.Daos.BaseDao.BaseDAOImp;
import com.Entites.Tree.Grouptable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class GroupDao extends BaseDAOImp<Grouptable> {

    public GroupDao() {
        super(Grouptable.class);
    }


    public List<Grouptable> getAllWithParentNull() throws Exception{
        String query = "SELECT * FROM GROUPTABLE WHERE parentGroup is null";
        return this.executeNativeQuery(query);
    }

    public List<Grouptable> getAllWithParentId(long id) throws Exception{
        String query ="SELECT * FROM GROUPTABLE WHERE parentGroup = " + id + " ORDER BY id ";
        return this.executeNativeQuery(query);
    }



}
