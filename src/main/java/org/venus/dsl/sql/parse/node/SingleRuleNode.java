package org.venus.dsl.sql.parse.node;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class SingleRuleNode extends Node {

    private List<RuleGroupNode> ruleGroupNodes;

    public SingleRuleNode(List<RuleGroupNode> ruleGroupNodes) {
        this.ruleGroupNodes = ruleGroupNodes;
        this.children.addAll(ruleGroupNodes);
    }

}
