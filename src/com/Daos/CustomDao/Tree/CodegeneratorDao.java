/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Daos.CustomDao.Tree;


import com.Daos.BaseDao.BaseDAOImp;
import com.Entites.Tree.Codegenerator;
import org.springframework.stereotype.Repository;

/**
 * @author m.atallah
 */
@Repository

public class CodegeneratorDao extends BaseDAOImp<Codegenerator> {


    public CodegeneratorDao() {
        super(Codegenerator.class);
    }

//
//     public List<Codegenerator> getAllData () {
//
//        List<Codegenerator> resultList = em.createNativeQuery("SELECT * FROM CODEGENERATOR",Codegenerator.class).getResultList();
//     return resultList;
//     }

/*
    public Codegenerator getCodegenerator(Treenodesequence treenodesequence) throws Exception {
        String query = "select * from CODEGENERATOR where CODEGENERATORID = (SELECT TREENODESEQUENCE.CODEGENERATORID FROM TREENODESEQUENCE WHERE TREENODESEQUENCE.TREENODESEQUENCEID =" + treenodesequence.getTreenodesequenceid().longValue() + ")";
        return executeNativeQueryReturnUniqueResult(query);
    }*/

}
