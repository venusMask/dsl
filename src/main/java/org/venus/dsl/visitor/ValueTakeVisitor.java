package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.data.RecordData;
import org.venus.dsl.parse.node.value.DirectTakeNode;
import org.venus.dsl.parse.node.value.FieldTakeNode;
import org.venus.dsl.parse.node.value.ListTakeNode;
import org.venus.dsl.parse.node.value.ValueTakeNode;

/**
 * 实现每种类型具体的取值逻辑
 */
@AllArgsConstructor
public class ValueTakeVisitor implements BaseVisitor {

    private final ValueTakeNode node;

    private final Analyze analyze;

    private final boolean singleValue;

    @Override
    public Object visit(RecordData recordData) {
        if(node instanceof DirectTakeNode) {
            DirectTakeNode tmpNode = (DirectTakeNode) node;
            return tmpNode.getDirectValue();
        } else if (node instanceof FieldTakeNode) {
            FieldTakeNode tmpNode = (FieldTakeNode) node;
            String fieldName = tmpNode.getFieldName();
            if(singleValue) {
                return recordData.getValue(fieldName);
            } else {
                return recordData.getValues(fieldName);
            }
        } else if (node instanceof ListTakeNode) {
            ListTakeNode tmpNode = (ListTakeNode) node;
            return tmpNode.getValues();
        }
        throw new RuntimeException("Unsupported node type: " + node.getClass().getName());
    }

}
