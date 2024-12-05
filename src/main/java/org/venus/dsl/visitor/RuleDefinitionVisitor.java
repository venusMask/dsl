package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.parse.node.RuleDefinitionNode;
import org.venus.dsl.parse.node.RuleLogicNode;
import org.venus.dsl.data.TreeNode;

import java.util.List;

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

//    @Override
//    public Boolean visit(TreeNode treeNode) {
//        List<RuleLogicNode> ruleLogics = node.getRuleLogics();
//        return visit(ruleLogics, treeNode);
//    }
//
//    private boolean visit(List<RuleLogicNode> ruleLogics, TreeNode root) {
//        // 如果规则列表为空，表示所有规则都匹配，返回 true
//        if (ruleLogics.isEmpty()) {
//            return true;
//        }
//        // 获取当前规则
//        RuleLogicNode currentRule = ruleLogics.get(0);
//        // 根据当前规则，筛选出符合条件的子节点
//        List<TreeNode> visited = new RuleLogicVisitor(currentRule, analyze).visit(root);
//        // 如果没有符合条件的节点，直接返回 false
//        if (visited == null || visited.isEmpty()) {
//            return false;
//        }
//        // 遍历当前规则符合的所有子节点
//        for (TreeNode newRoot : visited) {
//            // 对剩余规则递归调用 visit
//            if (visit(ruleLogics.subList(1, ruleLogics.size()), newRoot)) {
//                return true; // 如果有任意子节点满足后续规则，返回 true
//            }
//        }
//        // 如果所有子节点都无法匹配后续规则，返回 false
//        return false;
//    }

}
