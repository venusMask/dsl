package org.venus.dsl.sql.analyze;

import lombok.Data;
import org.venus.dsl.sql.parse.node.RuleDefinitionNode;
import org.venus.dsl.sql.parse.node.RuleGroupNode;
import org.venus.dsl.sql.parse.node.SingleRuleNode;

import java.util.HashMap;
import java.util.List;

/**
 * 进行语义分析完成之后的结果
 */
@Data
public class Analyze {

    private final HashMap<String, RuleGroupNode> ruleGroups = new HashMap<>();

    public Analyze(SingleRuleNode singleRuleNode) {
        List<RuleGroupNode> ruleGroupNodes = singleRuleNode.getRuleGroupNodes();
        for (RuleGroupNode ruleGroupNode : ruleGroupNodes) {
            String ruleCode = ruleGroupNode.getRuleDeclare().getRuleCode();
            ruleGroups.put(ruleCode, ruleGroupNode);
        }
    }

    public RuleDefinitionNode getRuleDefinitionNode(String ruleGroupID,
                                                    String ruleDefinitionID) {
        RuleGroupNode ruleGroupNode = ruleGroups.get(ruleGroupID);
        HashMap<String, RuleDefinitionNode> definitionMap = ruleGroupNode.getRuleDefinitionMap();
        RuleDefinitionNode node = definitionMap.get(ruleDefinitionID);
        return node;
    }

    // 默认是单行
    public RuleDefinitionNode getRuleDefinitionNode(String ruleDefinitionID) {
        return ruleGroups
                .values()
                .stream()
                .findFirst()
                .map(ruleGroupNode -> getRuleDefinitionNode(ruleGroupNode.getRuleDeclare().getRuleCode(), ruleDefinitionID))
                .orElse(null);
    }

}
