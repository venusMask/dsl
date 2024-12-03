package org.venus.dsl.parse.node.value;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.parse.node.type.ValueType;

@Getter
@Builder
public class RuleTakeNode extends ValueTakeNode {

    private String ruleID;

    private ValueType valueType;

}
