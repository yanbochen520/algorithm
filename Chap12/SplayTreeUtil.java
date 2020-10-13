package  Chap12;

import static  Chap12.TreeUtil.setHeight;

/**
 * Created with IntelliJ IDEA.
 * 伸展树工具类
 * @Auther: ybchen
 * @Date: 2020/03/17/18:30
 * @Description
 */

public class SplayTreeUtil {
    /**
     * 将node子树作为左子树接入root中
     * @param root
     * @param node
     * @return
     */
    public static TreeNode attachAsLC(TreeNode root,TreeNode node){
        if(node!=null){
            root.left=node;
            node.parent=root;
        }
        setHeight(root);
        return root;
    }

    /**
     * 将node子树作为右子树接入root中
     * @param root
     * @param node
     * @return
     */
    public static TreeNode attachAsRC(TreeNode root,TreeNode node){

        if(node!=null){
            root.right=node;
            node.parent=root;
        }
        setHeight(root);
        return root;
    }
}
