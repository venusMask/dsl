package org.venus.dsl.sql.parse.node.output;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NestedOutputNode extends OutputExprNode {

    private OutputExprNode child;

    public NestedOutputNode(OutputExprNode child) {
        this.child = child;
        this.child.setParent(this);
        this.children.add(child);
    }
}
