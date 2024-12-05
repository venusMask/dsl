package org.venus.dsl;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.visitor.BaseVisitor;

@Slf4j
public class BaseTest extends TestCase {

    public void testSimpleCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();
        String simpleRule =
                "rule_1 \"aa\"\n" +
                "r1 ${检查项目类型} = \"CT\"\n" +
                "满足 r1 输出 \"匹配\"\n" +
                "其他输出 \"没有匹配\"";
        BaseVisitor visitor = Analyze.parse(simpleRule);
        Object visit = visitor.visit(root);
        assertEquals(visit, "匹配");
    }

    public void testNestCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();

        String nestRule =
                "rule_1 \"aa\"\n" +
                "r1 ${检查项目类型} = \"CT\"\n" +
                "r2 ${病灶描述} = \"结节\"; ${病灶存在状态} = \"确定\"\n" +
                "满足 r1 and r2 输出 \"匹配\"\n" +
                "其他输出 \"没有匹配\"";
        BaseVisitor visitor = Analyze.parse(nestRule);
        Object visit = visitor.visit(root);
        assertEquals(visit, "匹配");
        String nestRule2 =
                "rule_1 \"aa\"\n" +
                "r1 ${检查项目类型} = \"CT\"\n" +
                "r2 ${病灶描述} = \"结节\"; ${病灶存在状态} = \"疑似\"\n" +
                "满足 r1 and r2 输出 \"匹配\"\n" +
                "其他输出 \"没有匹配\"";
        BaseVisitor visitor2 = Analyze.parse(nestRule2);
        Object visit2 = visitor2.visit(root);
        assertEquals(visit2, "没有匹配");
    }

    public void testContainsCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();
        String rule =
                "rule_1 \"aa\"\n" +
                "r1 ${检查项目类型} contains \"CT\"\n" +
                "r2 ${病灶描述} contains \"软组织影\"; ${病灶存在状态} = \"疑似\"\n" +
                "满足 r1 and r2 输出 \"匹配\"\n" +
                "其他输出 \"没有匹配\"";
        Object result = Analyze.parse(rule).visit(root);
        assertEquals(result, "匹配");
    }

    public void testContainsCase2() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();
        String rule =
                "rule_1 \"aa\"\n" +
                        "r1 ${检查项目类型} contains \"CT\"\n" +
                        "r2 ${病灶描述} contains \"软组织影\"; ${病灶存在状态} = \"确定\"\n" +
                        "满足 r1 and r2 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result = Analyze.parse(rule).visit(root);
        assertEquals(result, "没有匹配");
    }

    public void testCompareCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();

        String rule =
                "rule_1 \"aa\"\n" +
                        "r1 ${检查时间} >= ${就诊时间}" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result = Analyze.parse(rule).visit(root);
        assertEquals(result, "匹配");

        String rule1 =
                "rule_1 \"aa\"\n" +
                        "r1 ${检查时间} > ${就诊时间}" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result1 = Analyze.parse(rule1).visit(root);
        assertEquals(result1, "匹配");

        String rule2 =
                "rule_1 \"aa\"\n" +
                        "r1 ${检查时间} < ${就诊时间}" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result2 = Analyze.parse(rule2).visit(root);
        assertEquals(result2, "没有匹配");

        String rule3 =
                "rule_1 \"aa\"\n" +
                        "r1 ${检查时间} <= ${就诊时间}" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result3 = Analyze.parse(rule3).visit(root);
        assertEquals(result3, "没有匹配");
    }

    public void testCTCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();
        Object result = Analyze.parse(RuleCase.chestCTExaminationRule).visit(root);
        System.out.println(result);
    }

}
