package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.parse.node.AssertionNode;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.parse.node.MultipleRuleNode;

@AllArgsConstructor
public class MultipleRuleVisitor implements BaseVisitor {

    private final MultipleRuleNode node;

    private final Analyze analyze;

    @Override
    public Object visit(TreeNode TreeNode) {
        AssertionNode assertionNode = node.getAssertion();
        return new AssertionVisitor(assertionNode, analyze, node.getRuleDeclare().getRuleCode()).visit(TreeNode);
    }

}
