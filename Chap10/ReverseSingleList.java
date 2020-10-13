package  Chap10;

import  Chap12.TreeNode;
import sun.awt.SunToolkit;

import java.util.HashMap;
import java.util.Map;

import static  Chap12.TreeTravelRec.postOrderTravelRec;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/12/10:57
 * @Description
 */

public class ReverseSingleList {
    public static Map<Integer,Integer>  map=new HashMap();
    /**
     * 反转链表
     * 迭代
     * @param head
     * @return
     */
    public static SingleListNode reverseList(SingleListNode head) {
        SingleListNode current = head;
        SingleListNode preNode = null;
        SingleListNode nextNode;
        while (current != null) {
            nextNode = current.next; //记录当前节点的下一个节点
            current.next = preNode;
            preNode = current;
            current = nextNode;
        }
        return preNode;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null){
            return null;
        }
        initMap(inorder);
        return buildTreeRec(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }


    public static TreeNode buildTreeRec(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }else{
            TreeNode root=new TreeNode(preorder[preStart]);
            int i=map.get(preorder[preStart]);
            root.left=buildTreeRec(preorder,preStart+1,i-inStart+preStart,inorder,inStart,i-1);
            root.right=buildTreeRec(preorder,i-inStart+preStart+1,preEnd,inorder,i+1,inEnd);
            return root;
        }
    }
    public static void initMap(int[] inorder){
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

    }

    public SingleListNode getKthFromEnd(SingleListNode head, int k) {
        if (head == null) {
            return null;
        }
        SingleListNode first = null;
        SingleListNode second = null;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    public int[] constructArr(int[] a) {
        if(a==null||a.length==0){
            return null;
        }
        int len=a.length;
        int[] result=new int[len];
        int sum=1;
        int index=-1;
        int count=0;
        for(int i=0;i<len;i++){
            if(a[i]==0){
               index=i;
               count=count+1;
            }
            sum=sum*a[i];
        }
        if(sum!=0) {
            for (int i = 0; i < len; i++) {
                result[i] = sum / a[i];
                return result;
            }
        }else{
            if(count>1){
                return result;
            }else{
                   sum=1;
                  for(int i=0;i<len;i++){
                   if(i!=index){
                       sum=sum*a[i];
                   }
                }
                result[index]=sum;
            }
        }
        return result;
    }


    /**
     * 反转链表
     * 递归
     * @param head
     * @return
     */
    public static SingleListNode reverseListRec(SingleListNode head) {
        SingleListNode node;
        if (head == null || head.next == null) {
            return head; // base case
        } else {
            Map<Integer,Integer>  map=new HashMap();
            node = reverseListRec(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }
    }


    public SingleListNode mergeTwoLists(SingleListNode l1, SingleListNode l2) {
        SingleListNode node=new SingleListNode(Integer.MIN_VALUE);
        SingleListNode res=node;
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        while(l1!=null&&l2!=null){
            while(l1!=null&&l2!=null&&l1.value<=l2.value){
                res.next=l1;
                res=l1;
                l1=l1.next;
            }
            while(l1!=null&&l2!=null&&l1.value>l2.value){
                res.next=l2;
                res=l2;
                l2=l2.next;

            }
        }
        while(l1!=null){
            res.next=l1;
            res=l1;
            l1=l1.next;
        }
        while(l2!=null){
            res.next=l2;
            res=l2;
            l2=l2.next;
        }
      return node.next;
    }
    public double myPow(double x, int n) {
        double res= myPow1(x,n);
        if(res>Integer.MAX_VALUE){
            return 0;
        }else {
            return res;
        }
    }

    public double myPow1(double x, int n) {
        if(n<0){
                x = 1 / x;
                n = -n;
        }
         if(n==0){
             return 1;
         }else{
             double temp=myPow1(x,n/2);
             if(n%2==0){
                 return temp*temp;
             }else{
                 return (temp*temp*x);
             }
         }
    }

    public static void main(String[] args) {
//       int[] preorder = {3,9,20,15,7};
//       int[] inorder=  {9,3,15,20,7};
        //TreeNode root= buildTree(preorder,inorder);
//      int[] preorder={1,2,3};
//     int[] inorder={1,2,3};
//        TreeNode root= buildTree(preorder,inorder);
//      //preOrderTravelRec(root);
//        //InOrderTravelRec(root);
//       postOrderTravelRec(root);
//        SingleListNode head1=new SingleListNode(-9);
//        SingleListNode node2=new SingleListNode(3);
//        //SingleListNode node3=new SingleListNode(4);
//         head1.next=node2;//node2.next=node3;
//        SingleListNode head2=new SingleListNode(5);
//        SingleListNode node4=new SingleListNode(7);
//       // SingleListNode node5=new SingleListNode(4);
//        head2.next=node4;//node4.next=node5;
//       SingleListNode head= new ReverseSingleList().mergeTwoLists(head1,head2);
//       while(head!=null){
//           System.out.println(head.value);
//           head=head.next;
//       }
//
//    }
        System.out.println(5&1);
    }
}
