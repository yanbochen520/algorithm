package  Chap10;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * 由两个栈实现的队列
 * 10.1-6
 * @Auther: ybchen
 * @Date: 2020/03/11/15:17
 * @Description
 */

public class TwoStackQueue<T> {
    private  Stack<T> dataStack = new Stack<>();
    private  Stack<T> helpStack = new Stack<>();

    public  void enqueue(T value) {
        while (!helpStack.isEmpty()) {
                dataStack.push(helpStack.pop());
            }
            dataStack.push(value);
        }

    public  T  dequeue(){
        if (!isEmpty()) {
            while (!dataStack.isEmpty()) {
                helpStack.push(dataStack.pop());
            }
            return helpStack.pop();
        } else{
            throw new IllegalArgumentException("队列为空");
        }

    }
    public boolean isEmpty(){
        return dataStack.isEmpty()&&helpStack.isEmpty();
    }

    public static void main(String[] args) {
    }
}
