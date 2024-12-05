package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.parse.node.RuleDefinitionNode;
import org.venus.dsl.parse.node.RuleLogicNode;
import org.venus.dsl.data.TreeNode;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class RuleDefinitionVisitor implements BaseVisitor {

    private final RuleDefinitionNode node;

    private final Analyze analyze;

    @Override
    public Boolean visit(TreeNode treeNode) {
        return matchRules(node.getRuleLogics(), 0, treeNode);
    }

    /**
     * 匹配规则
     *
     * @param ruleLogics   规则列表
     * @param index        当前匹配的规则索引
     * @param currentNode  当前节点
     * @return 是否匹配成功
     */
    private boolean matchRules(List<RuleLogicNode> ruleLogics, int index, TreeNode currentNode) {
        // 递归终止条件：所有规则已匹配完成
        if (index >= ruleLogics.size()) {
            return true;
        }

        // 当前规则逻辑
        RuleLogicNode currentRule = ruleLogics.get(index);

        // 获取当前规则匹配的子节点
        List<TreeNode> matchedNodes = new RuleLogicVisitor(currentRule, analyze).visit(currentNode);

        // 如果没有任何匹配的子节点，返回 false
        if (matchedNodes == null || matchedNodes.isEmpty()) {
            return false;
        }

        // 对当前规则匹配的子节点逐一递归检查剩余规则
        for (TreeNode childNode : matchedNodes) {
            if (matchRules(ruleLogics, index + 1, childNode)) {
                return true; // 如果有任意子节点匹配成功，返回 true
            }
        }

        // 所有子节点都无法匹配后续规则，返回 false
        return false;
    }

}
