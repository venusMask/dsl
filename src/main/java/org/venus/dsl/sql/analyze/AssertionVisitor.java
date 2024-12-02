package org.venus.dsl.sql.analyze;

import lombok.AllArgsConstructor;
import org.venus.dsl.sql.RecordData;
import org.venus.dsl.sql.parse.node.AssertionNode;
import org.venus.dsl.sql.parse.node.MatchNode;
import org.venus.dsl.sql.parse.node.output.OutputExprNode;

import java.util.List;

@AllArgsConstructor
public class AssertionVisitor implements BaseVisitor {

    private final AssertionNode node;

    private final Analyze analyze;

    @Override
    public Object visit(RecordData recordData) {
        List<MatchNode> matchNodes = node.getMatchNodes();
        List<OutputExprNode> otherOutput = node.getOtherOutput();
        for (MatchNode matchNode : matchNodes) {
            Object matchResult = new MatchVisitor(matchNode, analyze).visit(recordData);
            if(matchResult != null) {
                return matchResult;
            }
        }
        // 如果都不满足则执行其余输出条件的第一个
        return new OutputExprVisitor(otherOutput.get(0), analyze).visit(recordData);
    }

}
