package org.venus.dsl.visitor;

import org.venus.dsl.data.TreeNode;

public interface BaseVisitor {

    Object visit(TreeNode TreeNode);

}
