package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.parse.node.AssertionNode;
import org.venus.dsl.parse.node.RuleGroupNode;
import org.venus.dsl.data.RecordData;

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
