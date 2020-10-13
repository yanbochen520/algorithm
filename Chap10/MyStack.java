package  Chap10;

/**
 * Created with IntelliJ IDEA.
 * 栈及其操作
 *
 * @Auther: ybchen
 * @Date: 2020/03/10/18:37
 * @Description
 */

public class MyStack implements IStack {
    private  int CAPACITY = 10;
    private int[] element = new int[CAPACITY];
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(int value) {
        size = size + 1;
        if (size == CAPACITY) {
            resize(CAPACITY * 2);
            CAPACITY=CAPACITY*2;
        }
        element[size - 1] = value;
    }

    @Override
    public int pop() {
        if (!this.isEmpty()) {
            size = size - 1;
            int ele = element[size];
            if (size < CAPACITY / 4) {
                resize(CAPACITY / 2);
                CAPACITY=CAPACITY/2;
            }
            return ele;
        } else {
            throw new IllegalArgumentException("栈为空,无法弹出元素");
        }
    }

    /**
     * 动态调整内部数组的大小
     *
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
        IStack stack=new MyStack();
        for (int i=0;i<50;i++){
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int res=stack.pop();
            System.out.println(res);
        }
    }
}
