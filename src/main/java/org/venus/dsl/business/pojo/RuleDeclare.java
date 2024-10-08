package org.venus.dsl.business.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleDeclare {

    private String ruleID;

    private String ruleNameCn;

    private String ruleNameEn;

    private String comment;

}
