package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.parse.node.MatchNode;
import org.venus.dsl.parse.node.logic.LogicExprNode;
import org.venus.dsl.parse.node.output.OutputExprNode;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.analyze.Analyze;

@AllArgsConstructor
public class MatchVisitor implements BaseVisitor {

    private final MatchNode node;

    private final Analyze analyze;

    private final String ruleGroupID;

    @Override
    public Object visit(TreeNode TreeNode) {
        LogicExprNode logicExprNode = node.getLogicExpr();
        LogicExprVisitor visitor = new LogicExprVisitor(logicExprNode, analyze, ruleGroupID);
        Boolean flag = visitor.visit(TreeNode);
        if(flag) {
            OutputExprNode outputExpr = node.getOutputExpr();
            return new OutputExprVisitor(outputExpr, analyze).visit(TreeNode);
        } else {
            return null;
        }
    }

}
