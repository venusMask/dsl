package org.venus.dsl.parse.node.output;

import lombok.Getter;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

@Getter
public class FieldOutputNode extends OutputExprNode {

    private final String fieldName;

    public FieldOutputNode(NodeLocation location,
                           String fieldName) {
        super(location);
        this.fieldName = fieldName;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitFieldOutput(this, context);
    }
}
