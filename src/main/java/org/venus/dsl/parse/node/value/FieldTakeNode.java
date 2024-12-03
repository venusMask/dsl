package org.venus.dsl.parse.node.value;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.parse.node.type.ValueType;

@Getter
@Builder
public class FieldTakeNode extends ValueTakeNode {

    private String fieldName;

    private ValueType valueType;

}
