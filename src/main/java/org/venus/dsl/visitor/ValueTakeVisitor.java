package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.parse.node.type.ValueType;
import org.venus.dsl.data.RecordData;
import org.venus.dsl.parse.node.ValueTakeNode;

@AllArgsConstructor
public class ValueTakeVisitor implements BaseVisitor {

    private final ValueTakeNode node;

    private final Analyze analyze;

    @Override
    public Object visit(RecordData recordData) {
        ValueType type = node.getType();
        String value = node.getValue();
        // 从数据集中取值
        if(type == ValueType.FIELD) {
            return recordData.getField(value);
        }
        return null;
    }

}
