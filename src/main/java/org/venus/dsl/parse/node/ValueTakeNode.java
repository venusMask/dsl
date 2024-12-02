package org.venus.dsl.parse.node;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.parse.node.type.ValueType;

@Builder
@Getter
public class ValueTakeNode extends Node {

    private ValueType type;

    private String value;

}
