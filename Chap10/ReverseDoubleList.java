package com.ums.algorithm.Chap10;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/12/14:38
 * @Description
 */

public class ReverseDoubleList {
    /**
     * 反转双向链表
     * @param head
     * @return
     */
    public static DoubleListNode reverseListRec(DoubleListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            DoubleListNode node = reverseListRec(head.next);
            head.pre = head.next;
            head.pre.next = head;
            head.next = null;
            return node;
        }
    }
    /**
     * 反转双向链表
     * @param head
     * @return
     */
    public static DoubleListNode reverseList(DoubleListNode head) {
        DoubleListNode cur = head;
        DoubleListNode preNode = null;
        DoubleListNode nextNode ;
        while (cur != null) {
            nextNode = cur.next;//记录当前节点的下一个节点
            cur.next = cur.pre;
            cur.pre  = nextNode;
            preNode  = cur;
            cur = nextNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
//        MyDoubleList list=new MyDoubleList();
//        for (int i=0;i<2;i++){
//            list.insertLast(i);
//        }
//        DoubleListNode head= reverseList(list.head);
//        while (head != null) {
//            System.out.println(head.value);
//            head = head.next;
//        }

    }
}
