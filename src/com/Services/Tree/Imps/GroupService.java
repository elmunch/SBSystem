package com.Services.Tree.Imps;

import com.Daos.CustomDao.Tree.ChildDao;
import com.Daos.CustomDao.Tree.GroupDao;
import com.Entites.Tree.Child;
import com.Entites.Tree.Grouptable;
import com.Services.Tree.Interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by M.atallah on 5/18/2016.
 */
@Service
@Transactional
public class GroupService implements IGroupService {

    @Autowired
    GroupDao groupDao ;
    @Autowired
    ChildDao childDao ;
    @Override
    public void addGroup(Grouptable group) throws Exception {
        this.groupDao.saveInstance(group);
    }

    @Override
    public void updateGroup(Grouptable group) throws Exception {
        this.groupDao.updateInstance(group);
    }

    @Override
    public void deleteGroup(Grouptable group) throws Exception {
        this.groupDao.deleteInstance(group);
    }

    @Override
    public List<Grouptable> getAllWithParentNull() throws Exception {
        return this.groupDao.getAllWithParentNull();
    }

    @Override
    public List<Grouptable> getAllWithParentId(long id) throws Exception {
        return this.groupDao.getAllWithParentId(id);
    }

    @Override
    public void addChild(Child child) throws Exception {
        this.childDao.saveInstance(child);
    }

    @Override
    public List<Child> getItemsByParentId(long id) throws Exception{
        return this.childDao.getItemsByParentId(id);
    }

    @Override
    public void deleteItem(Child child) throws Exception {
        this.childDao.deleteInstance(child);
    }

    @Override
    public Grouptable findGroupById(long id) throws Exception {
        return this.groupDao.findByID(id);
    }
}
