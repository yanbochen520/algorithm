package BBST;

import java.util.Stack;

import static  BBST.TreeUtil.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/16/13:59
 * @Description
 */

public class TreePostOrderTravelIter {
    /**
     * 后序遍历
     * @param root
     */
    public static  void postOrderTravelIter(TreeNode root){
        Stack<TreeNode> dataStack=new Stack<>();
        Stack<TreeNode> collectStack=new Stack<>();
        dataStack.push(root);
        while(!dataStack.isEmpty()){
            TreeNode cur=dataStack.pop();
            collectStack.push(cur);
            if (hasLeftChild(cur)){
                dataStack.push(cur.left);
            }
            if (hasRightChild(cur)){
                dataStack.push(cur.right);
            }
        }
        while(!collectStack.isEmpty()){
            System.out.println(collectStack.pop().val);
        }
    }

    public static void main(String[] args) {
      TreeNode root = generateSearchTree();
      postOrderTravelIter(root);
    }
}
