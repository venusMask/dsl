package org.venus.dsl.sql;

public class RuleCase {

    public static final String singleRuleGroupCase =
            "rule_1 \"rule_group_name\"\n" +
            "r1 ${检查部位} = \"CT\"\n" +
            "r2 ${否定词} = \"确定\"\n" +
            "满足     r1 输出 \"匹配r1\"\n" +
            "满足 not r2 输出 \"匹配r2\"\n" +
            "其他输出 \"没有匹配到任何数据\"";

    public static final String complexRuleGroupCase =
            "rule_1 \"肺实性/非实性/部分实性结节\"\n" +
            "a1 ${检查项目类型} = \"CT\"; ${检查项目类型存在状态} = \"确定\"\n" +
            "a2 ${检查部位} -> [\"肺癌-部位映射表\"] = \"胸部\"\n" +
            "a3 ${病灶部位} in {\"肺\",\"气管\"}; ${病灶存在状态} in {\"确定\",\"疑似\",\"拟\"}\n" +
            "a4 ${病灶描述} in {\"结节\", \"肿物\", \"占位\", \"包块\"}\n" +
            "a5 ${病灶密度} in {\"实性\", \"非实性\", \"部分实性\"}\n" +
            "满足 a1 and (a2 or a3 ) and a4 and a5  输出 \"满足\"\n" +
            "其他输出 \"没有匹配到任何规则\"";

}
