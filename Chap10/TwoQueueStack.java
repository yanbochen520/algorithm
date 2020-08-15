package com.ums.algorithm.Chap10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * 10.1-7
 * @Auther: ybchen
 * @Date: 2020/03/11/15:48
 * @Description
 */

public class TwoQueueStack<T> {
    private Queue<T> dataQueue=new LinkedList<>();//存放数据
    private Queue<T> helpQueue=new LinkedList<>();//辅助队列

    public void push(T value){
        dataQueue.offer(value);
    }

    public T pop() {
        if (!dataQueue.isEmpty()) {
            while (dataQueue.size() - 1 > 0) {
                helpQueue.offer(dataQueue.poll());
            }
            T result = dataQueue.poll();
            swapQueue();
            return result;
        }else{
            throw new IllegalArgumentException("栈为空");
        }

    }
    public void swapQueue(){
        Queue temp=this.helpQueue;
        this.helpQueue=this.dataQueue;
        this.dataQueue=temp;

    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return dataQueue.isEmpty();
    }

    public static void main(String[] args) {
        TwoQueueStack<Integer> stack=new TwoQueueStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        int result=stack.pop();
        System.out.println(result);
        result=stack.pop();
        System.out.println(result);
        result=stack.pop();
        System.out.println(result);
        result=stack.pop();
        System.out.println(result);
        stack.push(7);
        stack.push(8);
        result=stack.pop();
        System.out.println(result);


    }

}
