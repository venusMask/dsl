package org.venus.dsl.business.pojo;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Match {

    public String matchType;

    public String result;

    public String expr;

}
