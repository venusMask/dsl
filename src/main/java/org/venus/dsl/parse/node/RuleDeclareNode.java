package org.venus.dsl.parse.node;

import lombok.Getter;
import org.venus.dsl.visitor.AstVisitor;

@Getter
public class RuleDeclareNode extends Node {

    private final String ruleCode;

    private final String ruleName;

    public RuleDeclareNode(NodeLocation location,
                           String ruleCode,
                           String ruleName) {
        super(location);
        this.ruleCode = ruleCode;
        this.ruleName = ruleName;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitRuleDeclare(this, context);
    }
}
