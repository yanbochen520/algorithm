package com.ums.algorithm.Chap12;

import static com.ums.algorithm.Chap12.TreeTravelRec.setHeightOfEachNode;
import static com.ums.algorithm.Chap12.TreeTravelRec.setSizeOfEachNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/15/20:05
 * @Description
 */

public class TreeUtil {
    public static TreeNode node6, node7, node8, node9, node11, node10, node5, node4, node3, node2, node1,head;

    public static TreeNode generateSearchTree() {
        node6 = new TreeNode(17);
        node7 = new TreeNode(20);
        node8 = new TreeNode(2);
        node9 = new TreeNode(4);
        node11 = new TreeNode(9);
        node10 = new TreeNode(13, node11, null, null);
        node5 = new TreeNode(7, null, node10, null);
        node4 = new TreeNode(3, node8, node9, null);
        node2 = new TreeNode(6, node4, node5, null);
        node3 = new TreeNode(18, node6, node7, null);
        head = new TreeNode(15, node2, node3, null);
        node3.parent = head;
        node2.parent = head;
        node4.parent = node2;
        node5.parent = node2;
        node6.parent = node7.parent = node3;
        node8.parent = node9.parent = node4;
        node10.parent = node5;
        node11.parent = node10;
        return head;
    }

    /**
     *生成二叉树
     * @return
     */
    public static TreeNode generateBinaryTreeForInsert(){
        head = new TreeNode(12);
        node1 = new TreeNode(5);
        node2 = new TreeNode(18);
        node3 = new TreeNode(2);
        node4 = new TreeNode(9);
        node5 = new TreeNode(15);
        node6 = new TreeNode(19);
        node7 = new TreeNode(17);
        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node5.right = node7;
        setSizeOfEachNode(head);
        setHeightOfEachNode(head);
        return head;
    }




    /**
     * 树的最小节点的值
     *
     * @param root
     * @return
     */
    public static int treeMinimum(TreeNode root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    /**
     * 树的最大节点的值
     *
     * @param root
     * @return
     */
    public static int treeMaximum(TreeNode root) {
        while (root != null && root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    /**
     * 判断一棵树是否为二叉搜索树
     *
     * @param root
     */
    public static boolean isBinarySearchTree(TreeNode root) {
        if (root == null) {
            return true;//base case
        } else {
            boolean left = isBinarySearchTree(root.left);
            boolean right = isBinarySearchTree(root.right);
            if (hasRightChild(root) && hasLeftChild(root)) {
                return left && right && root.val < root.right.val && root.val > root.left.val;
            } else if (hasRightChild(root) && !hasLeftChild(root)) {
                return left && right && root.val < root.right.val;
            } else if (hasLeftChild(root) && !hasRightChild(root)) {
                return left && right && root.val > root.left.val;
            } else {
                return left && right;
            }
        }
    }

    /**
     * 寻找一个节点的直接后继节点
     *
     * @param root
     * @param target
     * @return
     */
    public static  TreeNode successor(TreeNode root, TreeNode target) {
        if (root == null) {
            throw new IllegalArgumentException("树为空,查找失败");
        } else {
            if (hasRightChild(target)) {
                TreeNode rightChild = target.right;
                while (rightChild != null && hasLeftChild(rightChild)) {
                    rightChild = rightChild.left;
                }
                return rightChild;
            } else {
                while (target != null && target.parent != null && !isLeftChild(target)) {
                    target = target.parent;
                }
                return target.parent;
            }
        }
    }

    /**
     * 寻找一个节点的直接前驱节点
     *
     * @param root
     * @param target
     * @return
     */
    public static int predecessor(TreeNode root, TreeNode target) {
        if (root == null) {
            throw new IllegalArgumentException("树为空,查找失败");
        } else {
            if (hasLeftChild(target)) {
                TreeNode leftChild = target.left;
                while (leftChild != null && hasRightChild(leftChild)) {
                    leftChild = leftChild.right;
                }
                return leftChild.val;
            } else {
                while (target != null && target.parent != null && !isRightChild(target)) {
                    target = target.parent;
                }
                return target.parent.val;
            }
        }
    }

    /**
     * 判断treeNode是否有左孩子
     *
     * @param treeNode
     * @return
     */
    public static boolean hasLeftChild(TreeNode treeNode) {
        return treeNode.left != null;
    }

    /**
     * 判断treeNode是否有右孩子
     *
     * @param treeNode
     * @return
     */
    public static boolean hasRightChild(TreeNode treeNode) {
        return treeNode.right != null;
    }

    /**
     * 判断treeNode是否为左孩子
     *
     * @param treeNode
     * @return
     */
    public static boolean isLeftChild(TreeNode treeNode) {
        return treeNode.parent.left == treeNode;
    }

    /**
     * 判断treeNode是否为右孩子
     *
     * @param treeNode
     * @return
     */
    public static boolean isRightChild(TreeNode treeNode) {
        return treeNode.parent.right == treeNode;
    }

    /**
     * 求子树的规模
     * @param node
     * @return
     */
    public static int size(TreeNode node){
        if (node==null){
            return 0;
        }else{
            return  size(node.left)+size(node.right)+1;
        }
    }

    /**
     *更新某一具体节点的高度
     * @return
     */
    public static int setHeight(TreeNode node){
        if (node==null){
            return -1;
        }else {
            return   node.height=  1+Math.max(setHeight(node.left), setHeight(node.right));
        }
    }

    /**
     * 自下而上更新各个节点的高度
     * @param node
     */
    public static void setHeightAbove(TreeNode node){
        while(node!=null){
            setHeight(node);
            node=node.parent;
        }
    }

    /**
     * 理想平衡条件
     * @param node
     * @return
     */
    public static boolean balanced(TreeNode node){
        return setHeight(node.left)==setHeight(node.right);
    }

    /**
     * 节点的平衡因子
     * @param node
     * @return
     */
    public static int balanceFactor(TreeNode node){
        return setHeight(node.left)-setHeight(node.right);
    }

    /**
     * Avl树的平衡条件
     * @param node
     * @return
     */
    public static boolean AvlBalanced(TreeNode node){
        return  -2<balanceFactor(node)&&balanceFactor(node)<2;
    }

    /**
     * 左右孩子中取最高者
     * @param node
     * @return
     */
    public static TreeNode tallerChild(TreeNode node ){
        if (setHeight(node.left)==setHeight(node.right)){
            return isLeftChild(node)?node.left:node.right;
        }else{
           return setHeight(node.left)>setHeight(node.right)?node.left:node.right;
        }
    }
    public static int hammingWeight(int n) {
          if(n==0){
              return 0;
          }else{
              if(n%2==0){
                 return  hammingWeight(n>>1);
              }else{
                  return hammingWeight(n>>1)+1;
              }
          }
    }
//    public  int getBits(long n){
//        int[] result=new int[n+1];
//        result[0]=0;
//        for(int i=1;i<result.length;i++){
//            result[i]=result[i/2]+i%2;
//        }
//        return result[n];
//    }
//    public int hammingWeight(int n) {
//       //n= new TreeUtil().getRealNum((String) (n).toCharArray());
////        return getBits( n) ;
//    }
    public static int findBits(int number){
        int count=0;
        number=Integer.valueOf(Integer.toBinaryString(number));
        String num=String.valueOf(number);
        char[] charm=num.toCharArray();
        for(int i=0;i<charm.length;i++){
            if(charm[i]=='1'){
                count=count+1;
            }
        }
        return count;
    }
//    public  void  testForHammingWeight(int maxTimes){
//        for(int i=0;i<maxTimes;i++){
//            int result=new TreeUtil().hammingWeight(i);
//            int result2=findBits(i);
//            if(result!=result2){
//                SimpleUtil.whenErrorOccur();
//                return;
//            }
//        }
//        whenSuccess();
//    }
public int getRealNum(char[] charNum){
        int sum=0;
        for(int i=charNum.length-1,j=0;i>=0;i--){
             sum=sum+(int)(charNum[i]*Math.pow(2,j));
             j=j+1;
        }
        return sum;
}
public static int sum(int a,int b){
        while(true) {
            if (b == 0) {
                return a;
            }
            int temp=a;
            a=a^b;
            b=(temp& b) << 1;
        }
}

    public static int getBits(int number) {
        int count = 0;
        while (number != 0) {
            count = count + 1;
            number = number / 10;
        }
        return count;
    }



    public static void main(String[] args) {
    int res= getBits(100);
    System.out.println(res);
    }


}
