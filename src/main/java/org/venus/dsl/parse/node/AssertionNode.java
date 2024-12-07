package org.venus.dsl.parse.node;

import lombok.Getter;
import org.venus.dsl.parse.node.output.OutputExprNode;
import org.venus.dsl.visitor.AstVisitor;

import java.util.List;

@Getter
public class AssertionNode extends Node {

    private final List<MatchNode> matches;

    private final List<OutputExprNode> otherOutputs;

    public AssertionNode(NodeLocation location,
                         List<MatchNode> matches,
                         List<OutputExprNode> otherOutputs) {
        super(location);
        this.matches = matches;
        this.otherOutputs = otherOutputs;
        this.matches.forEach(matchNode -> {
            matchNode.setParent(this);
            this.children.add(matchNode);
        });
        this.otherOutputs.forEach(outputExprNode -> {
            outputExprNode.setParent(this);
            this.children.add(outputExprNode);
        });
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitAssertion(this, context);
    }

}
