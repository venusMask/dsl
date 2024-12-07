package org.venus.dsl.parse.node.value;

import lombok.Getter;
import org.venus.dsl.parse.node.type.ValueType;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

import java.util.List;

@Getter
public class ListTakeNode extends ValueTakeNode {

    private final List<String> values;

    private final ValueType valueType;

    public ListTakeNode(NodeLocation location,
                        List<String> values,
                        ValueType valueType) {
        super(location);
        this.values = values;
        this.valueType = valueType;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitListTake(this, context);
    }
}
