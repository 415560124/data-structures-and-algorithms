package com.rhy.datastructuresandalgorithms.sort;

/**
 * @author: Herion Lemon
 * @date: 2021/9/4 20:37
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description:
 */
public class QuiklySort {
    public static void main(String[] args) {
        int[] arr = DataService.getArr();
        qsort(arr,0,arr.length-1);
//        qsort2(arr,0,arr.length-1);
    }

    /**
     * 快速排序
     * @param arr 待排序数组
     * @param start 开始下标
     * @param end 结束下标
     */
    public static void qsort(int[] arr,int start,int end){
        if(start >= end){
            return;
        }
        //排序位置的开始下标与结束下标
        System.out.println(start+"-"+end);

        int basic = arr[start];
        //左标
        int left = start;
        //右标
        int right = end;
        while (left < right){
            //从后往前找比基准数小的
            while (left < right && arr[right] >= basic){
                right--;
            }
            //说明找到了比基准数小的，开始交换位置
            if(left < right){
                arr[left] = arr[right];
                arr[right] = basic;
                left++;
            }
            //从前往后找比基准数大的
            while (left < right && arr[left] <= basic){
                left++;
            }
            //找到了比基准数大的，开始交换位置
            if(left < right){
                arr[right] = arr[left];
                arr[left] = basic;
                right--;
            }
        }
        DataService.show(arr);
        qsort(arr,start,left-1);
        qsort(arr,left+1,end);
    }




    /**
     * 快速排序
     * @param arr 待排序数组
     * @param start 开始下标
     * @param end 结束下标
     */
    public static void qsort2(int[] arr,int start,int end){
        if(start >= end){
            return;
        }
        int basicNum = arr[start];
        int left = start;
        int right = end;
        while (left < right){
            while (left < right && arr[right] >= basicNum){
                right--;
            }
            if(left < right){
                arr[left] = arr[right];
                arr[right] = basicNum;
                left++;
            }
            while (left < right && arr[left] <= basicNum){
                left++;
            }
            if(left < right){
                arr[right] = arr[left];
                arr[left] = basicNum;
                right--;
            }
        }
        DataService.show(arr);
        qsort2(arr,start,left-1);
        qsort2(arr,left+1,end);
    }
}
