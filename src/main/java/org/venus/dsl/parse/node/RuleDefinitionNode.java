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
        RuleLogicNode prev = null;
        for (RuleLogicNode ruleLogic : this.ruleLogics) {
            ruleLogic.setParent(this);
            ruleLogic.setPrev(prev);
            prev = ruleLogic;
            this.children.add(ruleLogic);
        }
    }

}
