package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.parse.node.RuleDefinitionNode;
import org.venus.dsl.parse.node.RuleGroupNode;
import org.venus.dsl.parse.node.logic.*;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.data.RecordData;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.sql.parse.node.logic.*;

import java.util.Objects;

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
            // 根据是单结构表达式或者是多结构表达式此处需要处理的方式不同
             Boolean isSingleRule = analyze.getIsSingleRule();
            if(isSingleRule) {
                RuleDefinitionNode ruleDefinitionNode = analyze.getRuleDefinitionNode(ruleCode);
                return new RuleDefinitionVisitor(ruleDefinitionNode, analyze).visit(recordData);
            } else {
                RuleGroupNode ruleGroup = analyze.getRuleGroup(ruleCode);
                 analyze.setIsSingleRule(true);
                Object ruleGroupValue = new RuleGroupVisitor(ruleGroup, analyze).visit(recordData);
                 analyze.setIsSingleRule(false);
                return Objects.equals(ruleGroupValue, "是");
            }
        } else if (node instanceof ExcludeLogicExprNode) {
            ExcludeLogicExprNode tmpNode = (ExcludeLogicExprNode) node;
            BaseVisitor visitor = new LogicExprVisitor(tmpNode.getLogicExpr(), analyze);
            Object flag = visitor.visit(recordData);
            return !(boolean) flag;
        } else if (node instanceof NestedLogicExprNode) {
            NestedLogicExprNode tmpNode = (NestedLogicExprNode) node;
            BaseVisitor visitor = new LogicExprVisitor(tmpNode.getChild(), analyze);
            Object flag = visitor.visit(recordData);
            return (boolean) flag;
        } else if (node instanceof StandardLogicExprNode) {
            StandardLogicExprNode tmpNode = (StandardLogicExprNode) node;
            Boolean leftFlag = new LogicExprVisitor(tmpNode.getLeftLogicExpr(), analyze).visit(recordData);
            OperationType operationType = tmpNode.getOperationType();
            // 根据运算符的类型可以提前结束计算
            if(operationType == OperationType.AND) {
                if(!leftFlag) {
                    return false;
                }
                return new LogicExprVisitor(tmpNode.getRightLogicExpr(), analyze).visit(recordData);
            } else if (operationType == OperationType.OR) {
                if(leftFlag) {
                    return true;
                }
                return new LogicExprVisitor(tmpNode.getRightLogicExpr(), analyze).visit(recordData);
            }
        }
        return null;
    }

}
