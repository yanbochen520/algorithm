package com.ums.algorithm.Chap12;

import static com.ums.algorithm.Chap12.SearchTree.*;
import static com.ums.algorithm.Chap12.TreeUtil.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/17/11:39
 * @Description
 */

public class AVLTree {
    //注：AVL树的查找算法沿用SearchTree中的查找算法即可

    /**
     * AVL树的插入算法
     *
     * @param root
     * @param targetNumber
     * @return
     */
    public static TreeNode insert(TreeNode root, int targetNumber) {
        root = insert(root, targetNumber);
        TreeNode node = searchInBinaryTree(targetNumber, root);
        while (node != null) {
            TreeNode parent = node.parent;
            if (!AvlBalanced(node)) {
                TreeNode node1 = rotateAt(tallerChild(tallerChild(node)));
                if (isLeftChild(node)) {
                    parent.left = node1;
                } else {
                    parent.right = node1;
                }
                break;
            } else {
                setHeight(node);//单纯更新节点高度
                node = parent;
            }
        }
        return root;
    }

    /**
     * 节点删除算法
     * @param key
     * @param root
     * @return
     */
    public static boolean AVLDelete(TreeNode key, TreeNode root) {
        TreeNode node = searchInBinaryTreeRec(key, root);
        if (node == null) {
            return false;
        } else {
             AVLDeleteNodes(key, root);
        }

        return true;
    }

    public static TreeNode AVLDeleteNodes(TreeNode node, TreeNode root) {
        TreeNode realDeleteNode;
        if (hasLeftChild(node) && hasRightChild(node)) {
            realDeleteNode = successor(root, node);
        } else {
            realDeleteNode = node;
        }
        deleteNodes(node, root);
        while (realDeleteNode != null) {
            TreeNode parent = realDeleteNode.parent;
            if (!AvlBalanced(realDeleteNode)) {
                TreeNode node1 = rotateAt(tallerChild(tallerChild(realDeleteNode)));
                if (isLeftChild(realDeleteNode)) {
                    parent.left = node1;
                } else {
                    parent.right = node1;
                }
                setHeight(realDeleteNode);//即使其并未失衡,全树高度也有可能降低
            } else {
                setHeight(node);//单纯更新节点高度
                realDeleteNode = parent;
            }
        }
        return root;
    }

    /**
     * 旋转操作
     * @param node
     * @return
     */
    public static TreeNode rotateAt(TreeNode node) {
        TreeNode parent = node.parent;
        TreeNode grandfather = parent.parent;
        if (isLeftChild(parent)) {
            if (isLeftChild(node)) {
                parent.parent = grandfather.parent;
                return connect34(node, parent, grandfather, node.left, node.right, parent.right, grandfather.right);
            } else {
                node.parent = grandfather.parent;
                return connect34(parent, node, grandfather, parent.left, node.left, node.right, grandfather.right);
            }
        } else {
            if (isRightChild(node)) {
                parent.parent = grandfather.parent;
                return connect34(grandfather, parent, node, grandfather.left, parent.left, node.left, node.right);
            } else {
                node.parent = grandfather.parent;
                return connect34(grandfather, node, parent, grandfather.left, node.left, node.right, parent.right);
            }
        }
    }

    /**
     * 3+4重构
     * 统一的重平衡算法
     * @param a
     * @param b
     * @param c
     * @param T0
     * @param T1
     * @param T2
     * @param T3
     * @return
     */
    public static TreeNode connect34(TreeNode a, TreeNode b, TreeNode c, TreeNode T0, TreeNode T1, TreeNode T2, TreeNode T3) {
        a.left = T0;
        if (T0 != null) {
            T0.parent = a;
        }
        a.right = T1;
        if (T1 != null) {
            T1.parent = a;
        }
        c.left = T2;
        c.right = T3;
        if (T2 != null) {
            T2.parent = a;
        }
        if (T3 != null) {
            T3.parent = a;
        }
        b.left = a;
        b.right = c;
        if (a != null) {
            a.parent = b;
        }
        if (c != null) {
            c.parent = b;
        }
        setHeight(a);
        setHeight(b);
        setHeight(c);
        return b;
    }
}
