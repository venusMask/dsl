package org.venus.dsl;

import junit.framework.TestCase;
import org.venus.dsl.data.TreeNode;

import java.util.List;

public class TreeNodeTest extends TestCase {

    public static TreeNode buildCTTreeData() {
        TreeNode root = new TreeNode("检查", "检查");
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
        root.addChild(n1);
        root.addChild(n2);
        root.addChild(n3);
        root.addChild(n4);
        root.addChild(n5);
        root.addChild(n6);
        TreeNode n7 = TreeNode.build("检查时间", "2024-12-04 12:12:12");
        TreeNode n8 = TreeNode.build("就诊时间", "2024-12-03 12:12:13");
        root.addChild(n7);
        root.addChild(n8);
        return root;
    }

    public void testSearchValues() {
        TreeNode root = buildCTTreeData();
        assertEquals(TreeNode.searchValues(root, "检查部位").size(), 2);
        assertEquals(TreeNode.searchValues(root, "诊断名称").size(), 2);
        assertEquals(TreeNode.searchValues(root, "病灶部位").size(), 2);
        assertEquals(TreeNode.searchValues(root, "病灶存在状态").size(), 4);
        List<TreeNode> values = TreeNode.searchValues(root, "病灶部位变化情况");
        assertEquals(values.size(), 2);
        for (TreeNode newRoot : values) {
            List<TreeNode> tmpValues = TreeNode.searchValues(newRoot, "病灶存在状态");
            assertEquals(tmpValues.size(), 1);
        }
    }

}
