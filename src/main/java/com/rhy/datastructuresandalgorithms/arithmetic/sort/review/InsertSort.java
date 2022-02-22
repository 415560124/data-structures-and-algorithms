package com.rhy.datastructuresandalgorithms.arithmetic.sort.review;

import com.rhy.datastructuresandalgorithms.arithmetic.sort.DataService;

/**
 * @author: Rhy
 * @date: 2021/10/14 15:06
 * @description:
 */
public class InsertSort {
    public static void main(String[] args) {
        final int[] arr = DataService.getArr();
        DataService.show(sort(arr,0,1,arr.length));
    }

    /**
     * @param arr 待排序集合
     * @param start start+middle为已排序区间
     * @param middle start+middle为已排序区间
     * @param end middle+end为未排序区间
     */
    public static int[] sort(int[] arr,int start,int middle,int end){
        //循环未排序区间
        for (int i = middle; i < end; i++) {
            int tempData = arr[i];
            int cur = middle;
            //倒序循环已排序区间往里面插入
            for (int j = middle-1; j >= start; j--) {
                //如果当前待排序值大于要比较的值
                if(tempData > arr[j]){
                    break;
                }
                //当前排序值小于比较值，则把当前位置数字往后移动，因为比较值小的话放在它的前面还要挪动位置
                arr[j+1] = arr[j];
                //当移动后改变当前【预存放】位置下标
                cur = j;
            }
            //找到位置了赋值
            arr[cur] = tempData;
            //已排序区间+1
            middle++;
        }
        return arr;
    }
}
