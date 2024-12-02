package org.venus.dsl.sql.parse.node.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ValueType {

    ID(0, "ID"),

    FIELD(1, "FIELD");

    private final int code;

    private final String type;

}
