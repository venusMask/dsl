package org.venus.dsl.parse.node.logic;

import lombok.Getter;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

@Getter
public class StandardLogicExprNode extends LogicExprNode {

    private final LogicExprNode leftLogicExpr;

    private final OperationType operationType;

    private final LogicExprNode rightLogicExpr;

    public StandardLogicExprNode(NodeLocation location,
                                 LogicExprNode leftLogicExpr,
                                 LogicExprNode rightLogicExpr,
                                 OperationType operationType) {
        super(location);
        this.leftLogicExpr = leftLogicExpr;
        this.leftLogicExpr.setParent(this);
        this.operationType = operationType;
        this.rightLogicExpr = rightLogicExpr;
        this.rightLogicExpr.setParent(this);
        this.children.add(leftLogicExpr);
        this.children.add(rightLogicExpr);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitStandardLogicExpr(this, context);
    }

}
