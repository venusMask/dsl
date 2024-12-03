package org.venus.dsl;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.data.HashMapData;
import org.venus.dsl.data.TreeData;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.visitor.BaseVisitor;

@Slf4j
public class BaseTest extends TestCase {

    public void testAnalyzeParse() throws Exception {
        String rule =
                "rule_1 \"肺实性/非实性/部分实性结节\"\n" +
                        "a1 ${检查项目类型} = \"CT\"; ${检查项目类型存在状态} = \"确定\"\n" +
                        "a2 ${检查部位} -> [\"肺癌-部位映射表\"] = \"胸部\"\n" +
                        "a3 ${病灶部位} in {\"肺\",\"气管\"}; ${病灶存在状态} in {\"确定\",\"疑似\",\"拟\"}\n" +
                        "a4 ${病灶描述} in {\"结节\", \"肿物\", \"占位\", \"包块\"}\n" +
                        "a5 ${病灶密度} in {\"实性\", \"非实性\", \"部分实性\"}\n" +
                        "满足 a1 and (a2 or a3 ) and a4 and a5  输出 \"满足\"\n" +
                        "其他输出 \"没有匹配到任何规则\"";
        HashMapData recordData = new HashMapData();
        recordData.setField("检查部位", "肺部");
        recordData.setField("否定词", "确定");

        BaseVisitor visitor = Analyze.parse(rule);
        System.out.println(visitor.visit(recordData));
    }

    public void testFieldTakeInOutput() throws Exception {
        String rule = "rule \"姓名生产规则\"\n" +
                "x1 ${姓名} != \"null\"\n" +
                "满足 x1 输出 ${姓名}";
        HashMapData recordData = new HashMapData();
        recordData.setField("姓名", "姓名aaa");
        Object result = Analyze.parse(rule).visit(recordData);
        assertEquals(result, "姓名aaa");
    }

    public void testTreeData() throws Exception {
        String rule =
                "rule_1 \"吸烟史评估结果\"\n" +
                "a1 ${摄入史内容} = \"吸烟\"; ${个人史存在状态} in {\"确定\", \"疑似\", \"拟\"}\n" +
                "a2 ${摄入史内容} = \"戒烟\"; ${个人史存在状态}  = \"否定\"\n" +
                "a3 ${摄入史内容} != \"戒烟\"\n" +
                "a4 ${摄入史内容} = \"复吸\"; ${个人史存在状态} in {\"确定\", \"疑似\", \"拟\"}\n" +
                "a5 ${摄入史内容} = \"戒烟\"; ${个人史存在状态} in {\"确定\", \"疑似\", \"拟\"}\n" +
                "a6 ${摄入史内容} = \"复吸\"; ${个人史存在状态} = \"否定\"\n" +
                "a7 ${摄入史内容} != \"复吸\"\n" +
                "a8 ${摄入史内容} = \"吸烟\"; ${个人史存在状态} = \"否定\"\n" +
                "满足 a1 and (a2 or a3 or a4) 输出 \"当前吸烟\"\n" +
                "满足 a5 and (a6 or a7) 输出 \"已戒烟\"\n" +
                "满足 a8 输出 \"从不吸烟\"\n" +
                "其他输出 \"不详\"";
        TreeData data = new TreeData();
        TreeNode node1 = TreeDataTest.buildNode("吸烟史评估结果", "NULL");
        data.addChild(node1);
        TreeNode node2 = TreeDataTest.buildNode("摄入史内容", "吸烟");
        data.addChild(node1, node2);
        TreeNode node3 = TreeDataTest.buildNode("个人史存在状态", "否定");
        data.addChild(node1, node3);
        Object result = Analyze.parse(rule).visit(data);
        System.out.println(result);
    }

}
