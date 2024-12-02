package org.venus.dsl.parse.node.output;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ValueOutputNode extends OutputExprNode {

    private String outputValue;

}
