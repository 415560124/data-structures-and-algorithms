package com.rhy.datastructuresandalgorithms.arithmetic.sort;

import java.util.Random;

/**
 * @author: Rhy
 * @date: 2021/8/19 14:17
 * @description: 归并算法
 */
public class MergerSort {
    public static void main(String[] args) {
        int[] arr = new int[2000000];
        Random random = new Random();
        for (int i = 0; i < 2000000; i++) {
            arr[i] = random.nextInt(2000000);
        }
//        int[] arr = new int[]{5,3,6,2,4,1,8,9,7};
        final long start = System.currentTimeMillis();
        splitAndSort(arr,0,arr.length-1);
        System.out.println(System.currentTimeMillis() - start);
        show(arr);
    }

    public static void splitAndSort(int[] arr,int start,int end){
        //拆到一个元素为一组
        if (start < end) {
            int mid = (start + end) / 2;

//            System.out.print("左：");
//            System.out.print("【"+start+"】");
//            System.out.print("【"+mid+"】");
//            System.out.println();
            //递归拆分左元素
            splitAndSort(arr,start,mid);

//            System.out.print("右：");
//            System.out.print("【"+(mid+1)+"】");
//            System.out.print("【"+end+"】");
//            System.out.println();
            //递归拆分右元素
            splitAndSort(arr,mid+1,end);

//            System.out.print("开始合并");
//            System.out.print("【"+start+"】");
//            System.out.print("【"+mid+"】");
//            System.out.print("【"+(mid+1)+"】");
//            System.out.print("【"+end+"】");
//            System.out.println();
            //开始合并&排序
            mergeAndSort(arr,start,mid,end);
        }
    }

    public static void mergeAndSort(int[] arr, int start, int mid, int end) {
        //临时有序数组
        int[] tempArr = new int[end-start+1];
        //当前有序数组中的下标
        int index = 0;
        //左下标
        int pointLeft = start;
        //右下标
        int pointRight = mid+1;
        //开始依顺序往有序数组中放
        while (pointLeft <= mid && pointRight <= end){
            if(arr[pointLeft] < arr[pointRight]){
                //当左数组数小于右数组数，放左数
                //当前下标+1
                tempArr[index++] = arr[pointLeft];
                //左下标+1
                pointLeft++;
            }else{
                //当左数组数大于右数组数，放右数
                //当前下标+1
                tempArr[index++] = arr[pointRight];
                //右下标+1
                pointRight++;
            }
        }
        //合并左数组【未归并】的数
        for (; pointLeft <= mid; pointLeft++) {
            tempArr[index++] = arr[pointLeft];
        }
        //合并右数组【未归并】的数
        for (; pointRight <= end; pointRight++) {
            tempArr[index++] = arr[pointRight];
        }
        //排好序的数组合并回原数组
        for (int i = 0,len = tempArr.length; i < len; i++) {
            arr[i+start] = tempArr[i];
        }
//        show(arr);
    }
    public static void show(int[] arr){
        System.out.print("合并后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
}
