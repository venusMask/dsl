package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.parse.node.SingleRuleNode;
import org.venus.dsl.data.RecordData;
import org.venus.dsl.analyze.Analyze;

@AllArgsConstructor
public class SingleRuleVisitor implements BaseVisitor {

    private final SingleRuleNode node;

    private final Analyze analyzer;

    @Override
    public Object visit(RecordData recordData) {
        return new RuleGroupVisitor(node.getRuleGroup(), analyzer).visit(recordData);
    }

}