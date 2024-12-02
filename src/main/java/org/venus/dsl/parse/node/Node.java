package org.venus.dsl.parse.node;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {

    @Getter
    @Setter
    private Node parent;

    protected List<Node> children = new ArrayList<>();

    public List<? extends Node> getChildren() {
        return children;
    }
}
