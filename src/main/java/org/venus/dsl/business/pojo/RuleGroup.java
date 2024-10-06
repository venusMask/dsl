package org.venus.dsl.business.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 每一个单独的规则组
 * eg:
 * r1 r1_cn r1_en
 * 1. 检查项目类型 = ct 且 查项目类型存在状态 = 确定;
 * 2. 检查项目类型 = ct 且 查项目类型存在状态 = 确定;
 * 3. 检查项目类型 = ct 且 查项目类型存在状态 = 确定;
 */
@Data
public class RuleGroup {

    /**
     * 规则组定义
     */
    private RuleDeclare ruleDeclare;

    /**
     *
     */
    private final List<Rule> rules = new ArrayList<>();

    private final List<Match> matches = new ArrayList<>();

}
