package com.MB;


import com.Entites.Tree.Child;
import com.Entites.Tree.Codegenerator;
import com.Entites.Tree.Grouptable;
import com.Entites.Tree.Treenodesequence;
import com.Services.Tree.Interfaces.ICodegenerator;
import com.Services.Tree.Interfaces.IGroupService;
import com.Services.Tree.Interfaces.ITreeNodeSequence;
import com.converter.CodeGeneratorConverter;
import com.wrappers.GroupNodeDataServices;
import com.wrappers.NodeData;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by M.atallah on 5/18/2016.
 */
@Component("groupManagedBean")
@Scope("view")
public class TreeMB {

    @Autowired
    private IGroupService groupService;
    private TreeNode rootNode;
    private TreeNode selectedNode;
    private Grouptable group;
    private Grouptable selectedGroup;
    private ArrayList<Grouptable> deletedGroups;
    private Child child;
    @Autowired
    private ICodegenerator codegeneratorService;
    private Codegenerator codegenerator;
    @Autowired
    private
    ITreeNodeSequence treenodesequenceService;
    private Codegenerator selectedCodeGenerator;
    private CodeGeneratorConverter codeGeneratorConverter;
    private Treenodesequence treenodesequence;
    private GroupNodeDataServices groupNodeDataServices;

    public TreeMB() {
        group = new Grouptable();
        child = new Child();
        deletedGroups = new ArrayList<>();
        codegenerator = new Codegenerator();
    }

    @PostConstruct
    public void init() {
        setGroupNodeDataServices(new GroupNodeDataServices(group, groupService));
        setTreenodesequence(new Treenodesequence());
        draw();
    }

    ///////////////////////////// ---drawing group--/////////////////////
    public void draw() {
        rootNode = new DefaultTreeNode("root", null);
        TreeNode main = new DefaultTreeNode("main", "Main", rootNode);
        try {
            List<GroupNodeDataServices> parentGroupNodeDataServiceses = groupNodeDataServices.getParentGroups();

            if (parentGroupNodeDataServiceses != null && !parentGroupNodeDataServiceses.isEmpty()) {
                for (GroupNodeDataServices parentGroup : parentGroupNodeDataServiceses) {
                    TreeNode node = new DefaultTreeNode(parentGroup.getType(), parentGroup.getObject(), main);
                    drawChildGroup(node);
//                    drawItems(node);
                }
            }
            main.setExpanded(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void drawChildGroup(TreeNode parentNode) {
        try {
            // elista elly el parent bta3hm group
            List<GroupNodeDataServices> childGroups = groupNodeDataServices.getChildGroups(((NodeData) parentNode.getData()).getId());
            if (childGroups != null && !childGroups.isEmpty()) {
                for (GroupNodeDataServices childGroup : childGroups) {
                    TreeNode node = new DefaultTreeNode(childGroup.getType(), childGroup.getObject(), parentNode);
                    drawChildGroup(node);
//                    drawItems(node);
                }
            }
        } catch (Exception ex) {
        }
    }

    public void drawItems(TreeNode parent) throws Exception {
        List<Child> items = groupService.getItemsByParentId(((NodeData) parent.getData()).getId());
        if (!items.isEmpty()) {
            for (Child item : items) {
                TreeNode node = new DefaultTreeNode("item", item, parent);
            }
        }
    }

    public void onNodeSelect(NodeSelectEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void addGroup() {
        try {
            ///////////////////////import/////////////////
            if (!getSelectedNode().getChildren().isEmpty()) {
                for (TreeNode children : getSelectedNode().getChildren()) {
                    treenodesequence = ((NodeData) children.getData()).getTreenodesequence();
                    if (treenodesequence != null) {
                        break;
                    }
                }
            }

            setparent();

            if (treenodesequence == null) {
                treenodesequence = new Treenodesequence();
                treenodesequence.setCodegeneratorid(selectedCodeGenerator);
                BigInteger newVal = selectedCodeGenerator.getStartfrom();
                treenodesequence.setCurrentvalue(newVal);
                String newCode = generateNewCode(treenodesequence.getCodegeneratorid().getMaxlenght().intValue(), newVal.toString());
                group.setCode(newCode);
                if (group.getParentgroup() == null) {
                    group.setFullcode(newCode);
                } else
                    group.setFullcode(group.getParentgroup().getFullcode() + newCode);
                /////////////////////add Sequance
                treenodesequenceService.addSeq(treenodesequence);
            } else {
                BigInteger currentVal = treenodesequence.getCurrentvalue();
                BigInteger newVal = currentVal.add(new BigInteger("1"));
                treenodesequence.setCurrentvalue(newVal);
                treenodesequenceService.updateSeq(treenodesequence);
                String newCode = generateNewCode(treenodesequence.getCodegeneratorid().getMaxlenght().intValue(), newVal.toString());
                group.setCode(newCode);
                if (group.getParentgroup() == null) {
                    group.setFullcode(newCode);
                } else {
                    group.setCode(newVal.toString());
                    group.setFullcode(group.getParentgroup().getFullcode() + newCode);
                }
            }
            group.setSpringnodesequence(treenodesequence);

            groupService.addGroup(group);
            draw();
            group = new Grouptable();
        } catch (Exception ex) {
            Logger.getLogger(TreeMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateGroup() {
        try {
            groupService.updateGroup((Grouptable) selectedNode.getData());
        } catch (Exception ex) {
            Logger.getLogger(TreeMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setselectedgroup() {
        selectedGroup = (Grouptable) selectedNode.getData();
    }

    /////////////////////deleting group/////////////////
    public void deleteGroup() {
        try {
            deletedGroups.add((Grouptable) selectedNode.getData());
            deletedChilds((Grouptable) selectedNode.getData());
            for (int i = deletedGroups.size() - 1; i >= 0; i--) {
                groupService.deleteGroup(deletedGroups.get(i));
            }
            draw();
            deletedGroups.clear();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /////////Test Delete ////////
    public void deleteGroup2() throws Exception {
        groupService.deleteGroup(group);
    }

    public void deletedChilds(Grouptable parent) {
        try {
            List<Grouptable> childGroups = groupService.getAllWithParentId(parent.getId().longValue());
            if (childGroups != null && !childGroups.isEmpty()) {
                deletedGroups.addAll(childGroups);
                for (Grouptable childGroup : childGroups) {
                    deletedChilds(childGroup);
                }
            }
        } catch (Exception e) {
        }
    }

    //////////////////////---adding item---/////////////////
    public void addItem() {
        try {
            groupService.addChild(child);
            child = new Child();
            draw();
        } catch (Exception ex) {
        }
    }

    public void deleteItem() {
        try {
            groupService.deleteItem((Child) selectedNode.getData());
            draw();
        } catch (Exception ex) {
            Logger.getLogger(TreeMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParentToItem() {
        if (selectedNode.getData() != null) {
            child.setParentgroupId((Grouptable) selectedNode.getData());
        }
    }

    public void addTreeNodeSequenceParent() {
        treenodesequence = new Treenodesequence();
        if (!getSelectedNode().getChildren().isEmpty()) {
            for (TreeNode children : getSelectedNode().getChildren()) {
                treenodesequence = ((NodeData) children.getData()).getTreenodesequence();
                if (treenodesequence != null) {
                    break;
                }
            }
        }
    }

    //Set Parents
    public void setparent() {
        if (selectedNode.getType().equals("main")) {
            return;
        }
        if (selectedNode.getData() != null) {
            Grouptable parentGroup = new Grouptable();
            long id = ((NodeData) selectedNode.getData()).getId();
            try {
                parentGroup = groupService.findGroupById(id);
            } catch (Exception ex) {
                Logger.getLogger(TreeMB.class.getName()).log(Level.SEVERE, null, ex);
            }
            group.setParentgroup(parentGroup);
        }
    }

    private String generateNewCode(int maxSize, String number) {
        String zero = "";
        int Numberlength = number.length();
        for (int i = 1; i <= maxSize - Numberlength; i++) {
            zero += "0";
        }
        return zero + number;
    }

    ///////////////////////////insert code generator ///////////////
    public void addCode() {

        try {
            codegeneratorService.addCode(codegenerator);
            codegenerator = new Codegenerator();
        } catch (Exception ex) {
            Logger.getLogger(TreeMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ////////////////////get code //////////////
    public List<Codegenerator> getAll() {
        try {
            List<Codegenerator> listCode = codegeneratorService.getListCode();
            codeGeneratorConverter = new CodeGeneratorConverter(listCode);
            return listCode;

        } catch (Exception ex) {
            Logger.getLogger(TreeMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    ///////////////////////////////////////Setter$Getter///////////////////////////////////////////////////
    public IGroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(IGroupService groupService) {
        this.groupService = groupService;
    }

    public TreeNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TreeNode rootNode) {
        this.rootNode = rootNode;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public Grouptable getGroup() {
        return group;
    }

    public void setGroup(Grouptable group) {
        this.group = group;
    }

    public Grouptable getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(Grouptable selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public ArrayList<Grouptable> getDeletedGroups() {
        return deletedGroups;
    }

    public void setDeletedGroups(ArrayList<Grouptable> deletedGroups) {
        this.deletedGroups = deletedGroups;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public ICodegenerator getCodegeneratorService() {
        return codegeneratorService;
    }

    public void setCodegeneratorService(ICodegenerator codegeneratorService) {
        this.codegeneratorService = codegeneratorService;
    }

    public Codegenerator getCodegenerator() {
        return codegenerator;
    }

    public void setCodegenerator(Codegenerator codegenerator) {
        this.codegenerator = codegenerator;
    }

    public ITreeNodeSequence getTreenodesequenceService() {
        return treenodesequenceService;
    }

    public void setTreenodesequenceService(ITreeNodeSequence treenodesequenceService) {
        this.treenodesequenceService = treenodesequenceService;
    }

    public Codegenerator getSelectedCodeGenerator() {
        return selectedCodeGenerator;
    }

    public void setSelectedCodeGenerator(Codegenerator selectedCodeGenerator) {
        this.selectedCodeGenerator = selectedCodeGenerator;
    }

    public CodeGeneratorConverter getCodeGeneratorConverter() {
        return codeGeneratorConverter;
    }

    public void setCodeGeneratorConverter(CodeGeneratorConverter codeGeneratorConverter) {
        this.codeGeneratorConverter = codeGeneratorConverter;
    }

    public Treenodesequence getTreenodesequence() {
        return treenodesequence;
    }

    public void setTreenodesequence(Treenodesequence treenodesequence) {
        this.treenodesequence = treenodesequence;
    }

    public GroupNodeDataServices getGroupNodeDataServices() {
        return groupNodeDataServices;
    }

    public void setGroupNodeDataServices(GroupNodeDataServices groupNodeDataServices) {
        this.groupNodeDataServices = groupNodeDataServices;
    }
}
