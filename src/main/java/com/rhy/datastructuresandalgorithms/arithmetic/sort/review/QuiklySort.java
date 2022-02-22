package com.rhy.datastructuresandalgorithms.arithmetic.sort.review;

import com.rhy.datastructuresandalgorithms.arithmetic.sort.DataService;

/**
 * @author: Rhy
 * @date: 2021/10/13 9:55
 * @description:
 */
public class QuiklySort {
    public static void main(String[] args) {
        final int[] arr = DataService.getArr();
        sort(arr,0,arr.length-1);
        DataService.show(arr);
    }
    public static void sort(int[] arr,int start,int end){
        if(start >= end){
            return;
        }
        int basicNum = arr[start];
        int left = start;
        int right = end;
        while (left < right){
            //从右边找是否有比基准数小的
            while (left < right && arr[right] >= basicNum){
                right--;
            }
            //说明因（arr[right] >= basicNum）条件不成立而进入
            if(left < right){
                arr[left] = arr[right];
                arr[right] = basicNum;
            }
            //从左边找是否有比基准数大的
            while (left < right && arr[left] <= basicNum){
                left++;
            }
            //说明因（arr[left] <= basicNum）条件不成立而进入
            if(left < right){
                arr[right] = arr[left];
                arr[left] = basicNum;
            }
        }
        DataService.show(arr);
        sort(arr,start,left-1);
        sort(arr,left+1,end);
    }
}
