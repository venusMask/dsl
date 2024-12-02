package org.venus.dsl.sql.parse.node;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.sql.parse.node.type.OperationType;

import java.util.List;

@Getter
@Builder
public class RuleLogicNode extends Node {

    private ValueTakeNode valueTake;

    private List<DictMappingNode> dictMappings;

    private OperationType operationType;

    private List<String> rightValues;

    public RuleLogicNode(ValueTakeNode valueTake,
                         List<DictMappingNode> dictMappings,
                         OperationType operationType,
                         List<String> rightValues) {
        this.valueTake = valueTake;
        this.valueTake.setParent(this);
        this.dictMappings = dictMappings;
        this.operationType = operationType;
        this.rightValues = rightValues;
        this.children.add(valueTake);
        if(dictMappings != null) {
            for (DictMappingNode dictMappingNode : dictMappings) {
                dictMappingNode.setParent(this);
                this.children.add(dictMappingNode);
            }
        }
    }
}
