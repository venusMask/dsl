package org.venus.dsl.parse.node.value;

import lombok.Getter;
import org.venus.dsl.parse.node.type.ValueType;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

@Getter
public class DirectTakeNode extends ValueTakeNode {

    private final String directValue;

    private final ValueType valueType;

    public DirectTakeNode(NodeLocation location,
                          String directValue,
                          ValueType valueType) {
        super(location);
        this.directValue = directValue;
        this.valueType = valueType;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitDirectTake(this, context);
    }
}
