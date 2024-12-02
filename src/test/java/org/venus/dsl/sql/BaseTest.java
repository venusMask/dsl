package org.venus.dsl.sql;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.venus.dsl.sql.analyze.Analyze;
import org.venus.dsl.sql.analyze.RuleGroupVisitor;
import org.venus.dsl.sql.ast.DslLexer;
import org.venus.dsl.sql.ast.DslParser;
import org.venus.dsl.sql.parse.AstParse;
import org.venus.dsl.sql.parse.node.RuleGroupNode;
import org.venus.dsl.sql.parse.node.SingleRuleNode;

import java.util.function.Consumer;

@Slf4j
public class BaseTest extends TestCase {

    private Object executeRecognition(String input, RecordData recordData) {
        CharStream charStream = CharStreams.fromString(input);
        DslLexer lexer = new DslLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DslParser parser = new DslParser(tokens);
        ParseTree root = parser.dsl();
        AstParse dslParse = new AstParse();
        SingleRuleNode logicPlan = (SingleRuleNode) dslParse.visit(root);
        long start = System.currentTimeMillis();
        RuleGroupNode ruleGroupNode = logicPlan.getRuleGroupNodes().get(0);
        Analyze analyze = new Analyze(logicPlan);
        Object result = new RuleGroupVisitor(ruleGroupNode, analyze).visit(recordData);
        long end = System.currentTimeMillis();
        log.info("Parse Data Time: {} ms", end - start);
        return result;
    }

    private void timeMetric(Consumer<HashMapData> consumer, HashMapData recordData ,String executeMsg) {
        long start = System.currentTimeMillis();
        consumer.accept(recordData);
        long end = System.currentTimeMillis();
        log.info("Execution Msg: {}, Execution Time: {} ms", executeMsg, (end - start));
    }

    public void testSimpleRuleGroup() throws Exception {
        HashMapData recordData = new HashMapData();
        recordData.setField("检查部位", "肺部");
        recordData.setField("否定词", "确定");
        timeMetric(new Consumer<HashMapData>() {
            @Override
            public void accept(HashMapData recordData) {
                Object result = executeRecognition(RuleCase.singleRuleGroupCase, recordData);
                assertEquals(result, "没有匹配到任何数据");
            }
        },  recordData,"TestSimpleRuleGroup");
    }

    public void testComplexRuleGroup() throws Exception {
        HashMapData recordData = new HashMapData();
        recordData.setField("检查项目类型", "CT");
        recordData.setField("检查项目类型存在状态", "确定");
        recordData.setField("检查部位", "胸部");
        recordData.setField("病灶部位", "肺");
        recordData.setField("病灶存在状态", "疑似");
        recordData.setField("病灶描述", "结节");
        recordData.setField("病灶密度", "非实性");
        timeMetric(new Consumer<HashMapData>() {
            @Override
            public void accept(HashMapData recordData) {
                Object result = executeRecognition(RuleCase.complexRuleGroupCase, recordData);
                assertEquals(result, "满足");
            }
        },  recordData,"TestComplexRuleGroup");
    }

}
