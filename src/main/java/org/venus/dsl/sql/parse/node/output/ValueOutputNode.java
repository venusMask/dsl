package org.venus.dsl.sql.parse.node.output;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ValueOutputNode extends OutputExprNode {

    private String outputValue;

}
