package org.venus.dsl;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.data.HashMapData;
import org.venus.dsl.visitor.BaseVisitor;

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
