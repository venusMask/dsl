package org.venus.dsl.sql.parse.node.output;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FunctionOutputNode extends OutputExprNode {

    private String functionName;

    private List<OutputExprNode> polyExprNode;

    public FunctionOutputNode(String functionName,
                              List<OutputExprNode> polyExprNode) {
        this.functionName = functionName;
        this.polyExprNode = polyExprNode;
        this.children.addAll(polyExprNode);
    }
}
