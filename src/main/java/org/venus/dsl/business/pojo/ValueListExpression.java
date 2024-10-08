package org.venus.dsl.business.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class ValueListExpression implements Expression {

    private final List<String> values = new ArrayList<>();

    @Setter
    private String field;

    @Setter
    private String operator;

    @Override
    public void setValue(String value) {
        values.add(value);
    }

}
