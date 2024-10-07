package org.venus.dsl.business.pojo;

import lombok.Data;

/**
 * TODO: 此处根据operator的不同field, value应该使用不同的数据结构,例如: 当operator=in的时候, value应该是一个集合
 * 可以考虑Expression抽象成一个接口, 不同的操作符使用不同的实现类
 */
@Data
public class Expression {

    private String field;

    private String value;

    private String operator;

}
