package com.ums.algorithm.Chap12;

import java.util.Stack;

import static com.ums.algorithm.Chap12.TreeUtil.generateSearchTree;
import static com.ums.algorithm.Chap12.TreeUtil.hasRightChild;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/16/10:24
 * @Description
 */

public class TreeInOrderTravelIter {
    /**
     * 中序遍历迭代版1
     *
     * @param root
     */
    public static void InOrderTravelIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        while (true) {
            while (true) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    break;
                }
            }
            if (stack.isEmpty()) {
                return;
            } else {
                TreeNode node = stack.pop();
                System.out.println(node.val);
                if (hasRightChild(node)) {
                    root = node.right;
                }
            }
        }
    }
    /**
     * 中序遍历迭代版2
     *
     * @param root
     */
    public static void InOrderTravelIter2(TreeNode root,Stack<TreeNode> stack){
            while (true) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    break;
                }
            }
            if (stack.isEmpty()) {
                return;
            } else {
                TreeNode node = stack.pop();
                System.out.println(node.val);
                InOrderTravelIter2(node.right,stack);
            }
        }
    /**
     * 中序遍历迭代版3
     *
     * @param root
     */
    public static void InOrderTravelIter3(TreeNode root) {
        if (root == null) {
            return;
        } else {
            Stack<TreeNode> stack = new Stack();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root=generateSearchTree();
        InOrderTravelIter3(root);
    }
}
