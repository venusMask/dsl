package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.parse.node.output.*;
import org.venus.dsl.parse.node.type.OperationType;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class OutputExprVisitor implements BaseVisitor {

    private final OutputExprNode node;

    private final Analyze analyze;

    @Override
    public Object visit(TreeNode root) {
        if(node instanceof ValueOutputNode) {
            ValueOutputNode tmpNode = (ValueOutputNode) node;
            return tmpNode.getOutputValue();
        } else if (node instanceof StandardOutputNode) {
            StandardOutputNode tmpNode = (StandardOutputNode) node;
            Object leftValue = new OutputExprVisitor(tmpNode.getLeftOutputExpr(), analyze).visit(root);
            Object rightValue = new OutputExprVisitor(tmpNode.getRightOutputExpr(), analyze).visit(root);
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
            List<OutputExprNode> polyExprNode = tmpNode.getParams();
            ArrayList<Object> param = new ArrayList<>(polyExprNode.size());
            polyExprNode.forEach(p -> {
                Object result = new OutputExprVisitor(p, analyze).visit(root);
                param.add(result);
            });
            // TODO 获取函数的执行结果
            return "function result";
        } else if (node instanceof NestedOutputNode) {
            NestedOutputNode tmpNode = (NestedOutputNode) node;
            OutputExprNode child = tmpNode.getChild();
            return new OutputExprVisitor(child, analyze).visit(root);
        } else if (node instanceof FieldOutputNode) {
            FieldOutputNode tmpNode = (FieldOutputNode) node;
            String fieldName = tmpNode.getFieldName();
            List<TreeNode> values = TreeNode.searchValues(root, fieldName);
            return values.get(0).getFieldValue();
        }
        return null;
    }
}
