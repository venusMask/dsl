package org.venus.dsl.sql.parse.node.logic;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NestedLogicExprNode extends LogicExprNode {

    private LogicExprNode child;

    public NestedLogicExprNode(LogicExprNode child) {
        this.child = child;
        this.child.setParent(this);
        this.children.add(child);
    }

}
