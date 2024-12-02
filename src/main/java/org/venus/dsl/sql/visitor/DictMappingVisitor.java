package org.venus.dsl.sql.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.sql.data.RecordData;
import org.venus.dsl.sql.analyze.Analyze;
import org.venus.dsl.sql.parse.node.DictMappingNode;

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
