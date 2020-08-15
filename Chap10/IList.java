package com.ums.algorithm.Chap10;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/11/17:35
 * @Description
 */

public interface IList {
    ListNode search(int value);
    ListNode insertFirst(int value);
    ListNode insertLast(int value);
    void delete(int value);
}
