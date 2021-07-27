package com.vcampus.client.main;
import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 * 让目录全部展开
 * @author Dong Ruojing
 * @date 2021/7/28
 */

public class expandTree {
//如果bo为true展开所有节点，为false关闭所有节点。
    public static void expandTree(JTree tree,boolean bo) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();

        expandAll(tree, new TreePath(root), bo);

    }

    private static void expandAll(JTree tree, TreePath parent, boolean expand) {
        TreeNode node = (TreeNode) parent.getLastPathComponent();

        if (node.getChildCount() >= 0) {
            for (Enumeration e = node.children(); e.hasMoreElements(); ) {
                TreeNode n = (TreeNode) e.nextElement();

                TreePath path = parent.pathByAddingChild(n);

                expandAll(tree, path, expand);

            }

        }

        if (expand) {
            tree.expandPath(parent);

        } else {
            tree.collapsePath(parent);

        }

    }

}

