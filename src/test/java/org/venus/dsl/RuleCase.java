package org.venus.dsl;

public class RuleCase {

    public static final String chestCTExaminationRule =
            "rule_name \"胸部CT检查是否阳性生产规则\"\n" +
                    "\n" +
                    "rule_group_1 \"胸部CT检查\"\n" +
                    "r1 ${default.检查项目类型} = \"CT\"\n" +
                    "x1 ${default.检查项目类型存在状态} = \"确定\"\n" +
                    "r2 ${default.检查部位} contains \"胸部\"\n" +
                    "r3 ${default.病灶部位} contains \"胸部\"; ${default.病灶存在状态} in {\"确定\", \"疑似\", \"拟\"}\n" +
                    "r4 ${default.检查部位} not_contains \"胸部\"\n" +
                    "满足 (r1 and x1 and r2) or ((r1 and r3) and not r4) 输出 \"是\"\n" +
                    "其他输出 \"否\"\n" +
                    "\n" +
                    "rule_group_2 \"检查结果阳性\"\n" +
                    "r4 ${default.病灶描述} contains {\"结节\", \"肿物\", \"占位\"}\n" +
                    "r5 ${default.病灶密度} in {\"实性\", \"非实性\", \"部分实性\"}\n" +
                    "r6 ${default.病灶部位} contains \"支气管\"; ${default.病灶存在状态} in {\"确定\", \"疑似\", \"拟\"}\n" +
                    "r7 ${default.病灶描述} contains {\"闭塞\", \"狭窄\", \"不规则\", \"粘液栓\"}\n" +
                    "r8 ${default.病灶部位} contains \"支气管壁\"\n" +
                    "r9 ${default.病灶部位变化情况} = \"增厚\"\n" +
                    "r10 ${default.病灶部位} = \"肺门\"; ${default.病灶存在状态} in {\"确定\", \"疑似\", \"拟\"}\n" +
                    "r11 ${default.病灶描述} contains \"软组织影\"\n" +
                    "r12 ${default.病灶部位} contains \"肺\"; ${default.病灶存在状态} in {\"确定\", \"疑似\", \"拟\"}\n" +
                    "r13 ${default.诊断名称} contains {\"慢阻肺诊断\", \"阻塞性肺部炎症诊断\"}; ${default.诊断存在状态} in {\"确定\", \"疑似\", \"拟\"}\n" +
                    "r14 ${default.诊断名称} contains \"肺不张诊断\"; ${default.诊断存在状态} in {\"确定\", \"疑似\", \"拟\"}\n" +
                    "满足 (r4 and r5 and (r6 or r12)) or (r6 and r7) or (r8 and r9) or (r10 and r11) or (r12 and r13) or r14 输出 \"是\"\n" +
                    "其他输出 \"否\"\n" +
                    "\n" +
                    "{\n" +
                    "\t满足 rule_group_1 and rule_group_2 输出 \"是\"\n" +
                    "\t其他输出 \"否\"\n" +
                    "}\n" +
                    "\n" +
                    "{\n" +
                    "    满足 rule_group_1 and rule_group_2 输出 \"是\"\n" +
                    "    其他输出 \"否\"\n" +
                    "}";

}
