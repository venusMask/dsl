package org.venus.dsl.parse.node;

import lombok.Getter;
import lombok.Setter;
import org.venus.dsl.parse.node.value.FieldTakeNode;
import org.venus.dsl.visitor.AstVisitor;

@Getter
public class DictMappingNode extends Node {

    @Setter
    private FieldTakeNode field;

    private final String dictName;

    public DictMappingNode(NodeLocation location,
                           String dictName) {
        super(location);
        this.dictName = dictName;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitDictMapping(this, context);
    }
}
