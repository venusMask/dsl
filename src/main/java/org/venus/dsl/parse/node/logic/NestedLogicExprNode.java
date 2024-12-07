package org.venus.dsl.parse.node.logic;

import lombok.Getter;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

@Getter
public class NestedLogicExprNode extends LogicExprNode {

    private final LogicExprNode child;

    public NestedLogicExprNode(NodeLocation location,
                               LogicExprNode child) {
        super(location);
        this.child = child;
        this.child.setParent(this);
        this.children.add(child);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitNestedLogicExpr(this, context);
    }
}
