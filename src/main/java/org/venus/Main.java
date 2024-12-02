package org.venus;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.venus.dsl.sql.HashMapData;
import org.venus.dsl.sql.RecordData;
import org.venus.dsl.sql.analyze.Analyze;
import org.venus.dsl.sql.analyze.RuleGroupVisitor;
import org.venus.dsl.sql.ast.DslLexer;
import org.venus.dsl.sql.ast.DslParser;
import org.venus.dsl.sql.parse.node.RuleGroupNode;
import org.venus.dsl.sql.parse.node.SingleRuleNode;
import org.venus.dsl.sql.parse.AstParse;

public class Main {

    public static String testCase1() {
        return "rule_1 \"rule_name\"\n" +
                "a1 ${检查部位} = \"CT\"\n" +
                "a2 ${a1} = \"CT\"\n" +
                "满足 not a1 输出 \"匹配出a1\"\n" +
                "其他输出 \"没有任何数据匹配\"";
    }

    public static String testCase2() {
        return "rule_1 \"rule_name\"\n" +
                "a1 ${检查部位} = \"CT\"\n" +
                "a2 ${a1} = \"CT\"\n" +
                "满足 a1 输出 \"匹配出a1\"\n" +
                "其他输出 \"没有任何数据匹配\"";
    }

    public static void testCase(String input, RecordData data) {
        CharStream charStream = CharStreams.fromString(input);
        DslLexer lexer = new DslLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DslParser parser = new DslParser(tokens);
        ParseTree root = parser.dsl();
        AstParse dslVisitor = new AstParse();
        SingleRuleNode logicPlan = (SingleRuleNode) dslVisitor.visit(root);
        RuleGroupNode ruleGroupNode = logicPlan.getRuleGroupNodes().get(0);
        Analyze analyze = new Analyze(logicPlan);
        Object visit = new RuleGroupVisitor(ruleGroupNode, analyze).visit(data);
        System.out.println("Result: " + visit);
    }

    public static void main(String[] args) {
        HashMapData hashMapData = new HashMapData();
        hashMapData.setField("检查部位", "CT");
        testCase(testCase1(), hashMapData);
        testCase(testCase2(), hashMapData);
    }

}
