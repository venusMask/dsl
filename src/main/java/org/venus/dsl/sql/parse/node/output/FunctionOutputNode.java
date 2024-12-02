package org.venus.dsl.sql.parse.node.output;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FunctionOutputNode extends OutputExprNode {

    private String functionName;

    private List<OutputExprNode> params;

    public FunctionOutputNode(String functionName,
                              List<OutputExprNode> params) {
        this.functionName = functionName;
        this.params = params;
        this.params.forEach(output -> {
            output.setParent(this);
            this.children.add(output);
        });
    }
}
