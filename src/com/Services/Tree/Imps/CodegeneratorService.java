package com.Services.Tree.Imps;

import com.Daos.CustomDao.Tree.CodegeneratorDao;
import com.Entites.Tree.Codegenerator;
import com.Services.Tree.Interfaces.ICodegenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by M.atallah on 5/18/2016.
 */
@Service
@Transactional
public class CodegeneratorService implements ICodegenerator {
    
    @Autowired
    CodegeneratorDao codegeneratorDao ;
    @Override
    public void addCode(Codegenerator codegenerator) throws Exception {
        this.codegeneratorDao.saveInstance(codegenerator);
    }

    @Override
    public List<Codegenerator> getListCode() throws Exception {
        List<Codegenerator> resultList = codegeneratorDao.executeNativeQuery("SELECT * FROM CODEGENERATOR");
        return resultList;
    }
}
