package LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/11/17:40
 * @Description
 */

public class MyDoubleList implements IList {
    public DoubleListNode head;
    @Override
    public DoubleListNode search(int value) {
        DoubleListNode node = head;
        while (node != null && node.value != value) {
            node = node.next;
        }
        return node;
    }

    /**
     * 向前插入算法
     * @param value
     */
    @Override
    public DoubleListNode insertFirst(int value) {
        DoubleListNode node=new DoubleListNode(value);
        if (head==null){
            this.head=node;
        }else{
            node.next=head;
            head.pre=node;
            this.head=node;
        }
        return node;
    }
    /**
     * 向后插入算法
     * @param value
     */
    @Override
    public DoubleListNode insertLast(int value) {
       // DoubleListNode firstNode = this.head;
        DoubleListNode node = new DoubleListNode(value);
        DoubleListNode lastNode = getLastListNodeNode(this);
        if (lastNode != null) {
            lastNode.next = node;
            node.pre = lastNode;
        } else {
            this.head = node;
        }
        return  this.head;
    }

    @Override
    public void delete(int value) {
        DoubleListNode target=search(value);
        if (target!=null) {
            if (target.pre != null) {
                target.pre.next = target.next;
            } else {
                this.head = target.next; //换头操作
            }
            if (target.next != null) {
                target.next.pre = target.pre;
            }
        }else{
            throw new IllegalArgumentException("待删除的目标节点不存在此链表中");
        }

    }

    /**
     * 查找链表的末尾节点
     * @param list
     * @return
     */
    private DoubleListNode getLastListNodeNode(MyDoubleList list){
        DoubleListNode doubleListNode =list.head;
        while (doubleListNode != null && doubleListNode.next != null) {
            doubleListNode = doubleListNode.next;
        }
        return doubleListNode;
    }

    public static void main(String[] args) {
//        MyDoubleList list=new MyDoubleList();
//        for (int i=0;i<3;i++){
//            list.insertLast(i);
//        }
//       list.delete(1);
//       DoubleListNode node= list.head;
//        while(node!=null){
//            System.out.println(node.value);
//            node= node.next;
//        }

    }
}
