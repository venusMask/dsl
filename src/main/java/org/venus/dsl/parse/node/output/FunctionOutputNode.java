package org.venus.dsl.parse.node.output;

import lombok.Getter;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

import java.util.List;

@Getter
public class FunctionOutputNode extends OutputExprNode {

    private final String functionName;

    private final List<OutputExprNode> params;

    public FunctionOutputNode(NodeLocation location,
                              String functionName,
                              List<OutputExprNode> params) {
        super(location);
        this.functionName = functionName;
        this.params = params;
        this.params.forEach(output -> {
            output.setParent(this);
            this.children.add(output);
        });
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitFunctionOutput(this, context);
    }
}
