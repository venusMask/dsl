package org.venus.dsl.business.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 1. 检查项目类型 = ct 且 查项目类型存在状态 = 确定;
 */
@Data
public class Rule {

    private String ruleID;

    private final List<Expression> expressions = new ArrayList<>();

}
