package org.venus.dsl.business.pojo;

public interface Expression {

    void setOperator(String operator);

    String getOperator();

    void setField(String field);

    void setValue(String value);

}
