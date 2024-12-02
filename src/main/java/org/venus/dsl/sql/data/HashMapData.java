package org.venus.dsl.sql.data;

import java.util.HashMap;

public class HashMapData implements RecordData {

    private final HashMap<String, String> map = new HashMap<>();

    @Override
    public String getField(String fieldName) {
        return map.get(fieldName);
    }

    public void setField(String fieldName, String fieldValue) {
        map.put(fieldName, fieldValue);
    }

}
