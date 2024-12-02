package org.venus.dsl.sql.parse.node;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {

    protected List<Node> children = new ArrayList<>();

    public List<? extends Node> getChildren() {
        return children;
    }

}
