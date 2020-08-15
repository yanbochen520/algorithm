package com.ums.algorithm.Chap10;


/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/12/9:52
 * @Description
 */

public class SingleListNode extends ListNode {
    public int value;
    public SingleListNode next;

    public SingleListNode(int value, SingleListNode next) {
        this.value = value;
        this.next = next;
    }
    public SingleListNode(int value){
        this(value,null);
    }
}
