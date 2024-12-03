package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.data.RecordData;
import org.venus.dsl.parse.node.DictMappingNode;
import org.venus.dsl.parse.node.RuleLogicNode;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.parse.node.value.ValueTakeNode;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class RuleLogicVisitor implements BaseVisitor {

    private final RuleLogicNode node;

    private final Analyze analyze;

    private Object getValueTakeObj(ValueTakeNode valueTakeNode, RecordData recordData) {
        ValueTakeVisitor visitor = new ValueTakeVisitor(valueTakeNode, analyze);
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
        return fieldValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visit(RecordData recordData) {
        Object lhsObj = getValueTakeObj(node.getLhs(), recordData);
        Object rhsObj = getValueTakeObj(node.getRhs(), recordData);
        OperationType operationType = node.getOperationType();
        if (operationType == OperationType.EQUAL) {
            return Objects.equals(lhsObj, rhsObj);
        } else if (operationType == OperationType.NotEqual) {
            return !Objects.equals(lhsObj, rhsObj);
        } else if (operationType == OperationType.IN) {
            String lhsStr = lhsObj.toString();
            for (String rightValue : (List<String>) rhsObj) {
                if(Objects.equals(lhsStr, rightValue)) {
                    return true;
                }
            }
            return false;
        } else if (operationType == OperationType.CONTAINS) {
            String rhsStr = rhsObj.toString();
            for (String leftValue : (List<String>) lhsObj) {
                if(Objects.equals(leftValue, rhsStr)) {
                    return true;
                }
            }
            return false;
        } else if (operationType == OperationType.GT) {
            String ls = lhsObj.toString();
            String rs = rhsObj.toString();
            return ls.compareTo(rs) > 0;
        } else if (operationType == OperationType.GE) {
            String ls = lhsObj.toString();
            String rs = rhsObj.toString();
            return ls.compareTo(rs) >= 0;
        }
        throw new IllegalStateException("Unsupported operation type: " + operationType);
    }

}
