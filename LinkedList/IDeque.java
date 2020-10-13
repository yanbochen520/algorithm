package LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/11/14:34
 * @Description
 */

public interface IDeque {
    void addFirst(int value);
    int removeFirst();
    void addLast(int value);
    int removeLast();
    boolean isEmpty();
}
