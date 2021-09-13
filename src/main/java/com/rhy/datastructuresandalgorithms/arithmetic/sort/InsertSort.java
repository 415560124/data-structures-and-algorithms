package com.rhy.datastructuresandalgorithms.arithmetic.sort;

/**
 * @author: Rhy
 * @date: 2021/8/18 17:32
 * @description: 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,6,2,4,1,8,9,7};
        insertSort(arr);
    }
    public static int[] insertSort(int[] arr){
        //因为第一个元素已经排序完了，所以从第二个开始
        for (int i = 1,len=arr.length; i < len; i++) {
            //记录当前比较到了第几个
            int index = i;
            //记录当前参与比较的数据
            int temp = arr[i];
            //从后往前遍历有序的数组
            for (int j = i-1; j >= 0; j--) {
                //从小到大排序，如果小于则交换位置
                if(temp < arr[j]){
                    index = j;
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[index] = temp;
            show(i,arr);
        }
        return arr;
    }

    public static void show(int num,int[] arr){
        System.out.print("第"+num+"次排序：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
}
