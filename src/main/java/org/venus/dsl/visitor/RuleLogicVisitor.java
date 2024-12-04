package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.data.RecordData;
import org.venus.dsl.parse.node.DictMappingNode;
import org.venus.dsl.parse.node.RuleLogicNode;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.parse.node.value.ValueTakeNode;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class RuleLogicVisitor implements BaseVisitor {

    private final RuleLogicNode node;

    private final Analyze analyze;

    private Object getValueTakeObj(ValueTakeNode valueTakeNode,
                                   RecordData recordData,
                                   Boolean singleValue) {
        ValueTakeVisitor visitor = new ValueTakeVisitor(valueTakeNode, analyze, singleValue);
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

    private boolean contains(List<String> lhsList, List<String> rhsList) {
        for (String rhs : rhsList) {
            if(lhsList.contains(rhs)) {
                return true;
            }
        }
        return false;
    }

    private boolean notContains(List<String> lhsList, List<String> rhsList) {
        return !contains(lhsList, rhsList);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visit(RecordData recordData) {
        OperationType operationType = node.getOperationType();
        boolean leftFlag = Boolean.TRUE;
        boolean rightFlag = Boolean.TRUE;
        if(operationType == OperationType.IN) {
            rightFlag = Boolean.FALSE;
        } else if (operationType == OperationType.CONTAINS
            || operationType == OperationType.NotContains) {
            leftFlag = Boolean.FALSE;
            rightFlag = Boolean.FALSE;
        }
        Object lhsObj = getValueTakeObj(node.getLhs(), recordData, leftFlag);
        Object rhsObj = getValueTakeObj(node.getRhs(), recordData, rightFlag);
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
            if(rhsObj instanceof String) {
                return contains((List<String>) lhsObj, Collections.singletonList((String) rhsObj));
            } else if (rhsObj instanceof List) {
                return contains((List<String>) lhsObj, (List<String>) rhsObj);
            }
            String errorMsg = String.format("Unsupported operation type: %s, Because data type: %s, %s",
                    operationType,
                    lhsObj.getClass(),
                    rhsObj.getClass()
            );
            throw new IllegalStateException(errorMsg);
        } else if (operationType == OperationType.NotContains) {
            if(rhsObj instanceof String) {
                return notContains((List<String>) lhsObj, Collections.singletonList((String) rhsObj));
            } else if (rhsObj instanceof List) {
                return notContains((List<String>) lhsObj, (List<String>) rhsObj);
            }
            String errorMsg = String.format("Unsupported operation type: %s, Because data type: %s, %s",
                    operationType,
                    lhsObj.getClass(),
                    rhsObj.getClass()
            );
            throw new IllegalStateException(errorMsg);
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
