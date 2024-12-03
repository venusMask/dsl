package org.venus.dsl.parse.node.value;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.parse.node.type.ValueType;

@Getter
@Builder
public class DirectTakeNode extends ValueTakeNode {

    private String directValue;

    private ValueType valueType;

}
