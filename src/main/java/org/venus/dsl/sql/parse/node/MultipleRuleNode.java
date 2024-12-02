package org.venus.dsl.sql.parse.node;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MultipleRuleNode extends Node {

    private RuleDeclareNode ruleDeclareNode;

    private List<RuleGroupNode> ruleGroupNode;

    private AssertionNode assertionNode;

    public MultipleRuleNode(RuleDeclareNode ruleDeclareNode,
                            List<RuleGroupNode> ruleGroupNode,
                            AssertionNode assertionNode) {
        this.ruleDeclareNode = ruleDeclareNode;
        this.assertionNode = assertionNode;
        this.ruleGroupNode = ruleGroupNode;
        this.children.add(ruleDeclareNode);
        this.children.addAll(ruleGroupNode);
        this.children.add(assertionNode);
    }
}
