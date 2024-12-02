package org.venus.dsl.sql.analyze;

import lombok.AllArgsConstructor;
import org.venus.dsl.sql.RecordData;
import org.venus.dsl.sql.parse.node.ValueTakeNode;
import org.venus.dsl.sql.parse.node.type.ValueType;

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
