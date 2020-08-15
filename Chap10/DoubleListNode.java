package com.ums.algorithm.Chap10;

/**
 * Created with IntelliJ IDEA.
 * 双向链表的节点
 * @Auther: ybchen
 * @Date: 2020/03/11/17:32
 * @Description
 */

public class DoubleListNode extends  ListNode {
    public int value;
    public DoubleListNode pre;
    public DoubleListNode next;
    public DoubleListNode(int value, DoubleListNode pre, DoubleListNode next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }
    public DoubleListNode(int value) {
       this(value, null, null);
    }


}
