package com.rhy.datastructuresandalgorithms.sort;

import java.util.Arrays;

/**
 * @author: Rhy
 * @date: 2021/8/24 11:18
 * @description:
 */
public class DataService {
    public static int[] getArr(){
        return new int[]{5,3,6,2,4,1,8,9,7};
    }
    public static void show(int[] arr){
        System.out.print("排序后：");
        System.out.println(Arrays.toString(arr));
    }
}