package org.venus;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.venus.dsl.business.pojo.DSL;
import org.venus.dsl.business.DSLBusiness;
import org.venus.dsl.gen.DSLLexer;
import org.venus.dsl.gen.DSLParser;

public class App {

    public static void main(String[] args) {
        String text = "// a1的使用规则\n" +
                "a1 rule_name_cn_你 rule_name_en\n" +
                "1 a_1_你=  ct_你 且 查项目类型存在状态  = 确定;\n" +
                "2 检查项目类型=ct_你 且 查项目类型存在状态=确定;\n" +
                "3 检查项目类型=ct_我 且 查项目类型存在状态=确定;\n" +
                "满足: 1+(2/3) 值域: \"你呀\";\n" +
                "满足: 1+(2/3) 值域:\"你呀\";\n" +
                "其他值域 \"2\"";
        CharStream charStream = CharStreams.fromString(text);
        DSLLexer dslLexer = new DSLLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(dslLexer);
        DSLParser dslParser = new DSLParser(tokenStream);
        DSLParser.DslContext root = dslParser.dsl();
        DSLBusiness logic = new DSLBusiness();
        logic.visitDsl(root);
        DSL dsl = logic.getDsl();
        System.out.println(dsl.toString());
    }

}
