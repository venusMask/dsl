package org.venus.dsl.sql.parse.node;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RuleDeclareNode extends Node {

    private String ruleCode;

    private String ruleName;
}
