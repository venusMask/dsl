package org.venus.dsl.parse.node.output;

import lombok.Getter;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

@Getter
public class StandardOutputNode extends OutputExprNode {

    private final OutputExprNode leftOutputExpr;

    private final OperationType operationType;

    private final OutputExprNode rightOutputExpr;

    public StandardOutputNode(NodeLocation location,
                              OutputExprNode leftOutputExpr,
                              OutputExprNode rightOutputExpr,
                              OperationType operationType) {
        super(location);
        this.rightOutputExpr = rightOutputExpr;
        this.rightOutputExpr.setParent(this);
        this.operationType = operationType;
        this.leftOutputExpr = leftOutputExpr;
        this.leftOutputExpr.setParent(this);
        this.children.add(leftOutputExpr);
        this.children.add(rightOutputExpr);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitStandardOutput(this, context);
    }
}
