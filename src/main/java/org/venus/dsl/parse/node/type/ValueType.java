package org.venus.dsl.parse.node.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ValueType {

    ID(0, "ID"),

    FIELD(1, "FIELD"),

    DIRECT(2, "DIRECT"),

    LIST(3, "LIST"),
    ;

    private final int code;

    private final String type;

}
