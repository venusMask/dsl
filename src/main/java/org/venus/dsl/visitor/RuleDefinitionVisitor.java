package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.parse.node.RuleDefinitionNode;
import org.venus.dsl.parse.node.RuleLogicNode;
import org.venus.dsl.data.RecordData;

import java.util.List;

@AllArgsConstructor
public class RuleDefinitionVisitor implements BaseVisitor {

    private final RuleDefinitionNode node;

    private final Analyze analyze;

    @Override
    public Boolean visit(RecordData recordData) {
        boolean flag = true;
        List<RuleLogicNode> operations = node.getOperations();
        for (RuleLogicNode operation : operations) {
            BaseVisitor visitor = new RuleLogicVisitor(operation, analyze);
            Object result = visitor.visit(recordData);
            if (result instanceof Boolean) {
                Boolean flagResult = (Boolean) result;
                flag = flagResult && flag;
            }
        }
        return flag;
    }
}
