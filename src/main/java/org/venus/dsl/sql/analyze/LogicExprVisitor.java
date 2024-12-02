package org.venus.dsl.sql.analyze;

import lombok.AllArgsConstructor;
import org.venus.dsl.sql.RecordData;
import org.venus.dsl.sql.parse.node.RuleDefinitionNode;
import org.venus.dsl.sql.parse.node.logic.*;
import org.venus.dsl.sql.parse.node.type.OperationType;

/**
 * 分析单条规则的执行结果, 在外层控制是否要进行短路处理.
 *
 */
@AllArgsConstructor
public class LogicExprVisitor implements BaseVisitor {

    private final LogicExprNode node;

    private final Analyze analyze;

    @Override
    public Boolean visit(RecordData recordData) {
        // 直接获取表达式的结果
        if(node instanceof ValueLogicExprNode) {
            ValueLogicExprNode realNode = (ValueLogicExprNode) node;
            String ruleCode = realNode.getRuleCode();
            RuleDefinitionNode ruleDefinitionNode = analyze.getRuleDefinitionNode(ruleCode);
            return new RuleDefinitionVisitor(ruleDefinitionNode, analyze).visit(recordData);
        } else if (node instanceof ExcludeLogicExprNode) {
            ExcludeLogicExprNode tmpNode = (ExcludeLogicExprNode) node;
            BaseVisitor visitor = new LogicExprVisitor(tmpNode.getLogicExprNode(), analyze);
            Object flag = visitor.visit(recordData);
            return !(boolean) flag;
        } else if (node instanceof NestedLogicExprNode) {
            NestedLogicExprNode tmpNode = (NestedLogicExprNode) node;
            BaseVisitor visitor = new LogicExprVisitor(tmpNode.getChild(), analyze);
            Object flag = visitor.visit(recordData);
            return (boolean) flag;
        } else if (node instanceof StandardLogicExprNode) {
            StandardLogicExprNode tmpNode = (StandardLogicExprNode) node;
            Boolean leftFlag = new LogicExprVisitor(tmpNode.getLeftNode(), analyze).visit(recordData);
            OperationType operationType = tmpNode.getOperationType();
            // 根据运算符的类型可以提前结束计算
            if(operationType == OperationType.AND) {
                if(!leftFlag) {
                    return false;
                }
                return new LogicExprVisitor(tmpNode.getRightNode(), analyze).visit(recordData);
            } else if (operationType == OperationType.OR) {
                if(leftFlag) {
                    return true;
                }
                return new LogicExprVisitor(tmpNode.getRightNode(), analyze).visit(recordData);
            }
        }
        return null;
    }

}
