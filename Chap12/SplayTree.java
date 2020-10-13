package  Chap12;
import static  Chap12.SearchTree.*;
import static  Chap12.SplayTreeUtil.attachAsLC;
import static  Chap12.SplayTreeUtil.attachAsRC;
import static  Chap12.TreeUtil.*;

/**
 * Created with IntelliJ IDEA.
 * 伸展树
 * @Auther: ybchen
 * @Date: 2020/03/17/18:36
 * @Description
 */

public class SplayTree {
    /**
     * Tarjan 的旋转算法
     * @param v
     * @return
     */
    public static TreeNode splay(TreeNode v){
        if (v==null){
            return null;
        }
        TreeNode p,g;
        //双次旋转
        while(((p=v.parent)!=null)&&((g=p.parent)!=null)){
            TreeNode gg=g.parent;
             boolean isLeftChild= isLeftChild(g);
            if (isLeftChild(v)){
                if (isLeftChild(p)){
                    attachAsLC(g,p.right);attachAsLC(p,v.right);
                    attachAsRC(p,g); attachAsRC(v,p);
                }else{
                    attachAsLC(p,v.right);attachAsRC(g,v.left);
                    attachAsLC(v,g);attachAsRC(v,p);
                }
            }else{
                if (isRightChild(p)){
                    attachAsRC(p,v.left);attachAsLC(g,v.right);
                    attachAsRC(v,g);attachAsLC(v,p);
                }else{
                    attachAsRC(p,v.left);attachAsLC(g,v.right);
                    attachAsLC(v,p);attachAsRC(v,g);
                }
            }
            if (gg==null){
                v.parent=null;
            }else{
             if (isLeftChild){
                 attachAsLC(gg,v);
             }else{
                 attachAsRC(gg,v);
             }
            }
            setHeightAbove(g); setHeightAbove(p); setHeightAbove(v);
        }
        //额外的单次旋转
        if ((p=v.parent)!=null){
            if (isLeftChild(v)){
                attachAsLC(p,v.right);attachAsRC(v,p);
            }else{
                attachAsLC(p,v.left);attachAsRC(v,p);
            }
            setHeightAbove(p); setHeightAbove(v);
        }
        v.parent=null;
        return v;
    }

    /**
     * 查找算法
     * @param target
     * @param root
     * @return
     */
    public static TreeNode splayTreeSearch(int target, TreeNode root) {
        TreeNode node = searchInBinaryTree(target, root);
        if (node == null) {
            return null;
        }
        root = splay(node);
        return root;
    }

    /**
     * 删除算法
     * @param key
     * @param root
     * @return
     */
    public static TreeNode  delete(TreeNode key, TreeNode root) {
        TreeNode realDeleteNode;
        if (hasLeftChild(key) && hasRightChild(key)) {
            realDeleteNode = successor(root, key);
        } else {
            realDeleteNode = key;
        }
        TreeNode node = searchInBinaryTreeRec(key, root);
        if (node == null) {
            return null;
        } else {
            deleteNodes(key, root);
        }
      return  splay(realDeleteNode);
    }

    /**
     * 插入算法
     * @param root
     * @param targetNumber
     * @return
     */
    public static TreeNode insert(TreeNode root, int targetNumber){
       root= insert(root,targetNumber);
       root= splayTreeSearch(targetNumber, root);
       return root;
    }



}
