package com.rhy.datastructuresandalgorithms.arithmetic.sort.review;

import com.rhy.datastructuresandalgorithms.arithmetic.sort.DataService;

/**
 * @author: Rhy
 * @date: 2021/10/14 15:09
 * @description: 归并排序复习
 */
public class MergeSort {
    public static void main(String[] args) {
        final int[] arr = DataService.getArr();
        splitAndMergeSort(arr,0,arr.length);
        DataService.show(arr);
    }
    public static void splitAndMergeSort(int[] arr,int start,int end){
        if(start >= end){
            return;
        }
        int middle = (start + end) / 2;
        System.out.println("开始拆分，左："+start+"-"+middle+"；右："+(middle+1)+"-"+end);
        //先拆分
        splitAndMergeSort(arr,start,middle);
        splitAndMergeSort(arr,middle+1,end);
        System.out.println("开始合并，左："+start+"-"+middle+"；右："+(middle+1)+"-"+end);
        //合并
        mergeSort(arr,start,middle,end);
    }

    private static void mergeSort(int[] arr, int start, int middle, int end) {
        //合并时采用插入排序，已排序区间则为 start~middle
        InsertSort.sort(arr,start,middle,end);
    }
}
