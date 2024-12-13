package org.venus.dsl;

import org.venus.dsl.data.DictHandler;

import java.util.HashMap;

public class MemoryDictHandler implements DictHandler {

    private final HashMap<String, HashMap<String, String>> hashMap = new HashMap();

    public MemoryDictHandler() {
        HashMap<String, String> aDict = new HashMap<>();
        aDict.put("a_1", "a_1_1");
        aDict.put("a_2", "a_2_1");
        HashMap<String, String> bDict = new HashMap<>();
        bDict.put("b_1", "a_1_1");
        bDict.put("b_2", "b_2_1");
        hashMap.put("a", aDict);
        hashMap.put("b", bDict);
    }

    @Override
    public Object mapping(String dictName, String fieldName, String fieldValue) {
        HashMap<String, String> map = hashMap.get(dictName);
        if (map != null) {
            return map.get(fieldName);
        }
        return null;
    }

}
