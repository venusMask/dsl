package org.venus.dsl.sql.parse.node.logic;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.sql.parse.node.type.OperationType;

@Getter
@Builder
public class ExcludeLogicExprNode extends LogicExprNode {

    private final OperationType operationType = OperationType.NOT;

    private LogicExprNode logicExpr;

    public ExcludeLogicExprNode(LogicExprNode logicExpr) {
        this.logicExpr = logicExpr;
        this.logicExpr.setParent(this);
        this.children.add(logicExpr);
    }

}
