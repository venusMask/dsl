package org.venus.dsl.parse.node;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.parse.node.output.OutputExprNode;
import org.venus.dsl.visitor.BaseVisitor;

import java.util.List;

@Getter
@Builder
public class AssertionNode extends Node {

    private List<MatchNode> matches;

    private List<OutputExprNode> otherOutputs;

    public AssertionNode(List<MatchNode> matches,
                         List<OutputExprNode> otherOutputs) {
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

}
