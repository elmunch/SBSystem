package com.Services.Tree.Interfaces;

import com.Entites.Tree.Codegenerator;
import com.Entites.Tree.Treenodesequence;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by M.atallah on 5/18/2016.
 */
public interface ITreeNodeSequence {

     void addSeq(Treenodesequence treenodesequence) throws Exception ;
    void updateSeq(Treenodesequence treenodesequence) throws Exception;



}
