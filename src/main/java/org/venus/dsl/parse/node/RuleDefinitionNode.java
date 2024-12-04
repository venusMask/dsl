package org.venus.dsl.parse.node;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RuleDefinitionNode extends Node {

    private String ruleCode;

    private List<RuleLogicNode> ruleLogics;

    public RuleDefinitionNode(String ruleCode,
                              List<RuleLogicNode> ruleLogics) {
        this.ruleCode = ruleCode;
        this.ruleLogics = ruleLogics;
        this.ruleLogics.forEach(operation -> {
            operation.setParent(this);
            this.children.add(operation);
        });
    }

}
