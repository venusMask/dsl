package org.venus.dsl.sql.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.sql.data.RecordData;
import org.venus.dsl.sql.analyze.Analyze;
import org.venus.dsl.sql.parse.node.SingleRuleNode;

@AllArgsConstructor
public class SingleRuleVisitor implements BaseVisitor {

    private final SingleRuleNode node;

    private final Analyze analyzer;

    @Override
    public Object visit(RecordData recordData) {
        return new RuleGroupVisitor(node.getRuleGroup(), analyzer).visit(recordData);
    }

}
