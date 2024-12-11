package org.venus.dsl.parse.node.value;

import lombok.Getter;
import org.venus.dsl.parse.node.type.ValueType;
import org.venus.dsl.visitor.AstVisitor;
import org.venus.dsl.parse.node.NodeLocation;

@Getter
public class FieldTakeNode extends ValueTakeNode {

    private final String tableName;

    private final String fieldName;

    private final ValueType valueType;

    public FieldTakeNode(NodeLocation location,
                         String fieldName,
                         ValueType valueType) {
        super(location);
        String[] fields = fieldName.trim().split("\\.");
        if(fields.length != 2) {
            throw new IllegalArgumentException("Invalid field name: " + fieldName + ". please specify a table name.");
        }
        this.tableName = fields[0];
        this.fieldName = fields[1];
        this.valueType = valueType;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitFieldTake(this, context);
    }
}
