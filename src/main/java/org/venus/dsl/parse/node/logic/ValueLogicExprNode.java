package org.venus.dsl.parse.node.logic;

import lombok.Getter;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

@Getter
public class ValueLogicExprNode  extends LogicExprNode {

    private final String ruleCode;

    public ValueLogicExprNode(NodeLocation location,
                              String ruleCode) {
        super(location);
        this.ruleCode = ruleCode;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitValueLogicExpr(this, context);
    }

    @Override
    public String toString() {
        return "ValueLogicExprNode{" +
                "ruleCode='" + ruleCode + '\'' +
                '}';
    }
}
