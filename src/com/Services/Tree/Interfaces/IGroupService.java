package com.Services.Tree.Interfaces;

import com.Entites.Tree.Child;
import com.Entites.Tree.Grouptable;

import java.util.List;

/**
 * Created by M.atallah on 5/18/2016.
 */
public interface IGroupService {

     void addGroup(Grouptable group)throws Exception;
     void updateGroup(Grouptable group)throws Exception;
     void deleteGroup(Grouptable group)throws Exception;
     List<Grouptable>getAllWithParentNull() throws Exception;
     List<Grouptable> getAllWithParentId(long id)throws Exception;
     void addChild(Child child)throws Exception;
     List<Child> getItemsByParentId(long id)throws Exception;
     void deleteItem(Child child)throws Exception;
     Grouptable findGroupById(long id) throws Exception;

}
