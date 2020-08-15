package com.ums.algorithm.Chap12;

import java.util.Stack;

import static com.ums.algorithm.Chap12.TreeUtil.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/15/20:30
 * @Description
 */

public class TreePreOrderTravelIter {
    /**
     * 前序遍历迭代版1
     *
     * @param root
     */
    public static void preOrderTravelIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (hasRightChild(node)) {
                stack.push(node.right);
            }
            if (hasLeftChild(node)) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 前序遍历迭代版2
     *
     * @param root
     */
    public static void preOrderTravelIter2(TreeNode root, Stack<TreeNode> stack) {
        while (true) {
            System.out.println(root.val);
            if (hasRightChild(root)) {
                stack.push(root.right);
            }
            if (hasLeftChild(root)) {
                root = root.left;
            } else {
                break;
            }
        }
        if (stack.isEmpty()) {
            return;
        } else {
            preOrderTravelIter2(stack.pop(), stack);
        }
    }

    /**
     * 前序遍历迭代版3
     *
     * @param root
     */
    public static void preOrderTravelIter3(TreeNode root, Stack<TreeNode> stack) {
        while (true) {
            while (true) {
                System.out.println(root.val);
                if (hasRightChild(root)) {
                    stack.push(root.right);
                }
                if (hasLeftChild(root)) {
                    root = root.left;
                } else {
                    break;
                }
            }
            if (stack.isEmpty()) {
                return;
            } else {
                root = stack.pop();
            }

        }
    }

    public static void main(String[] args) {
        TreeNode head = generateSearchTree();
        preOrderTravelIter3(head, new Stack<>());
    }

}
