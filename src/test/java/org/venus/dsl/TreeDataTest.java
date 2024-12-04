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

    public static TreeData buildCTTreeData() {
        TreeData treeData = new TreeData();
        TreeNode n1 = TreeNode.build("检查项目类型", "CT");
        TreeNode n2 = TreeNode.build("检查项目类型存在状态", "确定");
        TreeNode n3 = TreeNode.build("检查部位", "肺部");
        TreeNode n4 = TreeNode.build("检查部位", "胸部");
        TreeNode n5 = TreeNode.build("病灶部位", "胸部");
            TreeNode n51 = TreeNode.build("病灶描述", "结节");
                TreeNode n511 = TreeNode.build("病灶存在状态", "确定");
                n51.addChild(n511);
            TreeNode n56 = TreeNode.build("病灶描述", "软组织影");
                TreeNode n561 = TreeNode.build("病灶存在状态", "疑似");
                n56.addChild(n561);
            TreeNode n52 = TreeNode.build("病灶密度", "非实性");
            TreeNode n53 = TreeNode.build("病灶部位变化情况", "增厚");
                TreeNode n531 = TreeNode.build("病灶存在状态", "疑似");
                n53.addChild(n531);
            TreeNode n57 = TreeNode.build("病灶部位变化情况", "增厚");
                TreeNode n571 = TreeNode.build("病灶存在状态", "确定");
                n57.addChild(n571);
            TreeNode n54 = TreeNode.build("诊断名称", "慢阻肺诊断");
                TreeNode n541 = TreeNode.build("诊断存在状态", "确定");
                n54.addChild(n541);
            TreeNode n55 = TreeNode.build("诊断名称", "肺不张诊断");
                TreeNode n551 = TreeNode.build("诊断存在状态", "疑似");
                n55.addChild(n551);
        n5.addChild(n51);
        n5.addChild(n52);
        n5.addChild(n53);
        n5.addChild(n54);
        n5.addChild(n55);
        n5.addChild(n56);
        n5.addChild(n57);
        TreeNode n6 = TreeNode.build("病灶部位", "腹部");
        treeData.addChild(n1);
        treeData.addChild(n2);
        treeData.addChild(n3);
        treeData.addChild(n4);
        treeData.addChild(n5);
        treeData.addChild(n6);
        return treeData;
    }

}
