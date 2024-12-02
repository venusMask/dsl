package org.venus.dsl.sql.analyze;

import lombok.AllArgsConstructor;
import org.venus.dsl.sql.RecordData;
import org.venus.dsl.sql.parse.node.MatchNode;
import org.venus.dsl.sql.parse.node.logic.LogicExprNode;
import org.venus.dsl.sql.parse.node.output.OutputExprNode;

@AllArgsConstructor
public class MatchVisitor implements BaseVisitor {

    private final MatchNode node;

    private final Analyze analyze;

    @Override
    public Object visit(RecordData recordData) {
        LogicExprNode logicExprNode = node.getLogicExprNode();
        LogicExprVisitor visitor = new LogicExprVisitor(logicExprNode, analyze);
        Boolean flag = visitor.visit(recordData);
        if(flag) {
            OutputExprNode polyExprNode = node.getPolyExprNode();
            return new OutputExprVisitor(polyExprNode, analyze).visit(recordData);
        } else {
            return null;
        }
    }

}
