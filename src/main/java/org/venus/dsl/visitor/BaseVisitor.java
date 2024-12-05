package org.venus.dsl.visitor;

import org.venus.dsl.data.TreeNode;

/**
 * 完全的Visitor模式
 */
public interface BaseVisitor {

    Object visit(TreeNode TreeNode);

}
