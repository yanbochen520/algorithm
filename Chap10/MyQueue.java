package  Chap10;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/11/11:37
 * @Description
 */

public class MyQueue implements IQueue {
    private  int CAPACITY = 10;
    private int[] element = new int[CAPACITY];
    private int size = 0;
    @Override
    public int dequeue() {
        if (!isEmpty()){
            int result=element[0];
            int[] arr=new int[element.length-1];
            System.arraycopy(element,1,arr,0,element.length-1);
            element=arr;
            size=size-1;
            if (size < CAPACITY / 4) {
                resize(CAPACITY / 2);
            }
            return result;
        }else{
            throw new IllegalArgumentException("队列为空,无法弹出元素");
        }
        }


    @Override
    public void enqueue(int value) {
        size = size + 1;
        if (size == CAPACITY) {
            resize(CAPACITY * 2);
            CAPACITY=CAPACITY*2;
        }
        element[size - 1] = value;
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

    public static void main(String[] args) {
        IQueue iQueue=new MyQueue();
        for (int i=0;i<50;i++){
           // stack.push(i);
            iQueue.enqueue(i);
        }
        while(!iQueue.isEmpty()){
            int res=iQueue.dequeue();
            System.out.println(res);
        }
    }
    }

