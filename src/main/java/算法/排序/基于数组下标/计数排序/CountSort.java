package 算法.排序.基于数组下标.计数排序;

import java.util.Arrays;

/**
 * 计数排序 适用于一定范围的排序
 * @author zhangxiaohan
 */
public class CountSort {
    public static int[] countSort(int[] array){
        //1.得到数列的最大值
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        //2.根据数列的最大值确定统计数组的长度
        int[] countArray = new int[max + 1];
        //3.遍历数列，填充统计数组
        for(int i = 0; i < array.length; i++){
            //把每个元素+1再存回原来的位置  初始为0 没出现一次array[i]（9） 就在第10个位置（为9的数）多记录一次
            countArray[array[i]]++;
        }
        //4.遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for(int i = 0; i<countArray.length; i++){
            //countArray记录数字i的个数
            for (int j = 0; j < countArray[i]; j++){
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
