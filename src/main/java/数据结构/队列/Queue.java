package 数据结构.队列;

/**
 * @author zhangxiaohan
 */
public interface Queue<E> {
    /**
     * 获取队列中元素个数
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 获取队首元素
     * @return
     */
    E getFront();
}
