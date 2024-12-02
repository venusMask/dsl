package org.venus.dsl.sql.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.sql.data.RecordData;
import org.venus.dsl.sql.analyze.Analyze;
import org.venus.dsl.sql.parse.node.DictMappingNode;
import org.venus.dsl.sql.parse.node.RuleLogicNode;
import org.venus.dsl.sql.parse.node.type.OperationType;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class RuleLogicVisitor implements BaseVisitor {

    private final RuleLogicNode node;

    private final Analyze analyze;

    @Override
    public Object visit(RecordData recordData) {
        ValueTakeVisitor visitor = new ValueTakeVisitor(node.getValueTake(), analyze);
        Object fieldValue = visitor.visit(recordData);
        if(Objects.nonNull(node.getDictMappings())) {
            List<DictMappingNode> dictMappingNodes = node.getDictMappings();
            for (DictMappingNode dictMappingNode : dictMappingNodes) {
                fieldValue = new DictMappingVisitor(
                        dictMappingNode,
                        analyze,
                        (String) fieldValue).visit(recordData);
            }
        }
        OperationType operationType = node.getOperationType();
        List<String> rightValues = node.getRightValues();
        switch (operationType) {
            case EQUAL:
                return Objects.equals(fieldValue, rightValues.get(0));
            case NotEqual:
                return !Objects.equals(fieldValue, rightValues.get(0));
            case IN:
                for (String rightValue : rightValues) {
                    if(Objects.equals(rightValue, fieldValue)) {
                        return true;
                    }
                }
                return false;
            default:
                throw new IllegalStateException("Unsupported operation type: " + operationType);
        }
    }

}
