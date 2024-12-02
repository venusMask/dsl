package org.venus.dsl.sql.parse.node;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.sql.parse.node.logic.LogicExprNode;
import org.venus.dsl.sql.parse.node.output.OutputExprNode;

@Getter
@Builder
public class MatchNode extends Node {

    private LogicExprNode logicExprNode;

    private OutputExprNode polyExprNode;

    public MatchNode(LogicExprNode logicExprNode,
                     OutputExprNode polyExprNode) {
        this.logicExprNode = logicExprNode;
        this.polyExprNode = polyExprNode;
        this.children.add(logicExprNode);
        this.children.add(polyExprNode);
    }
}
