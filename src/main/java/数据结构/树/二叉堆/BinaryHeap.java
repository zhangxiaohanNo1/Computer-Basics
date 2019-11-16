package 数据结构.树.二叉堆;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 二叉堆
 * @author zhangxiaohan
 */
public class BinaryHeap {

    /**
     * 上浮调整 插入节点 插入到完全二叉树最后一个节点
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array){
        //完全二叉树最后一个节点
        int childIndex = array.length - 1;
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
     * 下沉调整 删除节点  删除根节点
     * @param array 待调整的堆
     * @param  parentIndex 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array,int parentIndex,int length){
        //temp保持父节点的值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length){
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if(childIndex + 1 < length && array[childIndex + 1] < array[childIndex]){
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
    public static void buildHeap(int[] array){
        //从最后一个非叶子节点开始，依次做下沉调整
        for(int i = (array.length-2)/2; i>=0; i--){
            downAdjust(array, i, array.length);
        }
    }
    public static void main(String[] args) {
        int[] array = new int[] {1, 3, 2, 6, 5, 7, 8, 9 , 10 ,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        array = new int[] {7, 1, 3, 10, 5, 2, 8, 9 ,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
