package org.venus.dsl.parse.node.output;

import lombok.Getter;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

@Getter
public class ValueOutputNode extends OutputExprNode {

    private final String outputValue;

    public ValueOutputNode(NodeLocation location,
                           String outputValue) {
        super(location);
        this.outputValue = outputValue;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitValueOutput(this, context);
    }
}
