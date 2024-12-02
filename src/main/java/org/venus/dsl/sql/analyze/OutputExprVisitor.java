package org.venus.dsl.sql.analyze;

import lombok.AllArgsConstructor;
import org.venus.dsl.sql.RecordData;
import org.venus.dsl.sql.parse.node.output.*;
import org.venus.dsl.sql.parse.node.type.OperationType;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class OutputExprVisitor implements BaseVisitor {

    private final OutputExprNode node;

    private final Analyze analyze;

    @Override
    public Object visit(RecordData recordData) {
        if(node instanceof ValueOutputNode) {
            ValueOutputNode tmpNode = (ValueOutputNode) node;
            return tmpNode.getOutputValue();
        } else if (node instanceof StandardOutputNode) {
            StandardOutputNode tmpNode = (StandardOutputNode) node;
            Object leftValue = new OutputExprVisitor(tmpNode.getLeftValue(), analyze).visit(recordData);
            Object rightValue = new OutputExprVisitor(tmpNode.getRightValue(), analyze).visit(recordData);
            OperationType operationType = tmpNode.getOperationType();
            if (operationType == OperationType.ADD) {
                return (Long) leftValue + (Long) rightValue;
            } else if (operationType == OperationType.SUBTRACT) {
                return (Long) leftValue - (Long) rightValue;
            } else if (operationType == OperationType.MULTIPLY) {
                return (Long) leftValue * (Long) rightValue;
            } else if (operationType == OperationType.DIVIDE) {
                return (Long) leftValue / (Long) rightValue;
            }
        } else if (node instanceof FunctionOutputNode) {
            FunctionOutputNode tmpNode = (FunctionOutputNode) node;
            String functionName = tmpNode.getFunctionName();
            List<OutputExprNode> polyExprNode = tmpNode.getPolyExprNode();
            ArrayList<Object> param = new ArrayList<>(polyExprNode.size());
            polyExprNode.forEach(p -> {
                Object result = new OutputExprVisitor(p, analyze).visit(recordData);
                param.add(result);
            });
            // TODO 获取函数的执行结果
            return "function result";
        } else if (node instanceof NestedOutputNode) {
            NestedOutputNode tmpNode = (NestedOutputNode) node;
            OutputExprNode child = tmpNode.getChild();
            return new OutputExprVisitor(child, analyze).visit(recordData);
        }
        return null;
    }
}
