package org.venus.dsl.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HashMapData implements RecordData {

    private final HashMap<String, Object> map = new HashMap<>();

    @Override
    public String getValue(String fieldName) {
        return (String) map.get(fieldName);
    }

    @Override
    public List<String> getValues(String fieldName) {
        Object values = map.get(fieldName);
        if (values instanceof List) {
            return (List<String>) values;
        } else if (values instanceof String) {
            return Collections.singletonList((String) values);
        }
        throw new RuntimeException("Unable to find value for field: " + fieldName);
    }

    public void setField(String fieldName, String fieldValue) {
        map.put(fieldName, fieldValue);
    }

}
