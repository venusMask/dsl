package org.venus.dsl.parse.node;

import lombok.Getter;
import lombok.Setter;
import org.venus.dsl.visitor.AstVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有的语法节点
 */
public abstract class Node {

    @Getter
    @Setter
    private Node parent;

    protected final NodeLocation location;

    protected List<Node> children = new ArrayList<>();

    protected Node(NodeLocation location) {
        this.location = location;
    }

    public <R, C> R accept(AstVisitor<R, C> visitor, C context)
    {
        return visitor.visitNode(this, context);
    }

    public List<? extends Node> getChildren() {
        return children;
    }
}
