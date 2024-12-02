package org.venus.dsl.parse.node;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.parse.node.logic.LogicExprNode;
import org.venus.dsl.parse.node.output.OutputExprNode;

@Getter
@Builder
public class MatchNode extends Node {

    private LogicExprNode logicExpr;

    private OutputExprNode outputExpr;

    public MatchNode(LogicExprNode logicExpr,
                     OutputExprNode outputExpr) {
        this.logicExpr = logicExpr;
        this.logicExpr.setParent(this);
        this.outputExpr = outputExpr;
        this.outputExpr.setParent(this);
        this.children.add(logicExpr);
        this.children.add(outputExpr);
    }

}
