package org.venus.dsl.sql.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.sql.data.RecordData;
import org.venus.dsl.sql.analyze.Analyze;
import org.venus.dsl.sql.parse.node.AssertionNode;
import org.venus.dsl.sql.parse.node.MultipleRuleNode;

@AllArgsConstructor
public class MultipleRuleVisitor implements BaseVisitor {

    private final MultipleRuleNode node;

    private final Analyze analyze;

    @Override
    public Object visit(RecordData recordData) {
        AssertionNode assertionNode = node.getAssertion();
        return new AssertionVisitor(assertionNode, analyze).visit(recordData);
    }

}
