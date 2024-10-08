package org.venus.dsl.business.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SimpleExpression implements Expression {

    private String field;

    private String value;

    private String operator;


    @Override
    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public void setField(String field) {
        this.field = field;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

}
