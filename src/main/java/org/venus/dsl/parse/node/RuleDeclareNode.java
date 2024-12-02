package org.venus.dsl.parse.node;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RuleDeclareNode extends Node {

    private String ruleCode;

    private String ruleName;
}
