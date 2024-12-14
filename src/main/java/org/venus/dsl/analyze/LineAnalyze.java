package org.venus.dsl.analyze;

import org.venus.dsl.data.DictHandler;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.parse.TableInfo;
import org.venus.dsl.parse.node.Node;
import org.venus.dsl.visitor.ExecutorVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理整行数据
 */
public class LineAnalyze {

    /**
     * key: table name
     * value:
     *      key: field name
     *      value: filed node
     */
    private final Map<String, Map<String, TableInfo>> fieldNodes;

    /**
     * DWD层传递过来的所有的数据
     */
    private final Map<String, List<TreeNode>> dataRoots;

    private final DictHandler dictHandler;

    public LineAnalyze(Map<String, Map<String, TableInfo>> fieldNodes,
                       Map<String, List<TreeNode>> dataRoots,
                       DictHandler dictHandler) {
        this.fieldNodes = fieldNodes;
        this.dataRoots = dataRoots;
        this.dictHandler = dictHandler;
    }

    public Map<String, Map<String, List<Object>>> analyze() {
        Map<String, Map<String, List<Object>>> result = new HashMap<>();
        for (Map.Entry<String, Map<String, TableInfo>> entry : fieldNodes.entrySet()) {
            // 下游表名
            String tableName = entry.getKey();
            // key: 字段, value: 结果值
            // List<Map<String, Object>> lineData = new ArrayList<>();
            Map<String, List<Object>> fieldsResult = new HashMap<>();
            for (Map.Entry<String, TableInfo> field : entry.getValue().entrySet()) {
                // 下游字段名称
                String fieldName = field.getKey();
                TableInfo tableInfo = field.getValue();
                String fromTableName = tableInfo.getTableName();
                // 字段生产规则
                Node ruleNode = tableInfo.getNode();
                List<TreeNode> multiLines = dataRoots.get(fromTableName);
                // 存储一个字段产生的所有的结果
                ArrayList<Object> fieldResult = new ArrayList<>();
                for (int idx = 0; idx < multiLines.size(); idx++) {
                    TreeNode root = multiLines.get(idx);
                    Analyze analyze = new Analyze(root);
                    ExecutorVisitor executorVisitor = new ExecutorVisitor(analyze, dictHandler);
                    Object value = executorVisitor.process(ruleNode);
                    fieldResult.add(value);
                }
                fieldsResult.put(fieldName, fieldResult);
            }
            result.put(tableName, fieldsResult);
        }
        return result;
    }

}
