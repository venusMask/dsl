package org.venus.dsl.sql.parse.node.output;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.sql.parse.node.type.OperationType;

@Getter
@Builder
public class StandardOutputNode extends OutputExprNode {

    private OutputExprNode leftOutputExpr;

    private OperationType operationType;

    private OutputExprNode rightOutputExpr;

    public StandardOutputNode(OutputExprNode rightOutputExpr,
                              OperationType operationType,
                              OutputExprNode leftOutputExpr) {
        this.rightOutputExpr = rightOutputExpr;
        this.rightOutputExpr.setParent(this);
        this.operationType = operationType;
        this.leftOutputExpr = leftOutputExpr;
        this.leftOutputExpr.setParent(this);
        this.children.add(leftOutputExpr);
        this.children.add(rightOutputExpr);
    }
}
