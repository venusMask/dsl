package org.venus.dsl.sql.analyze;

import org.venus.dsl.sql.RecordData;

public interface BaseVisitor {

    Object visit(RecordData recordData);

}
