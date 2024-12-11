package org.venus.dsl.parse.node;

import lombok.Getter;
import org.venus.dsl.parse.node.logic.LogicExprNode;
import org.venus.dsl.parse.node.output.OutputExprNode;
import org.venus.dsl.visitor.AstVisitor;

@Getter
public class MatchNode extends Node {

    private final LogicExprNode logicExpr;

    private final OutputExprNode outputExpr;

    public MatchNode(NodeLocation location,
                     LogicExprNode logicExpr,
                     OutputExprNode outputExpr) {
        super(location);
        this.logicExpr = logicExpr;
        this.logicExpr.setParent(this);
        this.outputExpr = outputExpr;
        this.outputExpr.setParent(this);
        this.children.add(logicExpr);
        this.children.add(outputExpr);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitMatch(this, context);
    }



}
