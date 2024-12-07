package org.venus.dsl.parse.node.logic;

import lombok.Getter;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

@Getter
public class ExcludeLogicExprNode extends LogicExprNode {

    private final OperationType operationType = OperationType.NOT;

    private final LogicExprNode logicExpr;

    public ExcludeLogicExprNode(NodeLocation location,
                                LogicExprNode logicExpr) {
        super(location);
        this.logicExpr = logicExpr;
        this.logicExpr.setParent(this);
        this.children.add(logicExpr);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitExcludeLogicExpr(this, context);
    }

}
