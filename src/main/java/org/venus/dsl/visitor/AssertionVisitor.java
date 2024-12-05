package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.parse.node.AssertionNode;
import org.venus.dsl.parse.node.MatchNode;
import org.venus.dsl.parse.node.output.OutputExprNode;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.analyze.Analyze;

import java.util.List;

@AllArgsConstructor
public class AssertionVisitor implements BaseVisitor {

    private final AssertionNode node;

    private final Analyze analyze;

    private final String ruleGroupID;

    @Override
    public Object visit(TreeNode TreeNode) {
        List<MatchNode> matchNodes = node.getMatches();
        List<OutputExprNode> otherOutput = node.getOtherOutputs();
        for (MatchNode matchNode : matchNodes) {
            Object matchResult = new MatchVisitor(matchNode, analyze, ruleGroupID).visit(TreeNode);
            if(matchResult != null) {
                return matchResult;
            }
        }
        // 如果都不满足则执行其余输出条件的第一个
        return new OutputExprVisitor(otherOutput.get(0), analyze).visit(TreeNode);
    }

}
