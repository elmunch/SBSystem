package com.Services.Tree.Imps;

import com.Daos.CustomDao.Tree.CodegeneratorDao;
import com.Daos.CustomDao.Tree.TreenodesequenceDao;
import com.Entites.Tree.Codegenerator;
import com.Entites.Tree.Treenodesequence;
import com.Services.Tree.Interfaces.ITreeNodeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by M.atallah on 5/18/2016.
 */
@Service
@Transactional
public class TreeNodeSequenceService implements ITreeNodeSequence {

    @Autowired
    TreenodesequenceDao treenodesequenceDao;


    @Override
    public void addSeq(Treenodesequence treenodesequence) throws Exception {
        this.treenodesequenceDao.saveInstance(treenodesequence);
    }

    @Override
    public void updateSeq(Treenodesequence treenodesequence) throws Exception {
        this.treenodesequenceDao.updateInstance(treenodesequence);
    }
}
