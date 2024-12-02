package org.venus.dsl.sql.parse.node.logic;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.sql.parse.node.type.OperationType;

@Getter
@Builder
public class StandardLogicExprNode extends LogicExprNode {

    private LogicExprNode leftNode;

    private OperationType operationType;

    private LogicExprNode rightNode;

    public StandardLogicExprNode(LogicExprNode leftNode,
                                 OperationType operationType,
                                 LogicExprNode rightNode) {
        this.leftNode = leftNode;
        this.operationType = operationType;
        this.rightNode = rightNode;
        this.children.add(leftNode);
        this.children.add(rightNode);
    }
}
