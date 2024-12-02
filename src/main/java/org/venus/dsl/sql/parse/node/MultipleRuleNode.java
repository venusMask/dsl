package org.venus.dsl.sql.parse.node;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MultipleRuleNode extends Node {

    private RuleDeclareNode ruleDeclare;

    private List<RuleGroupNode> ruleGroups;

    private AssertionNode assertion;

    public MultipleRuleNode(RuleDeclareNode ruleDeclare,
                            List<RuleGroupNode> ruleGroups,
                            AssertionNode assertion) {
        this.ruleDeclare = ruleDeclare;
        this.ruleDeclare.setParent(this);
        this.assertion = assertion;
        this.assertion.setParent(this);
        this.ruleGroups = ruleGroups;
        for (RuleGroupNode groupNode : this.ruleGroups) {
            groupNode.setParent(this);
            this.children.add(groupNode);
        }
        this.children.add(ruleDeclare);
        this.children.add(assertion);
    }

}
