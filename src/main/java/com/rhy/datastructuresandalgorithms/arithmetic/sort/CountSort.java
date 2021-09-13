package com.rhy.datastructuresandalgorithms.arithmetic.sort;

import java.util.Random;

/**
 * @author: Rhy
 * @date: 2021/9/7 10:58
 * @description: 计数排序
 * 比如有900万学生的成绩，成绩保留两位小数（0~900），进行排序
 */
public class CountSort {
    public static void main(String[] args) {
        Random random = new Random();
        double[] arr = new double[900];
        for (int i = 0; i < 900; i++) {
            arr[i] = Math.floor(random.nextDouble()*1000*100)/100;
        }
        countSort(arr,99999);
    }
    public static void countSort(double[] arr,int max){
        //返回的有序数组
        double[] res = new double[arr.length];
        //用来统计的数组
        int[] counts = new int[max];
        //将数据统计到一个数组中，相同数放入同一个下标中，并++
        for (int i = 0,len = arr.length; i < len; i++) {
            int v = (int) (arr[i] * 100);
            counts[v]++;
        }
        //从最小到最大输出
        int resIndex = 0;
        for (int i = 0; i < max; i++) {
            if(counts[i] > 0){
                //这个数存在
                for (int j = 0,len = counts[i]; j < len; j++) {
                    res[resIndex++] = i/100D;
                }
            }
        }

        DataService.show(res);
    }
}
