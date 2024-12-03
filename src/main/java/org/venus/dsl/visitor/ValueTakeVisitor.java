package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.parse.node.type.ValueType;
import org.venus.dsl.data.RecordData;
import org.venus.dsl.parse.node.value.DirectTakeNode;
import org.venus.dsl.parse.node.value.FieldTakeNode;
import org.venus.dsl.parse.node.value.ListTakeNode;
import org.venus.dsl.parse.node.value.ValueTakeNode;

@AllArgsConstructor
public class ValueTakeVisitor implements BaseVisitor {

    private final ValueTakeNode node;

    private final Analyze analyze;

    @Override
    public Object visit(RecordData recordData) {
        if(node instanceof DirectTakeNode) {
            DirectTakeNode tmpNode = (DirectTakeNode) node;
            return tmpNode.getDirectValue();
        } else if (node instanceof FieldTakeNode) {
            FieldTakeNode tmpNode = (FieldTakeNode) node;
            String fieldName = tmpNode.getFieldName();
            return recordData.getField(fieldName);
        } else if (node instanceof ListTakeNode) {
            ListTakeNode tmpNode = (ListTakeNode) node;
            return tmpNode.getValues();
        }
        throw new RuntimeException("Unsupported node type: " + node.getClass().getName());
    }

}
