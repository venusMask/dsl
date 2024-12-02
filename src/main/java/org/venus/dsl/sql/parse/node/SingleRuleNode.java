package org.venus.dsl.sql.parse.node;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SingleRuleNode extends Node {

    private RuleGroupNode ruleGroup;

    public SingleRuleNode(RuleGroupNode ruleGroup) {
        this.ruleGroup = ruleGroup;
        this.ruleGroup.setParent(this);
        this.children.add(ruleGroup);
    }

}
