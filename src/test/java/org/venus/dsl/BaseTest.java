package org.venus.dsl;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.analyze.LineAnalyze;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.parse.AstParse;
import org.venus.dsl.parse.TableInfo;
import org.venus.dsl.parse.node.Node;
import org.venus.dsl.visitor.ExecutorVisitor;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class BaseTest extends TestCase {

    private Object execute(TreeNode context, String rule) {
        TableInfo parse = new AstParse().parse(rule);
        Analyze analyze = new Analyze(context);
        MemoryDictHandler dictHandler = new MemoryDictHandler();
        ExecutorVisitor executorVisitor = new ExecutorVisitor(analyze, dictHandler);
        return executorVisitor.process(parse.getNode(), context);
    }

    public void testDict() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();
        String simpleRule =
                "rule_1 \"aa\"\n" +
                        "r1 ${default.检查项目类型} -> [b] = \"null\"\n" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result = execute(root, simpleRule);
        assertEquals(result, "没有匹配");
    }

    public void testSimpleCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();
        String simpleRule =
                "rule_1 \"aa\"\n" +
                        "r1 ${default.检查项目类型} = \"CT\"\n" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result = execute(root, simpleRule);
        assertEquals(result, "匹配");
    }

    public void testNestCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();

        String nestRule =
                "rule_1 \"aa\"\n" +
                        "r1 ${default.检查项目类型} = \"CT\"\n" +
                        "r2 ${default.病灶描述} = \"结节\"; ${default.病灶存在状态} = \"确定\"\n" +
                        "满足 r1 and r2 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result = execute(root, nestRule);
        assertEquals(result, "匹配");

        String nestRule2 =
                "rule_1 \"aa\"\n" +
                        "r1 ${default.检查项目类型} = \"CT\"\n" +
                        "r2 ${default.病灶描述} = \"结节\"; ${default.病灶存在状态} = \"疑似\"\n" +
                        "满足 r1 and r2 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result2 = execute(root, nestRule2);
        assertEquals(result2, "没有匹配");
    }

    public void testContainsCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();
        String rule =
                "rule_1 \"aa\"\n" +
                        "r1 ${default.检查项目类型} contains \"CT\"\n" +
                        "r2 ${default.病灶描述} contains \"软组织影\"; ${default.病灶存在状态} = \"疑似\"\n" +
                        "满足 r1 and r2 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result = execute(root, rule);
        assertEquals(result, "匹配");
    }

    public void testContainsCase2() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();
        String rule =
                "rule_1 \"aa\"\n" +
                        "r1 ${default.检查项目类型} contains \"CT\"\n" +
                        "r2 ${default.病灶描述} contains \"软组织影\"; ${default.病灶存在状态} = \"确定\"\n" +
                        "满足 r1 and r2 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result = execute(root, rule);
        assertEquals(result, "没有匹配");
    }

    public void testCompareCase() throws Exception {
        TreeNode root = TreeNodeTest.buildCTTreeData();

        String rule =
                "rule_1 \"aa\"\n" +
                        "r1 ${default.检查时间} >= ${default.就诊时间}" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result = execute(root, rule);
        assertEquals(result, "匹配");

        String rule1 =
                "rule_1 \"aa\"\n" +
                        "r1 ${default.检查时间} > ${default.就诊时间}" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        Object result1 = execute(root, rule1);
        assertEquals(result1, "匹配");

        String rule2 =
                "rule_1 \"aa\"\n" +
                        "r1 ${default.检查时间} < ${default.就诊时间}" +
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

    public void testLineAnalyze() throws Exception {
        MemoryDictHandler memoryDictHandler = new MemoryDictHandler();
        String tableName = "table_1";
        String fieldName1 = "field_1";
        String fieldName1Rule =
                "rule_1 \"aa\"\n" +
                        "r1 ${检验.检查项目类型} = \"CT\"\n" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        TableInfo ruleNode1 = new AstParse().parse(fieldName1Rule);
        String fieldName2 = "field_2";
        String fieldName2Rule =
                "rule_1 \"aa\"\n" +
                        "r1 ${检查.检查项目类型} = \"CT\"\n" +
                        "满足 r1 输出 \"匹配\"\n" +
                        "其他输出 \"没有匹配\"";
        TableInfo ruleNode2 = new AstParse().parse(fieldName2Rule);
        Map<String, Map<String, TableInfo>> fieldNodes = new HashMap<>();
        Map<String, TableInfo> f = fieldNodes.computeIfAbsent(tableName, k -> new HashMap<>());
        f.put(fieldName1, ruleNode1);
        f.put(fieldName2, ruleNode2);


        TreeNode root = new TreeNode("检查", "检查");
        TreeNode A = new TreeNode("A", "A_V");
        TreeNode B = new TreeNode("B", "B_V");
        root.addChild(A);
        root.addChild(B);

        TreeNode root2 = new TreeNode("检验", "检验");
        TreeNode A2 = new TreeNode("A2", "A2_V");
        TreeNode B2 = new TreeNode("B2", "B2_V");
        root2.addChild(A2);
        root2.addChild(B2);

        Map<String, List<TreeNode>> dataRoots = new HashMap<>();
        dataRoots.put("检查", Collections.singletonList(root));
        dataRoots.put("检验", Collections.singletonList(root2));
        LineAnalyze lineAnalyze = new LineAnalyze(
                fieldNodes,
                dataRoots,
                memoryDictHandler
        );
        Map<String, Map<String, List<Object>>> analyze = lineAnalyze.analyze();
        System.out.println(analyze);
    }

}
