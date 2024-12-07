package org.venus.dsl.parse.node;

import lombok.Getter;
import org.venus.dsl.visitor.AstVisitor;

@Getter
public class SingleRuleNode extends Node {

    private final RuleGroupNode ruleGroup;

    public SingleRuleNode(NodeLocation location,
                          RuleGroupNode ruleGroup) {
        super(location);
        this.ruleGroup = ruleGroup;
        this.ruleGroup.setParent(this);
        this.children.add(ruleGroup);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitSingleRule(this, context);
    }

}
