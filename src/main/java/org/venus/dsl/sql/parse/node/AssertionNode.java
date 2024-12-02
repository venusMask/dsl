package org.venus.dsl.sql.parse.node;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.sql.parse.node.output.OutputExprNode;

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
