package 数据结构.链表;

/**
 * 链表
 * @author zhangxiaohan
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }
        public Node(){
            this(null, null);
        }
        @Override
        public String toString(){
           return e.toString();
        }
    }

    private Node head;
    private int size;
    public LinkedList(){
        head = null;
        size = 0;
    }
    //获取链表中的元素
    public int getSize(){
        return size;
    }
    //返回是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //为链表头部添加元素 e
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        head = new Node(e, head);
        size ++;
    }

    //在链表中间添加元素

}
