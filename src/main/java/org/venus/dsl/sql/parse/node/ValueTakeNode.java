package org.venus.dsl.sql.parse.node;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.sql.parse.node.type.ValueType;

@Builder
@Getter
public class ValueTakeNode extends Node {

    private ValueType type;

    private String value;

}
