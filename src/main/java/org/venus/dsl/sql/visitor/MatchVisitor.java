package org.venus.dsl.sql.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.sql.data.RecordData;
import org.venus.dsl.sql.analyze.Analyze;
import org.venus.dsl.sql.parse.node.MatchNode;
import org.venus.dsl.sql.parse.node.logic.LogicExprNode;
import org.venus.dsl.sql.parse.node.output.OutputExprNode;

@AllArgsConstructor
public class MatchVisitor implements BaseVisitor {

    private final MatchNode node;

    private final Analyze analyze;

    @Override
    public Object visit(RecordData recordData) {
        LogicExprNode logicExprNode = node.getLogicExpr();
        LogicExprVisitor visitor = new LogicExprVisitor(logicExprNode, analyze);
        Boolean flag = visitor.visit(recordData);
        if(flag) {
            OutputExprNode polyExprNode = node.getOutputExpr();
            return new OutputExprVisitor(polyExprNode, analyze).visit(recordData);
        } else {
            return null;
        }
    }

}
