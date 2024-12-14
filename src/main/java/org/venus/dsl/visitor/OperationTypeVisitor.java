package org.venus.dsl.visitor;

import org.venus.dsl.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OperationTypeVisitor {

    public static Object equal(List<TreeNode> lhsObj, List<TreeNode> rhsObj) {
        List<TreeNode> equals = equals(lhsObj, rhsObj.get(0).getFieldValue());
        if(!equals.isEmpty()) {
            return equals;
        }
        return null;
    }

    public static Object notEqual(List<TreeNode> lhsObj, List<TreeNode> rhsObj) {
        List<TreeNode> equals = notEquals(lhsObj, rhsObj.get(0).getFieldValue());
        if(!equals.isEmpty()) {
            return equals;
        }
        return null;
    }

    public static List<TreeNode> equals(List<TreeNode> lhsObj, String fieldValue) {
        ArrayList<TreeNode> res = new ArrayList<>();
        for (TreeNode treeNode : lhsObj) {
            if(treeNode.getFieldValue().equals(fieldValue)) {
                res.add(treeNode);
            }
        }
        return res;
    }

    public static List<TreeNode> notEquals(List<TreeNode> lhsObj, String fieldValue) {
        ArrayList<TreeNode> res = new ArrayList<>();
        for (TreeNode treeNode : lhsObj) {
            if(!treeNode.getFieldValue().equals(fieldValue)) {
                res.add(treeNode);
            }
        }
        return res;
    }

    public static List<TreeNode> contains(List<TreeNode> lhs, List<TreeNode> rhs) {
        ArrayList<TreeNode> res = new ArrayList<>();
        for (TreeNode rh : rhs) {
            for (TreeNode lh : lhs) {
                if(Objects.equals(lh.getFieldValue(), rh.getFieldValue())) {
                    res.add(lh);
                }
            }
        }
        if(res.isEmpty()) {
            return null;
        }
        return res;
    }

    public static Boolean notContains(List<TreeNode> lhs, List<TreeNode> rhs) {
        List<TreeNode> res = contains(lhs, rhs);
        if(res.isEmpty()) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public static List<TreeNode> gt(List<TreeNode> lhs, List<TreeNode> rhs) {
        String l = lhs.get(0).getFieldValue();
        String r = rhs.get(0).getFieldValue();
        if(l.compareTo(r) > 0) {
            return lhs;
        }
        return null;
    }

    public static List<TreeNode> ge(List<TreeNode> lhs, List<TreeNode> rhs) {
        String l = lhs.get(0).getFieldValue();
        String r = rhs.get(0).getFieldValue();
        if(l.compareTo(r) >= 0) {
            return lhs;
        }
        return null;
    }

    public static List<TreeNode> lt(List<TreeNode> lhs, List<TreeNode> rhs) {
        String l = lhs.get(0).getFieldValue();
        String r = rhs.get(0).getFieldValue();
        if(l.compareTo(r) < 0) {
            return lhs;
        }
        return null;
    }

    public static List<TreeNode> le(List<TreeNode> lhs, List<TreeNode> rhs) {
        String l = lhs.get(0).getFieldValue();
        String r = rhs.get(0).getFieldValue();
        if(l.compareTo(r) <= 0) {
            return lhs;
        }
        return null;
    }

}
