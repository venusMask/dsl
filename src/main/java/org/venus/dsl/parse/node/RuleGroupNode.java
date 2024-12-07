package org.venus.dsl.parse.node;

import lombok.Getter;
import org.venus.dsl.visitor.AstVisitor;

import java.util.HashMap;
import java.util.List;

@Getter
public class RuleGroupNode extends Node {

    private final RuleDeclareNode ruleDeclare;

    private final List<RuleDefinitionNode> ruleDefinition;

    private final AssertionNode assertion;

    private final HashMap<String, RuleDefinitionNode> ruleDefinitionMap = new HashMap<>();

    public RuleGroupNode(NodeLocation location,
                         RuleDeclareNode ruleDeclare,
                         List<RuleDefinitionNode> ruleDefinition,
                         AssertionNode assertion) {
        super(location);
        this.ruleDeclare = ruleDeclare;
        this.ruleDeclare.setParent(this);
        this.ruleDefinition = ruleDefinition;
        this.assertion = assertion;
        this.assertion.setParent(this);
        this.children.add(ruleDeclare);
        this.children.addAll(ruleDefinition);
        this.children.add(assertion);
        this.ruleDefinition.forEach(definition -> {
            definition.setParent(this);
            ruleDefinitionMap.put(definition.getRuleCode(), definition);
        });
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitRuleGroup(this, context);
    }
}
