package org.venus.dsl.parse.node.output;

import lombok.Getter;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

@Getter
public class NestedOutputNode extends OutputExprNode {

    private final OutputExprNode child;

    public NestedOutputNode(NodeLocation location,
                            OutputExprNode child) {
        super(location);
        this.child = child;
        this.child.setParent(this);
        this.children.add(child);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitNestedOutput(this, context);
    }
}
