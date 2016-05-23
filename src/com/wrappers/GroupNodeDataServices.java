/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wrappers;


import com.Entites.Tree.Grouptable;
import com.Services.Tree.Interfaces.IGroupService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by M.atallah on 5/18/2016.
 */

public class GroupNodeDataServices {

    Grouptable group;
    private IGroupService groupService;

    public GroupNodeDataServices(Grouptable group, IGroupService groupService) {
        this.group = group;
        this.groupService = groupService;
    }

    public List<GroupNodeDataServices> getParentGroups() {
        List<GroupNodeDataServices> groupNodeDataServiceses = new ArrayList<>();
        try {
            List<Grouptable> groups = groupService.getAllWithParentNull();
            for (Grouptable group1 : groups) {
                groupNodeDataServiceses.add(new GroupNodeDataServices(group1, groupService));
            }
        } catch (Exception ex) {
            Logger.getLogger(GroupNodeDataServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return groupNodeDataServiceses;
    }

    public List<GroupNodeDataServices> getChildGroups(long id) {
        List<GroupNodeDataServices> groupNodeDataServiceses = new ArrayList<>();
        try {
            List<Grouptable> groups = groupService.getAllWithParentId(id);
            for (Grouptable group1 : groups) {
                groupNodeDataServiceses.add(new GroupNodeDataServices(group1, groupService));
            }
        } catch (Exception ex) {
            Logger.getLogger(GroupNodeDataServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return groupNodeDataServiceses;
    }

    public NodeData getObject() {
        return new NodeData(group.getName(), group.getId().longValue(), group.getSpringnodesequence(), group.getFullcode());
    }

    public Grouptable getFullObject() {
        return group;
    }

    public String getType() {
        return "group";
    }
}
