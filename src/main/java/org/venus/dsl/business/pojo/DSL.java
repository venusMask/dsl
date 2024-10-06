package org.venus.dsl.business.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局的DSL对象属性
 */
@Data
public class DSL {

    /**
     * 最外层的全局规则声明
     */
    private RuleDeclare topRuleDeclare;

    /**
     *
     */
    private List<RuleGroup> logicCells = new ArrayList<>();

}
