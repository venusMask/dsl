package org.venus.dsl.parse.node.logic;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ValueLogicExprNode  extends LogicExprNode {

    private String ruleCode;

}
