package com.ums.algorithm.Chap10;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/12/9:56
 * @Description
 */

public class MySingleList implements IList {
    public SingleListNode head;

    @Override
    public SingleListNode search(int value) {
        SingleListNode node=head;
        while(node!=null && node.value!=value){
            node=node.next;
        }
        return node;
    }

    @Override
    public SingleListNode insertFirst(int value) {
        SingleListNode headNode = head;
        SingleListNode node = new SingleListNode(value);
        if (headNode == null) {
            head = node;
        } else {
            headNode.next = node;
        }
        return head;
    }

    @Override
    public SingleListNode insertLast(int value) {
        SingleListNode lastNode=getLastListNodeNode(this);
        SingleListNode node=new SingleListNode(value);
        if (lastNode==null){
            this.head=node;
        }else{
            lastNode.next=node;
        }
        return head;
    }

    @Override
    public void delete(int value) {
        SingleListNode preNode = null;
        SingleListNode cur = this.head;
        while (cur != null && cur.value != value) {
            preNode = cur;
            cur = cur.next;
        }
        if (cur != null) {
            if (preNode != null) {
                preNode.next = cur.next;
            } else {
                this.head = cur.next; //换头操作
            }
        } else {
            throw new IllegalArgumentException("待删除的目标节点不存在此链表中");
        }
    }
    /**
     * 查找链表的末尾节点
     * @param list
     * @return
     */
    private SingleListNode getLastListNodeNode(MySingleList list){
        SingleListNode singleListNode =list.head;
        while (singleListNode != null &&singleListNode.next != null) {
            singleListNode = singleListNode.next;
        }
        return singleListNode;
    }

    public static void main(String[] args) {
//        MySingleList list=new MySingleList();
//        for (int i=0;i<10;i++) {
//            list.insertLast(i);
//        }
//        list.delete(0);
//        SingleListNode node=list.head;
//        while(node!=null){
//           System.out.println(node.value);
//           node=node.next;
//        }
//    }
    }
}
