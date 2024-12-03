package org.venus.dsl.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeNode {

    private String fieldName;

    private String fieldValue;

    private List<TreeNode> children;

    public TreeNode(String fieldName, String fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public void addChildren(List<TreeNode> children) {
        this.children.addAll(children);
    }

}
