package org.venus.dsl.sql.parse.node.output;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.sql.parse.node.type.OperationType;

@Getter
@Builder
public class StandardOutputNode extends OutputExprNode {

    private OutputExprNode leftValue;

    private OperationType operationType;

    private OutputExprNode rightValue;

    public StandardOutputNode(OutputExprNode rightValue,
                              OperationType operationType,
                              OutputExprNode leftValue) {
        this.rightValue = rightValue;
        this.operationType = operationType;
        this.leftValue = leftValue;
        this.children.add(leftValue);
        this.children.add(rightValue);
    }
}
