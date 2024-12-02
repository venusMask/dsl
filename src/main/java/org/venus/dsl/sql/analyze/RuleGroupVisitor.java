package org.venus.dsl.sql.analyze;

import lombok.AllArgsConstructor;
import org.venus.dsl.sql.RecordData;
import org.venus.dsl.sql.parse.node.AssertionNode;
import org.venus.dsl.sql.parse.node.RuleGroupNode;

@AllArgsConstructor
public class RuleGroupVisitor implements BaseVisitor {

    private final RuleGroupNode node;

    private final Analyze analyze;

    @Override
    public Object visit(RecordData recordData) {
        AssertionNode assertion = node.getAssertion();
        return new AssertionVisitor(assertion, analyze).visit(recordData);
    }

}
