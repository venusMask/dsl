package org.venus.dsl.sql;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.venus.dsl.sql.analyze.Analyze;
import org.venus.dsl.sql.data.HashMapData;
import org.venus.dsl.sql.data.RecordData;
import org.venus.dsl.sql.visitor.BaseVisitor;
import org.venus.dsl.sql.visitor.RuleGroupVisitor;
import org.venus.dsl.sql.ast.DslLexer;
import org.venus.dsl.sql.ast.DslParser;
import org.venus.dsl.sql.parse.AstParse;
import org.venus.dsl.sql.parse.node.RuleGroupNode;
import org.venus.dsl.sql.parse.node.SingleRuleNode;

import java.util.function.Consumer;

@Slf4j
public class BaseTest extends TestCase {

    public void testAnalyzeParse() throws Exception {
        HashMapData recordData = new HashMapData();
        recordData.setField("检查部位", "肺部");
        recordData.setField("否定词", "确定");
        BaseVisitor visitor = Analyze.parse(RuleCase.singleRuleGroupCase);
        System.out.println(visitor.visit(recordData));
    }

}
