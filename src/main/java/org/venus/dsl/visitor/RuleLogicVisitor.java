package org.venus.dsl.visitor;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.venus.dsl.analyze.Analyze;
import org.venus.dsl.data.TreeNode;
import org.venus.dsl.parse.node.RuleLogicNode;
import org.venus.dsl.parse.node.type.OperationType;
import org.venus.dsl.parse.node.value.ValueTakeNode;

import java.util.*;

@Slf4j
@AllArgsConstructor
public class RuleLogicVisitor implements BaseVisitor {

    private final RuleLogicNode node;

    private final Analyze analyze;

    @Override
    public List<TreeNode> visit(TreeNode beginNode) {
        OperationType operationType = node.getOperationType();
        List<TreeNode> lhsObj = getValueTakeObj(node.getLhs(), beginNode);
        List<TreeNode> rhsObj = getValueTakeObj(node.getRhs(), beginNode);
        // 没有发现目标字段
        if(lhsObj.isEmpty() || rhsObj.isEmpty()) {
            return null;
        }
        if (operationType == OperationType.EQUAL) {
            List<TreeNode> equals = equals(lhsObj, rhsObj.get(0).getValue());
            if(!equals.isEmpty()) {
                return equals;
            }
            return null;
        } else if (operationType == OperationType.NotEqual) {
            List<TreeNode> equals = notEquals(lhsObj, rhsObj.get(0).getValue());
            if(!equals.isEmpty()) {
                return equals;
            }
            return null;
        } else if (operationType == OperationType.IN) {
            List<TreeNode> res = contains(lhsObj, rhsObj);
            if(res.isEmpty()) {
                return null;
            }
            return res;
        } else if (operationType == OperationType.CONTAINS) {
            List<TreeNode> res = contains(lhsObj, rhsObj);
            if(res.isEmpty()) {
                return null;
            }
            return res;
        } else if (operationType == OperationType.NotContains) {
            boolean flag = notContains(lhsObj, rhsObj);
            if(flag) {
                return Collections.emptyList();
            } else {
                return null;
            }
        } else if (operationType == OperationType.GT) {
            String l = lhsObj.get(0).getValue();
            String r = rhsObj.get(0).getValue();
            if(l.compareTo(r) > 0) {
                return lhsObj;
            }
            return null;
        } else if (operationType == OperationType.GE) {
            String l = lhsObj.get(0).getValue();
            String r = rhsObj.get(0).getValue();
            if(l.compareTo(r) >= 0) {
                return lhsObj;
            }
            return null;
        } else if (operationType == OperationType.LE) {
            String l = lhsObj.get(0).getValue();
            String r = rhsObj.get(0).getValue();
            if(l.compareTo(r) <= 0) {
                return lhsObj;
            }
            return null;
        } else if (operationType == OperationType.LT) {
            String l = lhsObj.get(0).getValue();
            String r = rhsObj.get(0).getValue();
            if(l.compareTo(r) < 0) {
                return lhsObj;
            }
            return null;
        }
        throw new IllegalStateException("Unsupported operation type: " + operationType);
    }

    // TODO 实现字典映射转换
    private List<TreeNode> getValueTakeObj(ValueTakeNode node,
                                   TreeNode beginNode) {
        return new ValueTakeVisitor(analyze, node).visit(beginNode);
    }

    private List<TreeNode> equals(List<TreeNode> lhsObj, String fieldValue) {
        ArrayList<TreeNode> res = new ArrayList<>();
        for (TreeNode treeNode : lhsObj) {
            if(treeNode.getValue().equals(fieldValue)) {
                res.add(treeNode);
            }
        }
        return res;
    }

    private List<TreeNode> notEquals(List<TreeNode> lhsObj, String fieldValue) {
        ArrayList<TreeNode> res = new ArrayList<>();
        for (TreeNode treeNode : lhsObj) {
            if(!treeNode.getValue().equals(fieldValue)) {
                res.add(treeNode);
            }
        }
        return res;
    }

    private List<TreeNode> contains(List<TreeNode> lhs, List<TreeNode> rhs) {
        ArrayList<TreeNode> res = new ArrayList<>();
        for (TreeNode rh : rhs) {
            for (TreeNode lh : lhs) {
                if(Objects.equals(lh.getValue(), rh.getValue())) {
                    res.add(lh);
                }
            }
        }
        return res;
    }

    private boolean notContains(List<TreeNode> lhs, List<TreeNode> rhs) {
        List<TreeNode> res = contains(lhs, rhs);
        if(res.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
