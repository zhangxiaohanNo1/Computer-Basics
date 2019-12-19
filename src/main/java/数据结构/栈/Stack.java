package 数据结构.栈;

/**
 * @author zhangxiaohan
 * @param <E>
 */
public interface Stack<E> {
    /**
     * 获取栈的容量
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();
}
