package org.venus.dsl;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.parse.node.Node;
import org.venus.dsl.visitor.ExecutorVisitor;

@Slf4j
public class BaseTest extends TestCase {

    private Object execute(TreeNode context, String rule) {
        Analyze analyze = new Analyze();
        Node root = analyze.parse(rule);
        ExecutorVisitor executorVisitor = new ExecutorVisitor(analyze);
        return executorVisitor.process(root, context);
    }

    public void testSimpleCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();
        String simpleRule =
                "rule_1 \"aa\"\n" +
                "r1 ${检查项目类型} = \"CT\"\n" +
                "满足 r1 输出 \"匹配\"\n" +
                "其他输出 \"没有匹配\"";
        Object result = execute(root, simpleRule);
        assertEquals(result, "匹配");
    }

    public void testNestCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();

        String nestRule =
                "rule_1 \"aa\"\n" +
                "r1 ${检查项目类型} = \"CT\"\n" +
                "r2 ${病灶描述} = \"结节\"; ${病灶存在状态} = \"确定\"\n" +
                "满足 r1 and r2 输出 \"匹配\"\n" +
                "其他输出 \"没有匹配\"";
        Object result = execute(root, nestRule);
        assertEquals(result, "匹配");

        String nestRule2 =
                "rule_1 \"aa\"\n" +
                "r1 ${检查项目类型} = \"CT\"\n" +
                "r2 ${病灶描述} = \"结节\"; ${病灶存在状态} = \"疑似\"\n" +
                "满足 r1 and r2 输出 \"匹配\"\n" +
                "其他输出 \"没有匹配\"";
        Object result2 = execute(root, nestRule2);
        assertEquals(result2, "没有匹配");
    }

    public void testContainsCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();
        String rule =
                "rule_1 \"aa\"\n" +
                "r1 ${检查项目类型} contains \"CT\"\n" +
                "r2 ${病灶描述} contains \"软组织影\"; ${病灶存在状态} = \"疑似\"\n" +
                "满足 r1 and r2 输出 \"匹配\"\n" +
                "其他输出 \"没有匹配\"";
        Object result = execute(root, rule);
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
        Object result = execute(root, rule);
        assertEquals(result, "没有匹配");
    }

    public void testCompareCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();

        String rule =
                "rule_1 \"aa\"\n" +
                        "r1 ${检查时间} >= ${就诊时间}" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result = execute(root, rule);
        assertEquals(result, "匹配");

        String rule1 =
                "rule_1 \"aa\"\n" +
                        "r1 ${检查时间} > ${就诊时间}" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result1 = execute(root, rule1);
        assertEquals(result1, "匹配");

        String rule2 =
                "rule_1 \"aa\"\n" +
                        "r1 ${检查时间} < ${就诊时间}" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result2 = execute(root, rule2);
        assertEquals(result2, "没有匹配");
    }

    public void testCTCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();
        Object execute = execute(root, RuleCase.chestCTExaminationRule);
        System.out.println(execute);
    }

}
