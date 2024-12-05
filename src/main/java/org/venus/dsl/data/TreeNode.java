package org.venus.dsl.data;

import lombok.Data;

import java.util.ArrayDeque;
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

    public static TreeNode build(String fieldName, String fieldValue) {
        return new TreeNode(fieldName, fieldValue);
    }

    public static TreeNode search(TreeNode root, String fieldName) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node.fieldName.equals(fieldName)) {
                return node;
            }
            node.children.forEach(deque::addLast);
        }
        return null;
    }

    public static List<TreeNode> searchValues(TreeNode root, String fieldName) {
        ArrayList<TreeNode> res = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node.fieldName.equals(fieldName)) {
                res.add(node);
            } else {
                node.children.forEach(deque::addLast);
            }
        }
        return res;
    }

}