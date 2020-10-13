package  Chap12;


import static  Chap12.TreeTravelRec.InOrderTravelRec;
import static  Chap12.TreeUtil.*;


/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/15/19:07
 * @Description
 */

public class SearchTree {
    public TreeNode root;

    public SearchTree(TreeNode root) {
        this.root = root;
    }

    public SearchTree() {
        this(null);
    }

    /**
     * 搜索二叉树查找算法
     *
     * @param target
     * @param root
     * @return
     */
    public static TreeNode searchInBinaryTree(int target, TreeNode root) {
        while (root != null && root.val != target) {
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    /**
     * 搜索二叉树查找算法
     * 递归实现
     *
     * @param target
     * @param root
     * @return
     */
    public static TreeNode searchInBinaryTreeRec(TreeNode target, TreeNode root) {
        if (root == null || root.val == target.val) {
            return root;
        }
        if (root.val > target.val) {
            return searchInBinaryTreeRec(target, root.left);
        } else {
            return searchInBinaryTreeRec(target, root.right);
        }
    }

    /**
     * 删除节点
     *
     * @param key
     * @param root
     * @return
     */
    public static boolean delete(TreeNode key, TreeNode root) {
        TreeNode node = searchInBinaryTreeRec(key, root);
        if (node == null) {
            return false;
        } else {
            deleteNodes(key, root);
        }

        return true;
    }

    /**
     * 节点删除算法
     *
     * @param node
     * @param root
     */
    public static void deleteNodes(TreeNode node, TreeNode root) {
        if (!hasRightChild(node) && hasLeftChild(node)) {
            node.val = node.left.val;
            node.left.parent = null;
            node.left = null;
            setHeightAbove(node);
        } else if (hasRightChild(node) && !hasLeftChild(node)) {
            node.val = node.right.val;
            node.right.parent = null;
            node.right = null;
            setHeightAbove(node);
        } else if (!hasRightChild(node) && !hasLeftChild(node)) {
            TreeNode parent = node.parent;
            if (isLeftChild(node)) {
                parent.left = null;
            } else {
                parent.right = null;
            }
           setHeightAbove(parent);
       } else {
            TreeNode successor = successor(node, root);
            int temp = node.val;
            node.val = successor.val;
            successor.val = temp;
            deleteNodes(successor, root);
        }
    }

    /**
     * 插入算法
     *
     * @param root
     * @param targetNumber
     * @return
     */
    public static TreeNode insert(TreeNode root, int targetNumber) {
        if (root == null) {
            return new TreeNode(targetNumber);
        } else {
            if (targetNumber < root.val) {
                root.left = insert(root.left, targetNumber);
            } else {
                root.right = insert(root.right, targetNumber);
            }
            root.size = 1 + TreeUtil.size(root.left) + TreeUtil.size(root.right);//更新树的规模
            return root;
        }
    }

    public int size() {
        return TreeUtil.size(root);
    }

    public static void main(String[] args) {
//        SearchTree searchTree=new SearchTree();
        int[] arr ={1,2,3,4,5};
        TreeNode root=null;
        for(int i=0;i<arr.length;i++) {
         root= insert(root, arr[i]);
        }
        InOrderTravelRec(root);
    }
}
