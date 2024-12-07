package org.venus.dsl.parse.node;

import java.util.List;

import lombok.Getter;
import org.venus.dsl.visitor.AstVisitor;

@Getter
public class MultipleRuleNode extends Node {

    private final RuleDeclareNode ruleDeclare;

    private final List<RuleGroupNode> ruleGroups;

    private final AssertionNode assertion;

    public MultipleRuleNode(NodeLocation location,
                            RuleDeclareNode ruleDeclare,
                            List<RuleGroupNode> ruleGroups,
                            AssertionNode assertion) {
        super(location);
        this.ruleDeclare = ruleDeclare;
        this.ruleDeclare.setParent(this);
        this.assertion = assertion;
        this.assertion.setParent(this);
        this.ruleGroups = ruleGroups;
        for (RuleGroupNode groupNode : this.ruleGroups) {
            groupNode.setParent(this);
            this.children.add(groupNode);
        }
        this.children.add(ruleDeclare);
        this.children.add(assertion);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitMultipleRule(this, context);
    }
}
