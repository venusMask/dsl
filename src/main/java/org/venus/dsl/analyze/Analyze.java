package org.venus.dsl.analyze;

import lombok.Data;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.parse.node.*;

import java.util.HashMap;
import java.util.List;

@Data
public class Analyze {

    private final HashMap<String, RuleGroupNode> ruleGroups = new HashMap<>();

    private Boolean isSingleRule;

    private final TreeNode root;

    public Analyze(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot(String tableName) {
        return root;
    }

    public void initSingleRule(SingleRuleNode singleRuleNode) {
        this.isSingleRule = Boolean.TRUE;
        RuleGroupNode groupNode = singleRuleNode.getRuleGroup();
        String ruleCode = groupNode.getRuleDeclare().getRuleCode();
        ruleGroups.put(ruleCode, groupNode);
    }

    public void initMultipleRules(MultipleRuleNode multipleRuleNode) {
        this.isSingleRule = Boolean.FALSE;
        List<RuleGroupNode> groups = multipleRuleNode.getRuleGroups();
        for (RuleGroupNode groupNode : groups) {
            String ruleCode = groupNode.getRuleDeclare().getRuleCode();
            ruleGroups.put(ruleCode, groupNode);
        }
    }

    public RuleGroupNode getRuleGroup(String ruleGroupCode) {
        return ruleGroups.get(ruleGroupCode);
    }

    public RuleDefinitionNode getRuleDefinitionNode(String ruleGroupID,
                                                    String ruleDefinitionID) {
        RuleGroupNode ruleGroupNode = ruleGroups.get(ruleGroupID);
        HashMap<String, RuleDefinitionNode> definitionMap = ruleGroupNode.getRuleDefinitionMap();
        RuleDefinitionNode node = definitionMap.get(ruleDefinitionID);
        return node;
    }

}
