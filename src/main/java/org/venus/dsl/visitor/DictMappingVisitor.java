package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.data.RecordData;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.parse.node.DictMappingNode;

@AllArgsConstructor
public class DictMappingVisitor implements BaseVisitor {

    private final DictMappingNode node;

    private final Analyze analyze;

    private final String prevString;

    @Override
    public Object visit(RecordData recordData) {
        String dictName = node.getDictName();
        // 从数据库中查数据
        return prevString;
    }
}
