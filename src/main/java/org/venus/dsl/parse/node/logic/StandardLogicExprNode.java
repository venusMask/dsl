package org.venus.dsl.parse.node.logic;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.parse.node.type.OperationType;

@Getter
@Builder
public class StandardLogicExprNode extends LogicExprNode {

    private LogicExprNode leftLogicExpr;

    private OperationType operationType;

    private LogicExprNode rightLogicExpr;

    public StandardLogicExprNode(LogicExprNode leftLogicExpr,
                                 OperationType operationType,
                                 LogicExprNode rightLogicExpr) {
        this.leftLogicExpr = leftLogicExpr;
        this.leftLogicExpr.setParent(this);
        this.operationType = operationType;
        this.rightLogicExpr = rightLogicExpr;
        this.rightLogicExpr.setParent(this);
        this.children.add(leftLogicExpr);
        this.children.add(rightLogicExpr);
    }

}
