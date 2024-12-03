package org.venus.dsl;

import junit.framework.TestCase;
import org.venus.dsl.data.TreeData;
import org.venus.dsl.data.TreeNode;

public class TreeDataTest extends TestCase {

    public static TreeNode buildNode(String fieldName, String fieldValue) {
        return new TreeNode(fieldName, fieldValue);
    }

    public void testTreeData() {
        TreeData treeData = new TreeData();
        TreeNode node1 = buildNode("field1", "value1");
        TreeNode node2 = buildNode("field2", "value2");
        TreeNode node3 = buildNode("field3", "value3");
        TreeNode node4 = buildNode("field4", "value4");
        TreeNode node5 = buildNode("field5", "value5");
        TreeNode node6 = buildNode("field6", "value6");
        TreeNode node7 = buildNode("field7", "value7");
        TreeNode node8 = buildNode("field8", "value8");
        TreeNode node9 = buildNode("field9", "value9");
        TreeNode node10 = buildNode("field10", "value10");
        TreeNode node11 = buildNode("field11", "value11");
        treeData.addChild(node1);
        treeData.addChild(node2);
        treeData.addChild(node3);
        treeData.addChild(node4);
        treeData.addChild(node5);
        treeData.addChild(node1, node6);
        treeData.addChild(node2, node7);
        treeData.addChild(node3, node8);
        treeData.addChild(node4, node9);
        treeData.addChild(node5, node10);
        treeData.addChild(node6, node11);
    }

}
