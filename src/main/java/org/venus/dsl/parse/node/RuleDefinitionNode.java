package org.venus.dsl.parse.node;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RuleDefinitionNode extends Node {

    private String ruleCode;

    private List<RuleLogicNode> operations;

    public RuleDefinitionNode(String ruleCode,
                              List<RuleLogicNode> operations) {
        this.ruleCode = ruleCode;
        this.operations = operations;
        this.operations.forEach(operation -> {
            operation.setParent(this);
            this.children.add(operation);
        });
    }

}
