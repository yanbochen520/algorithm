package com.ums.algorithm.Chap12;

import static com.ums.algorithm.Chap12.TreeUtil.setHeight;
import static com.ums.algorithm.Chap12.TreeUtil.size;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/15/20:28
 * @Description
 */

public class TreeTravelRec {

    /**
     * 前序遍历
     * @param root
     */
    public static  void preOrderTravelRec(TreeNode root){
        while (root != null) {
            System.out.print(root.val);
            preOrderTravelRec(root.left);
            root = root.right;
        }
    }

    /**
     * 设置各个子树的规模
     * @param root
     */
    public static  void setSizeOfEachNode(TreeNode root){
        while (root != null) {
            root.size=size(root);
            setSizeOfEachNode(root.left);
            root = root.right;
        }
    }

    /**
     * 设置各个子树的高度
     * @param root
     */
    public static  void setHeightOfEachNode(TreeNode root){
        while (root != null) {
            root.size=setHeight(root);
            setHeightOfEachNode(root.left);
            root = root.right;
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void InOrderTravelRec(TreeNode root){
        while (root!=null){
            InOrderTravelRec(root.left);
            System.out.println(root.val);
            root=root.right;
        }
    }
    /**
     * 后序遍历
     * @param root
     */
    public static void postOrderTravelRec(TreeNode root) {
        if (root != null) {
            postOrderTravelRec(root.left);
            postOrderTravelRec(root.right);
            System.out.println(root.val);
        }
    }
}
