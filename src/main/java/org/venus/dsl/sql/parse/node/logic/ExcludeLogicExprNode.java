package org.venus.dsl.sql.parse.node.logic;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.sql.parse.node.type.OperationType;

@Getter
@Builder
public class ExcludeLogicExprNode extends LogicExprNode {

    private final OperationType operationType = OperationType.NOT;

    private LogicExprNode logicExprNode;

    public ExcludeLogicExprNode(LogicExprNode logicExprNode) {
        this.logicExprNode = logicExprNode;
        this.children.add(logicExprNode);
    }
}
