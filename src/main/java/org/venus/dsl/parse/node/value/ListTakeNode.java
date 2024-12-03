package org.venus.dsl.parse.node.value;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.parse.node.type.ValueType;

import java.util.List;

@Getter
@Builder
public class ListTakeNode extends ValueTakeNode {

    private List<String> values;

    private ValueType valueType;

}
