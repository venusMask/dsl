package org.venus.dsl.sql.parse.node;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

@Getter
@Builder
public class RuleGroupNode extends Node {

    private final RuleDeclareNode ruleDeclare;

    private final List<RuleDefinitionNode> ruleDefinition;

    private final AssertionNode assertion;

    private final HashMap<String, RuleDefinitionNode> ruleDefinitionMap = new HashMap<>();

    public RuleGroupNode(RuleDeclareNode ruleDeclare,
                         List<RuleDefinitionNode> ruleDefinition,
                         AssertionNode assertion) {
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

}
