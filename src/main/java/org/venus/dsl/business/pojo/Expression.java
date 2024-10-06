package org.venus.dsl.business.pojo;

import lombok.Data;

@Data
public class Expression {

    private String field;

    private String value;

    private String operator;

}
