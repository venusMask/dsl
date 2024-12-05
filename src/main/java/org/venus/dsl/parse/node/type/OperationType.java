package org.venus.dsl.parse.node.type;

import lombok.Getter;

@Getter
public enum OperationType {

    EQUAL(0, "="),

    NotEqual(1, "!="),

    IN(2, "IN"),

    AND(3, "AND"),

    OR(4, "OR"),

    NOT(5, "NOT"),

    LeftBracket(6, "("),

    RightBracket(7, ")"),

    ADD(8, "ADD"),

    SUBTRACT(9, "SUBTRACT"),

    MULTIPLY(10, "MULTIPLY"),

    DIVIDE(11, "DIVIDE"),

    CONTAINS(12, "CONTAINS"),

    GE(12, "GE"),

    GT(13, "GT"),

    NotContains(14, "NOT_CONTAINS"),

    LE(15, "LE"),

    LT(16, "LT"),
    ;

    private final int code;

    private final String type;

    OperationType(int code, String type) {
        this.code = code;
        this.type = type;
    }

}
