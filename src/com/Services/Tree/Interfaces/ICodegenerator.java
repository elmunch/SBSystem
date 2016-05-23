package com.Services.Tree.Interfaces;

import com.Entites.Tree.Codegenerator;

import java.util.List;

/**
 * Created by M.atallah on 5/18/2016.
 */
public interface ICodegenerator {

    void addCode (Codegenerator codegenerator)throws Exception;
    List<Codegenerator> getListCode ()throws Exception;

}
