package 算法.排序.基于数组下标.桶排序;

import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.util.*;

/**
 * @author zhangxiaohan
 */
public class BucketSort {
    public static double[] bucketSort(double[] array){
        //1.得到数列的最大值和最小值，并计算出差值d
        double max = array[0];
        double min = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        double d = max - min;

        //2.初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(bucketNum);
        for (int i = 0; i < bucketNum; i++){
            bucketList.add(new LinkedList<Double>());
        }

        //3.遍历原始数组，将每个元素放入桶中
        for(int i = 0; i < array.length; i++){
            //计算放入哪个桶中
            int num = (int)((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }

        //4.对每个桶内部进行排序
        for(int i = 0; i < bucketList.size(); i++){
            Collections.sort(bucketList.get(i));
        }

        //5.输出全部元素
        double[] sortArray = new double[array.length];
        int index = 0;
        for(LinkedList<Double> list : bucketList){
            for(double element : list){
                sortArray[index] = element;
                index++;
            }
        }

        return sortArray;
    }

    public static void main(String[] args) {
        double[] array  = new double[]{4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4,12, 10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
