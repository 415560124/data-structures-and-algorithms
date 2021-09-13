package com.rhy.datastructuresandalgorithms.arithmetic.sort;

/**
 * @author: Rhy
 * @date: 2021/8/24 11:00
 * @description: 选择排序
 */
public class ChooseSort {
    public static void main(String[] args) {
        int[] arr = DataService.getArr();
        sort(arr);
    }
    public static void sort(int[] arr){
        for (int i = 0,len = arr.length; i < len; i++) {
            //当前最小值下标
            int minIndex = i;
            for (int j = i+1; j < len; j++) {
                //如果找到更小的则记录一下
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            //把当前位置交还给最小的数
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            DataService.show(arr);
        }
    }
}
