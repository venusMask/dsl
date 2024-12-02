package org.venus.dsl.visitor;

import org.venus.dsl.data.RecordData;

public interface BaseVisitor {

    Object visit(RecordData recordData);

}
