package org.venus.dsl.parse.node.value;

import lombok.Getter;
import org.venus.dsl.parse.node.type.ValueType;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

@Getter
public class RuleTakeNode extends ValueTakeNode {

    private final String ruleID;

    private final ValueType valueType;

    public RuleTakeNode(NodeLocation location,
                        String ruleID,
                        ValueType valueType) {
        super(location);
        this.ruleID = ruleID;
        this.valueType = valueType;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitRuleTake(this, context);
    }
}
