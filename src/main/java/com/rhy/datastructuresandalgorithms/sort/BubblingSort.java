package com.rhy.datastructuresandalgorithms.sort;

import java.util.Arrays;

/**
 * @author: Rhy
 * @date: 2021/8/24 10:57
 * @description: 冒泡排序
 */
public class BubblingSort {
    public static void sort(int[] arr){
        //每个数都循环一遍
        for (int i = 0,len = arr.length; i < len; i++) {
            // 减i是因为减去已经排好数的位置
            for (int j = 0; j < len - i - 1; j++) {

//                if(arr[j] < arr[j+1]){ //如果前一个数小于后一个数，则交换位置，从大到小
                if(arr[j] > arr[j+1]){ //如果前一个数大于后一个数，则交换位置，从小到大
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            DataService.show(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = DataService.getArr();
        sort(arr);
    }

}
