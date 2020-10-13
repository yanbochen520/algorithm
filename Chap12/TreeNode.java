package  Chap12;

/**
 * Created with IntelliJ IDEA.
 * 二叉树的节点类型
 * @Auther: ybchen
 * @Date: 2020/03/15/19:02
 * @Description
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode  right;
    public  TreeNode  parent;
    int    height;
    public int size;//树的规模

    public TreeNode(int key, TreeNode left, TreeNode right,TreeNode parent) {
        this.val = key;
        this.left = left;
        this.right = right;
        this.parent=parent;
    }
    public TreeNode(int key) {
       this(key,null,null,null);
    }

}
