package 数据结构.树.二叉堆;

import java.util.Arrays;

/**
 * 优先队列
 * @author 张小涵
 */
public class PriorityQueue {
    private int[] array;
    private int size;
    public PriorityQueue(){
        //队列初始长度为32
        array = new int[2];
    }

    /**
     * 入队
     * @param key 入队元素
     */
    public void enQueue(int key){
        if(size >= array.length){
            reSize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
     * 出队
     * @return
     * @throws Exception
     */
    public  int deQueue() throws Exception{
        if(size <= 0){
            throw  new Exception("The queue is empty !");
        }
        //获取堆顶元素
        int head = array[0];
        //让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }
    /**
     * 上浮调整 插入节点 插入到完全二叉树最后一个节点
     */
    public void upAdjust(){
        //完全二叉树最后一个节点
        int childIndex =  size - 1;
        int parentIndex = (childIndex - 1)/2;
        // temp 保存插入的叶子节点值用于最后的复制
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]){
            //无须真正赋值，单向赋值即可
            //最后一个元素的值变为父节点元素
            array[childIndex] = array[parentIndex];
            //插入的这个元素上浮 索引变为父节点
            childIndex = parentIndex;
            //继续循环的话，继续上浮找父节点
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }
    /**
     * 队列扩容
     */
    private void  reSize(){
        //队列容量翻倍
        int newSize = this.size * 2;
            this.array = Arrays.copyOf(array,newSize);
    }
    /**
     * 下沉调整 删除节点  删除根节点
     */
    public void downAdjust(){
        //temp保持父节点的值，用于最后的赋值
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size){
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if(childIndex + 1 < size && array[childIndex + 1] < array[childIndex]){
                childIndex ++ ;
            }
            //如果父节点小于任何一个孩子的值, 则直接跳出
            if(temp < array[childIndex]){
                break;
            }
            //无须真正交换，单向赋值即可  定位到右孩子之后  右孩子变成这个值 继续下沉
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    public static void main(String[] args) throws Exception{
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println("出队元素：" + priorityQueue.deQueue());
        System.out.println("出队元素" + priorityQueue.deQueue());
        System.out.println("出队元素" + priorityQueue.deQueue());

    }
}
