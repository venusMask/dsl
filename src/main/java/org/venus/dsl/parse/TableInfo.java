package org.venus.dsl.parse;

import lombok.Getter;
import org.venus.dsl.parse.node.Node;

@Getter
public class TableInfo {

    private final Node node;

    private final String tableName;

    public TableInfo(Node node, String tableName) {
        this.node = node;
        this.tableName = tableName;
    }

}
