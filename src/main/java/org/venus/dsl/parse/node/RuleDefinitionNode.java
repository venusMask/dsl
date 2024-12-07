package org.venus.dsl.parse.node;

import lombok.Getter;
import org.venus.dsl.visitor.AstVisitor;

import java.util.List;

@Getter
public class RuleDefinitionNode extends Node {

    private final String ruleCode;

    private final List<RuleLogicNode> ruleLogics;

    public RuleDefinitionNode(NodeLocation location,
                              String ruleCode,
                              List<RuleLogicNode> ruleLogics) {
        super(location);
        this.ruleCode = ruleCode;
        this.ruleLogics = ruleLogics;
        RuleLogicNode prev = null;
        for (RuleLogicNode ruleLogic : this.ruleLogics) {
            ruleLogic.setParent(this);
            ruleLogic.setPrev(prev);
            prev = ruleLogic;
            this.children.add(ruleLogic);
        }
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitRuleDefinition(this, context);
    }
}
