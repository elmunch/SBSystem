/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Daos.CustomDao.Tree;

import com.Daos.BaseDao.BaseDAOImp;
import com.Entites.Tree.Child;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class ChildDao extends BaseDAOImp<Child> {

    public ChildDao () {
    super(Child.class);
    }


    public List<Child> getItemsByParentId(long id) throws Exception{
       String query = "SELECT item FROM Child item WHERE item.parentgroupId.id ="+id;
        return executeNativeQuery(query);
    }


   
}
