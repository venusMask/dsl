package org.venus.dsl.sql.visitor;

import org.venus.dsl.sql.data.RecordData;

public interface BaseVisitor {

    Object visit(RecordData recordData);

}
