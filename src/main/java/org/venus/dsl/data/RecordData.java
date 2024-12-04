package org.venus.dsl.data;

import java.util.List;

public interface RecordData {

    String getValue(String fieldName);

    List<String> getValues(String fieldName);

}
