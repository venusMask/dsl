package org.venus.dsl.sql.parse.node;

import lombok.Builder;
import lombok.Getter;
import org.venus.dsl.sql.parse.node.output.OutputExprNode;

import java.util.List;

@Getter
@Builder
public class AssertionNode extends Node {

    private List<MatchNode> matchNodes;

    private List<OutputExprNode> otherOutput;

    public AssertionNode(List<MatchNode> matchNodes,
                         List<OutputExprNode> otherOutput) {
        this.matchNodes = matchNodes;
        this.otherOutput = otherOutput;
        this.children.addAll(matchNodes);
        this.children.addAll(otherOutput);
    }
}
