package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.parse.node.value.DirectTakeNode;
import org.venus.dsl.parse.node.value.FieldTakeNode;
import org.venus.dsl.parse.node.value.ListTakeNode;
import org.venus.dsl.parse.node.value.ValueTakeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 实现每种类型具体的取值逻辑
 * <p>
 * // TODO 重新实现具有递进字段的ruleLogic的取值逻辑
 */
@AllArgsConstructor
public class ValueTakeVisitor implements BaseVisitor {

    private final Analyze analyze;

    private final ValueTakeNode node;

    @Override
    public List<TreeNode> visit(TreeNode beginNode) {
        if(node instanceof DirectTakeNode) {
            DirectTakeNode tmpNode = (DirectTakeNode) node;
            String directValue = tmpNode.getDirectValue();
            return Collections.singletonList(TreeNode.build(directValue, directValue));
        } else if (node instanceof ListTakeNode) {
            ListTakeNode tmpNode = (ListTakeNode) node;
            List<String> values = tmpNode.getValues();
            ArrayList<TreeNode> treeNodes = new ArrayList<>(values.size());
            values.forEach(x -> treeNodes.add(TreeNode.build(x, x)));
            return treeNodes;
        } else if (node instanceof FieldTakeNode) {
            FieldTakeNode tmpNode = (FieldTakeNode) node;
            String fieldName = tmpNode.getFieldName();
            return TreeNode.searchValues(beginNode, fieldName);
        }
        throw new IllegalStateException("Unknown node type: " + node.getClass().getName());
    }

}
