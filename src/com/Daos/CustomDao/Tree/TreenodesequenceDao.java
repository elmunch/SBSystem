/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Daos.CustomDao.Tree;


import com.Daos.BaseDao.BaseDAOImp;
import com.Entites.Tree.Treenodesequence;
import org.springframework.stereotype.Repository;

/**
 * @author m.atallah
 */
@Repository

public class TreenodesequenceDao extends BaseDAOImp<Treenodesequence> {

    public TreenodesequenceDao() {
        super(Treenodesequence.class);
    }




   /* public Treenodesequence getCurrentValueForSelectedSequence(Object id) throws Exception {
        String query = "select * from treenodesequence where TREENODESEQUENCEID = " + id;
        return executeNativeQueryReturnUniqueResult(query);
    }

    public List<Treenodesequence> getListTreeNodeSequenceByCodeGeneratorID(Codegenerator codegenerator) throws Exception {
        String query = "SELECT * FROM TREENODESEQUENCE WHERE CODEGENERATORID = " + codegenerator.getCodegeneratorid();
        return executeNativeQuery(query);
    }*/
}
