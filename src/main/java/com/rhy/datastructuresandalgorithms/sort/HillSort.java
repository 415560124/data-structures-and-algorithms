package com.rhy.datastructuresandalgorithms.sort;

/**
 * @author: Herion Lemon
 * @date: 2021/8/18 19:52
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 希尔排序
 */
public class HillSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,8,6,3,9,2,1,7};
        sort(arr);
    }
    public static int[] sort(int[] arr){
        //数组长度
        int len = arr.length;
        //增量
        int inc = len / 2;
        int midLen = len / 2;
        while (inc > 0){
            for (int x = 0; x < midLen; x++) {
                //未排序的集合
                for (int i = x + inc; i < len; i +=inc) {
                    //待排序数
                    int temp = arr[i];
                    //当前交换的下标
                    int index = i;
                    //已排序的集合
                    for (int j = i - inc; j >= 0 ; j -=inc) {
                        //从小到大，如果小于则移位，继续往前比较
                        if(temp < arr[j]){
                            //当前交换的下标往前移动
                            index = j;
                            arr[j+inc] = arr[j];
                        }else {
                            //没有再比当前数更小的了
                            break;
                        }
                    }
                    arr[index] = temp;

                }
            }
            //输出一下
            show(inc,arr);
            inc /= 2;
        }
        return arr;
    }
    public static void show(int inc,int[] arr){
        System.out.print("增量【"+inc+"】排序后结果：");
        for (int i : arr) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
}
