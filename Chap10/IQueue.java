package com.ums.algorithm.Chap10;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/11/11:35
 * @Description
 */

public interface IQueue {
    int dequeue();
    void enqueue(int value);
    boolean isEmpty();
}
