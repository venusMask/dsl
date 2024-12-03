package org.venus.dsl.parse.node;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.parse.node.value.ValueTakeNode;

import java.util.List;

@Getter
@Builder
public class RuleLogicNode extends Node {

    private ValueTakeNode lhs;

    private List<DictMappingNode> dictMappings;

    private OperationType operationType;

    private ValueTakeNode rhs;

    public RuleLogicNode(ValueTakeNode lhs,
                         List<DictMappingNode> dictMappings,
                         OperationType operationType,
                         ValueTakeNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.lhs.setParent(this);
        this.rhs.setParent(this);
        this.dictMappings = dictMappings;
        this.operationType = operationType;
        this.children.add(lhs);
        this.children.add(rhs);
        if(dictMappings != null) {
            for (DictMappingNode dictMappingNode : dictMappings) {
                dictMappingNode.setParent(this);
                this.children.add(dictMappingNode);
            }
        }
    }
}
