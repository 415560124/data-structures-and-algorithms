package com.rhy.datastructuresandalgorithms.sort;

import java.util.Arrays;

/**
 * @author: Rhy
 * @date: 2021/8/24 10:57
 * @description: 冒泡排序
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] arr = DataService.getArr();
//        sort(arr);
//        sort2(arr);
        sort3(arr);
    }

    /**
     * 优化了排序过程中后半部分可能已经有序的问题
     * @param arr
     */
    private static void sort3(int[] arr) {
        int sortDoneNum = arr.length - 1;
        for (int i = 0,len = arr.length; i < len; i++) {
            //是否已经排序完毕
            boolean sortDone = true;
            //已排序的位置下标
            int lastSortDone = 0;
            for (int j = 0; j < sortDoneNum; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //有元素交换，则未完成排序
                    sortDone = false;
                    //已排序的位置下标
                    lastSortDone = j;
                }
            }
            //下次排序只需要到这里即可
            sortDoneNum = lastSortDone;

            DataService.show(arr);
            //如果没有元素交换则代表剩下的都有序
            if (sortDone) {
                break;
            }
        }
    }

    /**
     * 优化了前部分在经过一段排序后已经有序的问题
     * @param arr
     */
    private static void sort2(int[] arr) {
        for (int i = 0,len = arr.length; i < len; i++) {
            //是否已经排序完毕
            boolean sortDone = true;
            for (int j = 0; j < len - i - 1; j++) {
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //有元素交换，则未完成排序
                    sortDone = false;
                }
            }
            DataService.show(arr);
            //如果没有元素交换则代表剩下的都有序
            if (sortDone) {
                break;
            }
        }
    }


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

}
