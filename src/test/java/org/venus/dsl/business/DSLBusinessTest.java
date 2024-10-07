package org.venus.dsl.business;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import junit.framework.TestCase;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.venus.dsl.business.pojo.DSL;
import org.venus.dsl.gen.DSLLexer;
import org.venus.dsl.gen.DSLParser;

/**
 * Test
 */
public class DSLBusinessTest extends TestCase {

    public void testDSLBusiness() {
        assertTrue(true);
    }

    public void createBaseParser(String text) {
        CharStream charStream = CharStreams.fromString(text);
        DSLLexer dslLexer = new DSLLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(dslLexer);
        DSLParser dslParser = new DSLParser(tokenStream);
        DSLParser.DslContext root = dslParser.dsl();
        DSLBusiness logic = new DSLBusiness();
        logic.visitDsl(root);
        DSL dsl = logic.getDsl();
        String jsonString = JSON.toJSONString(dsl, JSONWriter.Feature.PrettyFormat);
        System.out.println(jsonString);
    }

    public void testSingleRule() {
        String text = "// a1的使用规则\n" +
                "a1 rule_name_cn_你 rule_name_en\n" +
                "1 a_1_你=  ct_你 且 查项目类型存在状态  = 确定;\n" +
                "2 检查项目类型=ct_你 且 查项目类型存在状态=确定;\n" +
                "3 检查项目类型=ct_我 且 查项目类型存在状态=确定;\n" +
                "满足: 1+(2/3) 值域: \"你呀\";\n" +
                "满足: 1+(2/3) 值域:\"你呀\";\n" +
                "其他值域 \"2\"";
        createBaseParser(text);
    }

    public void testMultipleRule() {
        String text = "// a1的使用规则\n" +
                "a1 rule_name_cn_你 rule_name_en\n" +
                "a1 rule_name_cn_你 rule_name_en\n" +
                "1 a_1_你=  ct_你 且 查项目类型存在状态  = 确定;\n" +
                "2 检查项目类型=ct_你 且 查项目类型存在状态=确定;\n" +
                "3 检查项目类型=ct_我 且 查项目类型存在状态=确定;\n" +
                "满足: 1+(2/3) 值域: \"你呀\";\n" +
                "满足: 1+(2/3) 值域:\"你呀\";\n" +
                "其他值域 \"2\"\n" +
                "\n" +
                "满足: 1+(2/3) 值域: \"你呀\";\n" +
                "满足: 1+(2/3) 值域:\"你呀\";\n" +
                "其他值域 \"2\"";
        createBaseParser(text);
    }

}
