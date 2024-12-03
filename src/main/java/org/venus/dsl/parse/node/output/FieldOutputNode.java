package org.venus.dsl.parse.node.output;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FieldOutputNode extends OutputExprNode {

    private String fieldName;

}
