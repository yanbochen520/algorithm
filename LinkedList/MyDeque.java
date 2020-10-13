package LinkedList;

/**
 * Created with IntelliJ IDEA.
 * 10.1-5
 * @Auther: ybchen
 * @Date: 2020/03/11/14:39
 * @Description
 */

public class MyDeque implements IDeque {
    private  int CAPACITY = 10;
    private int[] element = new int[CAPACITY];
    private int size = 0;
    @Override
    public void addFirst(int value) {
        size=size+1;
        if (size == CAPACITY) {
            resize(CAPACITY * 2);
            CAPACITY=CAPACITY*2;
        }
        int[] arr=new int[element.length+1];
        arr[0]=value;
        System.arraycopy(element,0,arr,1,element.length);
        element=arr;
    }

    @Override
    public int removeFirst() {
        if (!isEmpty()){
            int result=element[0];
            int[] arr=new int[element.length-1];
            System.arraycopy(element,1,arr,0,element.length-1);
            element=arr;
            size=size-1;
            if (size < CAPACITY / 4) {
                resize(CAPACITY / 2);
                CAPACITY=CAPACITY/2;
            }
            return result;
        }else{
            throw new IllegalArgumentException("队列为空,无法弹出元素");
        }
    }


    @Override
    public void addLast( int value) {
        size = size + 1;
        if (size == CAPACITY) {
            resize(CAPACITY * 2);
            CAPACITY=CAPACITY * 2;
        }
        element[size - 1] = value;
    }

    @Override
    public int removeLast() {
        if (!isEmpty()) {
            size = size - 1;
            int ele = element[size];
            if (size < CAPACITY / 4) {
                resize(CAPACITY / 2);
                CAPACITY=CAPACITY / 2;
            }
            return ele;
        } else {
            throw new IllegalArgumentException("队列为空,无法弹出元素");
        }

    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    /**
     * 动态调整内部数组的大小
     * @param newLength
     */
    private void resize(int newLength) {
        int[] temp = new int[newLength];
        for (int i = 0; i < size; i++) {
            temp[i] = element[i];
        }
        element = temp;
    }
}
