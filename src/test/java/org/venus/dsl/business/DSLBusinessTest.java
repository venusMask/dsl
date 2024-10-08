package org.venus.dsl.business;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import junit.framework.TestCase;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.venus.dsl.gen.DSLLexer;
import org.venus.dsl.gen.DSLParser;

/**
 * Test
 */
public class DSLBusinessTest extends TestCase {

    public void testDSLBusiness() {
        assertTrue(true);
    }

    private void createBaseParser(String text) {
        CharStream charStream = CharStreams.fromString(text);
        DSLLexer dslLexer = new DSLLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(dslLexer);
        DSLParser dslParser = new DSLParser(tokenStream);
        DSLParser.DslContext root = dslParser.dsl();
        DSLBusiness logic = new DSLBusiness();
        logic.visitDsl(root);
        consoleDSL(logic);
    }

    private void consoleDSL(DSLBusiness logic) {
        System.out.println(JSON.toJSONString(logic.getDsl(), JSONWriter.Feature.PrettyFormat));
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

    public void testSingleRule2() {
        String text = "规则一  \"肺实性/非实性/部分实性结节\" \"asdasd\"\n" +
                "\n" +
                "1  检查项目类型 =CT，且 对应的（检查项目类型存在状态）=确定\n" +
                "2、 检查部位 =胸部 <取“肺癌-部位映射表”附表映射后结果>\n" +
                "3、（病灶部位）=肺/气管，且对应的（病灶存在状态）=确定/疑似/拟\n" +
                "4、（病灶描述）=结节/肿物/占位/包块，\n" +
                "5、（病灶密度）= Or[实性,非实性,部分实性] 实性/非实性/部分实性\n" +
                "\n" +
                "满足： 1 +（2 / 3）+ 4 + 5  值域： 是 -> 满足\n" +
                "满足： 1 +（2 / 3）+ 4 + 5  值域： 否 -> 不满足\n" +
                "满足： 1 +（2 / 3）+ 4 + 5  值域： 可能- > 满足\n" +
                "其他值域：未知\n";

    }

    public void testNewGrammar() {
        String text = "1 中文 en \n" +
                "1、字段 属于 {1你};\n" +
                "1、字段 属于 1你2;\n" +
                "满足: \"1\" 值域: \"满足\";";
        createBaseParser(text);
    }

}
