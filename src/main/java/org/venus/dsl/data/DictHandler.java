package org.venus.dsl.data;

/**
 * 对字段进行字典映射
 */
public interface DictHandler {

    /**
     *
     * @param dictName      需要进行的字典名称
     * @param fieldName     字段名称
     * @param fieldValue    字段值
     * @return              返回值, 如果没有返回NULL
     */
    Object mapping(String dictName, String fieldName, String fieldValue);

}
