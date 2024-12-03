package org.venus.dsl.data;

import java.util.ArrayDeque;
import java.util.List;

public class TreeData implements RecordData {

    private static final String RootFieldName = "R_F_N";

    private static final String RootFieldValue = "R_F_V";

    private final TreeNode root;

    public TreeData() {
        root = new TreeNode(RootFieldName, RootFieldValue);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void addChild(TreeNode child) {
        root.addChild(child);
    }

    public boolean addChild(TreeNode parentNode, TreeNode child) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            if(node == parentNode) {
                node.addChild(child);
                return true;
            } else {
                if(node.getChildren() != null && !node.getChildren().isEmpty()) {
                    List<TreeNode> children = node.getChildren();
                    for (TreeNode treeNode : children) {
                        deque.addLast(treeNode);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getField(String fieldName) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            if(node.getFieldName().equals(fieldName)) {
                return node.getFieldValue();
            } else {
                if(node.getChildren() != null && !node.getChildren().isEmpty()) {
                    List<TreeNode> children = node.getChildren();
                    for (TreeNode treeNode : children) {
                        deque.addLast(treeNode);
                    }
                }
            }
        }
        return null;
    }

}
