package org.venus.dsl.parse.node;

import lombok.Getter;
import lombok.Setter;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.parse.node.value.ValueTakeNode;
import org.venus.dsl.visitor.AstVisitor;

import java.util.List;

@Getter
public class RuleLogicNode extends Node {

    @Setter
    private RuleLogicNode prev;

    private final ValueTakeNode lhs;

    private final ValueTakeNode rhs;

    private final OperationType operationType;

    private final List<DictMappingNode> dictMappings;

    public RuleLogicNode(NodeLocation location,
                         ValueTakeNode lhs,
                         ValueTakeNode rhs,
                         List<DictMappingNode> dictMappings,
                         OperationType operationType) {
        super(location);
        this.lhs = lhs;
        this.rhs = rhs;
        this.lhs.setParent(this);
        this.rhs.setParent(this);
        this.dictMappings = dictMappings;
        this.operationType = operationType;
        this.children.add(lhs);
        this.children.add(rhs);
        if (dictMappings != null) {
            for (DictMappingNode dictMappingNode : dictMappings) {
                dictMappingNode.setParent(this);
                this.children.add(dictMappingNode);
            }
        }
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitRuleLogic(this, context);
    }
}
