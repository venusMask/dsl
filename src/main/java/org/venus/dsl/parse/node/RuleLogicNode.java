package org.venus.dsl.parse.node;

import lombok.Getter;
import lombok.Setter;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.parse.node.value.ValueTakeNode;

import java.util.List;

@Getter
public class RuleLogicNode extends Node {

    @Setter
    private RuleLogicNode prev;

    private final ValueTakeNode lhs;

    private final ValueTakeNode rhs;

    private final OperationType operationType;

    private final List<DictMappingNode> dictMappings;

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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private ValueTakeNode lhs;
        private ValueTakeNode rhs;
        private OperationType operationType;
        private List<DictMappingNode> dictMappings;

        public Builder lhs(ValueTakeNode lhs) {
            this.lhs = lhs;
            return this;
        }

        public Builder rhs(ValueTakeNode rhs) {
            this.rhs = rhs;
            return this;
        }

        public Builder operationType(OperationType operationType) {
            this.operationType = operationType;
            return this;
        }

        public Builder dictMappings(List<DictMappingNode> dictMappings) {
            this.dictMappings = dictMappings;
            return this;
        }

        // 构建方法
        public RuleLogicNode build() {
            return new RuleLogicNode(lhs, dictMappings, operationType, rhs);
        }
    }

}
