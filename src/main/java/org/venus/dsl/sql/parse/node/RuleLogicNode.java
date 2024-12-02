package org.venus.dsl.sql.parse.node;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.sql.parse.node.type.OperationType;

import java.util.List;

@Getter
@Builder
public class RuleLogicNode extends Node {

    private ValueTakeNode valueTakeNode;

    private List<DictMappingNode> dictMappingNodes;

    private OperationType operationType;

    private List<String> rightValues;

    public RuleLogicNode(ValueTakeNode valueTakeNode,
                         List<DictMappingNode> dictMappingNodes,
                         OperationType operationType,
                         List<String> rightValues) {
        this.valueTakeNode = valueTakeNode;
        this.dictMappingNodes = dictMappingNodes;
        this.operationType = operationType;
        this.rightValues = rightValues;
        this.children.add(valueTakeNode);
        if(dictMappingNodes != null) {
            this.children.addAll(dictMappingNodes);
        }
    }
}
